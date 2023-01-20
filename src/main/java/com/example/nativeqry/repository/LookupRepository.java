package com.example.nativeqry.repository;

import com.example.nativeqry.enity.Lookup;
import com.example.nativeqry.enity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, String> {

    @Query("SELECT lp FROM Lookup lp WHERE lp.overseasLookupId = ?1")
    Lookup findDomesticLookupByInstId(String instrId);

    @Query("SELECT lp FROM Lookup lp WHERE lp.overseasLookupInstructionId = ?1")
    Lookup findOverseasLookupByInstId(String instrId);

    @Query("SELECT lp FROM Lookup lp WHERE lp.proxyOnlyId = ?1")
    Lookup findOverseasLookupByProxyOnlyId(String proxyOnlyId);

    @Query("SELECT lp.linkage FROM Lookup lp WHERE lp.overseasLookupInstructionId = ?1")
    String findLinkageCodeByOverseasId(String instrId);

    @Query("SELECT lp FROM Lookup lp WHERE lp.transactionStatus = ?1 AND lp.lastUpdatedOn < ?2 and lp.proxyOnlyId is not null")
    List<Lookup> findByTransactionStatusAndLastUpdatedOn(TransactionStatus transactionStatus, Date lastUpdatedOn);

    @Query(nativeQuery = true, value = "SELECT * from xb_sw_lookup")
    List<Lookup> findX(TransactionStatus transactionStatus, long timeoutInterval);

/*
    @Query(nativeQuery = true, value = "SELECT l.* from xb_sw_lookup l inner join xb_sw_domestic_lookup dl " +
            "on l.domestic_lookup_id = dl.ID " +
            "where dl.REQ_SENDER_AGT in (" +
            "select PARTICIPANT_BIC from xb_sg_participants " +
            "where OUTBOUND_STATUS='ACTIVE') " +
            "and l.TRANSACTION_STATUS= ?1 "
            +"and l.LAST_UPDATED_ON < (NOW() - INTERVAL ?2 SECOND)"
    )
    List<Lookup> findDomesticLookupByTransactionStatusAndLastUpdatedOn(String transactionStatus, long timeoutInterval);


    @Query(nativeQuery = true,
            value = "select l.* from xb_sw_lookup l inner join xb_sw_overseas_lookup ol" +
                    " on l.OVERSEAS_LOOKUP_ID = ol.ID" +
                    "  where ol.REQ_SENDER_AGENT in (" +
                    "    select PARTICIPANT_BIC from xb_overseas_participants " +
                    "    where INBOUND_STATUS='ACTIVE') and l.TRANSACTION_STATUS= ?1 and l.LAST_UPDATED_ON < (NOW() - INTERVAL 120 SECOND)")
    List<Lookup> findOverseasLookupByTransactionStatusAndLastUpdatedOn(TransactionStatus transactionStatus, long timeoutInterval);
*/

    @Query(nativeQuery = true,
            value="select l.* from xb_sw_lookup l inner join xb_sw_overseas_lookup ol" +
                    " on l.OVERSEAS_LOOKUP_ID = ol.ID" +
                    "  where ol.REQ_SENDER_AGENT in (" +
                    "    select PARTICIPANT_BIC from xb_overseas_participants " +
                    "    where INBOUND_STATUS='ACTIVE') and l.TRANSACTION_STATUS= ?1 and l.LAST_UPDATED_ON < ?2")
    List<Lookup> findOverseasLookupByTransactionStatusAndLastUpdatedOn(String transactionStatus, ZonedDateTime lastUpdatedDate);

}
