package com.example.nativeqry.controller;

import com.example.nativeqry.repository.DomesticPaymentRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DomesticPaymentController {
    public static final String OUTBOUND = "OUTBOUND";

    private final DomesticPaymentRepositoryImpl domesticPaymentRepository;

    @GetMapping("/domestic_payment")
    public void readDM() throws InterruptedException {
        Instant old = Instant.now();

        Thread.sleep(3000);
        Instant now = Instant.now();

        System.out.println("old " + old + " from now " + now + " old isBefore now " + old.isBefore(now) + " old isAfter now " + old.isAfter(now));
        Timestamp from = Timestamp.from(now);

        System.out.println("now " + now + " from timestamp " + from);
        List<String> orphanFastTransactions = domesticPaymentRepository.findNoResponseFastTransactions(from, 2);
        System.out.println("paymetn list " + orphanFastTransactions.size());
        orphanFastTransactions.forEach(System.out::println);
    }

}
