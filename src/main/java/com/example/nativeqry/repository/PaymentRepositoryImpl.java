package com.example.nativeqry.repository;

import com.example.nativeqry.enity.Lookup;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
@AllArgsConstructor
public class PaymentRepositoryImpl {
    public static final String UPDATE_PYMNT_INQUIRY_CNT = "update payment set last_updated_on=CURRENT_TIMESTAMP , payment_inquiry_retry_count=? where id=? and payment_inquiry_retry_count=?";

    public static final String UPDATE_PYMNT_INQUIRY_CNT_WHEN_INQUIRY_CNT_NULL = "update payment set last_updated_on=CURRENT_TIMESTAMP , payment_inquiry_retry_count=? where id=? and payment_inquiry_retry_count is NULL";
    private JdbcTemplate jdbcTemplate;

    public int updatPaymentEnqCount(String paymentId, Integer currentInqryCnt) {
        int incrementInqryCount = 0;
        int updatedRows = -1;
        if (currentInqryCnt != null) {
            incrementInqryCount = currentInqryCnt + 1;
            int[] types = {Types.INTEGER, Types.VARCHAR, Types.INTEGER};
            Object[] params = {incrementInqryCount, paymentId, currentInqryCnt};
            log.info("updatPaymentEnqCount paymentId {} currentInqryCnt {} incrementInqryCount {} ", paymentId, currentInqryCnt, incrementInqryCount);
            updatedRows = jdbcTemplate.update(UPDATE_PYMNT_INQUIRY_CNT, params, types);
        } else {
            int[] types = {Types.INTEGER, Types.VARCHAR};
            Object[] params = {incrementInqryCount, paymentId};
            log.info("updatPaymentEnqCount paymentId {} currentInqryCnt {} incrementInqryCount {} ", paymentId, currentInqryCnt, incrementInqryCount);
            updatedRows = jdbcTemplate.update(UPDATE_PYMNT_INQUIRY_CNT_WHEN_INQUIRY_CNT_NULL, params, types);
        }
        log.info("updated payment record updatedRows {} ",  updatedRows);
        return updatedRows;
    }

    public List findPendingLookupToReject(String lookupId) {
        int updatedRows = -1;
        int[] types = {Types.VARCHAR};
        Object[] params = { lookupId};
        log.info("updatPendingLookupToReject lookupId {} currentDate {}  ", lookupId);
        List<Lookup> query = jdbcTemplate.query("select * from xb_sw_lookup where id=? and transaction_status='PDNG'", params, types, new BeanPropertyRowMapper(Lookup.class));
        log.info("updated updatPendingLookupToReject record updatedRows {} ", query);
        return query;
    }
}
