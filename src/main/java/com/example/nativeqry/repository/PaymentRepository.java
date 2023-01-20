package com.example.nativeqry.repository;

import com.example.nativeqry.enity.Payment;
import com.example.nativeqry.enity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String>{

	@Query("SELECT lp FROM Payment lp WHERE lp.singaporePmentInstrId = ?1")
	Payment findDomesticPaymentByInstId(String instrId);

	@Query("SELECT lp FROM Payment lp WHERE lp.overseasPmentInstrId = ?1")
	Payment findOverseasPaymentByInstId(String instrId);

	@Query("SELECT lp.linkage FROM Payment lp WHERE lp.overseasPmentInstrId = ?1")
	String findLinkageCodeByOverseasPmentInstrId(String instrId);

	//Optional<List<Payment>> findByStatusAndLastUpdatedOn(String status, Date lateUpdatedOn);

  List<Payment> findTop100ByEtlFlagIsNullAndLinkageIs(String linkageValue);

  List<Payment> findByLastUpdatedOnBeforeAndEtlFlagNotNull(Date date);

	//FIXME  Native query is used to delete cause Datatype is misaligned in some fields. Use JPA once its fixed
	@Modifying
	@Query(value = "DELETE FROM payment p WHERE p.id IN ?1",nativeQuery = true)
	void deleteByIdIn(List<String> ids);

    //TODO: Fixme ->write native query
    //@Query(value = "SELECT p FROM Payment p INNER JOIN p.domesticPayment dp  INNER JOIN p.overseasPayment op  where dp.ctInstrId= ?1 or op.ctInstrId= ?1")
    Payment getDetailsById(String pathId);

	//Refactor me
	@Query("select p from Payment p  " +
			"where p.direction= ?1 " +
			"and p.transactionStatus= ?2 " +
			"and p.overseasPmentId is not null "+
			"and p.lastUpdatedOn < ?3 "+
			"and (p.paymentInquiryRetryCount IS NULL OR p.paymentInquiryRetryCount <  ?4) "
			)
	List<Payment> findPaymentByTxnStsAndDirectionAndPymtInqryRetryCnt(
			String direction,
			TransactionStatus transactionStatus,
			Timestamp expiredRecordTimestamp,
			int pymntInqryRetryCnt);

}