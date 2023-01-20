package com.example.nativeqry.controller;

import com.example.nativeqry.enity.Lookup;
import com.example.nativeqry.enity.TransactionStatus;
import com.example.nativeqry.repository.LookupRepository;
import com.example.nativeqry.service.DataSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
public class LookupController {

    @Value("${axway.flag_on}")
    private String axwayFlagOn;

    @Value("${axway.base_url}")
    private String axwayBaseUrl;

    private PlatformTransactionManager transactionManager;

    public static final String ASIA_SINGAPORE = "Asia/Singapore";
    public static final ZoneId SG_ZONE_ID = ZoneId.of(ASIA_SINGAPORE);

    public static ZonedDateTime getZonedDateTime() {
        return ZonedDateTime.now(SG_ZONE_ID);
    }

    private final DataSecurityService dataSecurityService;
    private final LookupRepository lookupRepository;

    @GetMapping("/url")
    private String getPropValue(){
        return "axwayBaseUrl "+axwayBaseUrl+" flag on "+axwayFlagOn+" isAxwayGw() "+isAxwayGw();
    }

    @GetMapping("/encrypt/{plain}")
    private String enc(@PathVariable String plain){
        return dataSecurityService.encryption(plain);
    }

    @GetMapping("/decrypt/{enc}")
    private String dec(@PathVariable String enc){
        enc="EjZUuTq/9A8jRy3y47g+6BfWt7d36g4EgIbrwjawmO7NWFOVRH0SD+3fjnGpIwZ27pQ/gzFfod0=";
        return dataSecurityService.decryption(enc);
    }

    private boolean isAxwayGw() {
        return axwayFlagOn != null ? Boolean.valueOf(axwayFlagOn) : false;
    }

    @GetMapping("/get_all")
    public List<Lookup> getAllByQry(){
        ZonedDateTime d = getPastDate(120l);
        System.out.println("d "+d);
        List<Lookup> domesticLookupByTransactionStatusAndLastUpdatedOn = lookupRepository.findOverseasLookupByTransactionStatusAndLastUpdatedOn(TransactionStatus.PDNG.toString(), d);
        domesticLookupByTransactionStatusAndLastUpdatedOn.stream().skip(1).forEach(e -> {
            e.setLastUpdatedOn(new Date());
            lookupRepository.saveAndFlush(e);
        });
/*
        List<Date> collect = domesticLookupByTransactionStatusAndLastUpdatedOn.stream().map(e -> e.getLastUpdatedOn()).collect(Collectors.toList());

        List<ZonedDateTime> zonedDateTimes = collect.stream().map(e -> getZonedDateTimeFromDate(e)).collect(Collectors.toList());
        System.out.println("date time data "+collect+" zonedDateTimes "+zonedDateTimes);
*/
        return domesticLookupByTransactionStatusAndLastUpdatedOn;
    }

    public static ZonedDateTime getZonedDateTimeFromDate(Date date){
        if(date == null) {
            return getZonedDateTime();
        }
        return ZonedDateTime.ofInstant(date.toInstant(), SG_ZONE_ID);
    }
    @GetMapping("/get_all2")
    public List<Lookup> getAll2ByQry(){
//        List<Lookup> domesticLookupByTransactionStatusAndLastUpdatedOn = (List<Lookup>) lookupRepository.findAll();
        List<Lookup> x = lookupRepository.findX(TransactionStatus.PDNG, 2);
        return x;
    }

    private ZonedDateTime getPastDate(Long durationInSeconds) {
        ZonedDateTime dateTime = getZonedDateTime();
        if (durationInSeconds != null) {
            dateTime = dateTime.minus(Duration.of(durationInSeconds, ChronoUnit.SECONDS));
        }
        return dateTime;
    }
/*    public Date getPastDate(long durationInSeconds){
        LocalDateTime dateTime = LocalDateTime.now().minus(Duration.of(durationInSeconds, ChronoUnit.SECONDS));
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }*/
}
