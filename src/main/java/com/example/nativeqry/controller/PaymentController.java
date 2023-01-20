package com.example.nativeqry.controller;

import com.example.nativeqry.enity.Payment;
import com.example.nativeqry.repository.PaymentRepositoryImpl;
import com.example.nativeqry.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.nativeqry.enity.TransactionStatus;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    public static final String OUTBOUND = "OUTBOUND";

    private final PaymentRepository paymentRepository;

    private final PaymentRepositoryImpl paymentDAO;

    @Value("${sg.time.diff.in.sec:50}")
    private long sgTimeDiffInSec;

    @GetMapping("/getval")
    public String getVal(){
        return "getVal "+sgTimeDiffInSec;
    }
    @GetMapping("/readPayment")
    public void read() throws InterruptedException {
        Instant old = Instant.now();

        Thread.sleep(3000);
        Instant now = Instant.now();

        System.out.println("old "+old+" from now "+now+" old isBefore now "+old.isBefore(now) +" old isAfter now "+old.isAfter(now));
        Timestamp from = Timestamp.from(now);

        System.out.println("now "+now+" from timestamp "+from);
        List<Payment> paymentList = paymentRepository.findPaymentByTxnStsAndDirectionAndPymtInqryRetryCnt(
                OUTBOUND, TransactionStatus.PDNG, from,3);
        System.out.println("paymetn list "+paymentList.size());
        paymentList.forEach(System.out::println);
    }

    @GetMapping("/updatePayment")
    public void updatePayment() throws InterruptedException {
        Payment payment = paymentRepository.findOverseasPaymentByInstId("20220309211546ICICINBBNRI9000013196");// 067f883f-5b03-4b1f-9b80-99a1de892028
        payment.setBatchID("somebatch "+ UUID.randomUUID().toString());
        paymentRepository.saveAndFlush(payment);
//        int updatPaymentEnqCount = paymentDAO.updatPaymentEnqCount(payment.getId(), payment.getPaymentInquiryRetryCount());
        System.out.println("payment "+payment);
    }

    @GetMapping("/findPendingLookupToReject")
    public void findPendingLookupToReject() throws InterruptedException {
        List pendingLookupToReject = paymentDAO.findPendingLookupToReject("019010b5-2092-4be1-a766-ad66a76003ea");
        System.out.println("updatedPyament Enq count "+pendingLookupToReject);
    }



    }
