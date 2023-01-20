package com.example.nativeqry.enity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@DynamicUpdate
public class Payment {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")    
    @Column(name = "ID", nullable = false, length = 45)
    private String id;

    @Column(name = "STATUS", length = 45)
    private String status;

    @Column(name = "LINKAGE", length = 45)
    private String linkage;

    @Column(name = "SINGAPORE_PMENT_ID", length = 45)
    private String singaporePmentId;

    @Column(name = "OVERSEAS_PMENT_ID", length = 45)
    private String overseasPmentId;

    @Column(name = "SINGAPORE_PMENT_INSTR_ID", length = 45)
    private String singaporePmentInstrId;

    @Column(name = "OVERSEAS_PMENT_INSTR_ID", length = 45)
    private String overseasPmentInstrId;

    @Column(name = "FAST_INSTR_ID", length = 45)
    private String fastInstrId;

    @Column(name = "GW_PMENT_REQ_RECEIV_TIME")
    private Timestamp gwPmentReqReceivTime;

    @Column(name = "GW_SCREENING_REQ_GEN_TIME")
    private Timestamp gwScreeningReqGenTime;

    @Column(name = "GW_SCREENING_RES_RECEIV_TIME")
    private Timestamp gwScreeningResReceivTime;

    @Column(name = "GW_SETTL_CHECK_REQ_GEN_TIME")
    private Timestamp gwSettlCheckReqGenTime;

    @Column(name = "GW_SETTL_CHECK_RES_RECEIV_TIME")
    private Timestamp gwSettlCheckResReceivTime;

    @Column(name = "GW_PMENT_REQ_GEN_TIME")
    private Timestamp gwPmentReqGenTime;

    @Column(name = "GW_PMENT_RES_RECEIV_TIME")
    private Timestamp gwPmentResReceivTime;

    @Column(name = "GW_PMENT_REQ_COMPL_TIME")
    private Timestamp gwPmentReqComplTime;

    @Column(name = "CREATED_ON")
    private Timestamp createdOn;

    @Column(name = "LAST_UPDATED_ON")
    private Timestamp lastUpdatedOn;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSACTION_STATUS", length = 45)
    private TransactionStatus transactionStatus;

    @Column(name = "TXN_STATUS_ERROR_CODE", length = 45)
    private String txnStatusErrorCode;

    @Column(name = "DIRECTION", length = 45)
    private String direction;

    @Column(name = "PAYMENT_INQUIRY_RETRY_COUNT")
    private Integer paymentInquiryRetryCount;

    @Column(name = "ETL_FLAG",length = 20)
    private String etlFlag;

    @Column(name = "BATCH_ID")
    private String batchID;

    @Column(name = "RECONSILE_FLAG")
    private String recocile_flag;
}