package com.example.nativeqry.enity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "domestic_payment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DomesticPayment {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")    
    @Column(name = "ID", nullable = false, length = 45)
    private String id;

    @Column(name = "CT_BIZ_MSG_IDENTIFIER", length = 45)
    private String ctBizMsgIdentifier;

    @Column(name = "CT_MSG_DEF_IDENTIFIER", length = 45)
    private String ctMsgDefIdentifier;

    @Column(name = "CT_MSG_ID", length = 45)
    private String ctMsgId;

    @Column(name = "CT_INSTRUCTING_AGENT", length = 45)
    private String ctInstructingAgent;

    @Column(name = "CT_INSTRUCTED_AGENT", length = 45)
    private String ctInstructedAgent;

    @Column(name = "CT_DEBTOR_AGENT", length = 45)
    private String ctDebtorAgent;

    @Column(name = "CT_CREDITOR_AGENT", length = 45)
    private String ctCreditorAgent;

    @Column(name = "CT_SETTL_BANK", length = 45)
    private String ctSettlBank;

    @Column(name = "CT_CREATED_DT_TIME")
    private Date ctCreatedDtTime;

    @Column(name = "CT_TOTAL_SETTL_AMT")
    private Double ctTotalSettlAmt;

    @Column(name = "CT_TOTAL_SETTL_AMT_CCY", length = 45)
    private String ctTotalSettlAmtCcy;

    @Column(name = "CT_SETTL_METHOD", length = 45)
    private String ctSettlMethod;

    @Column(name = "CT_CLEARING_SYSTEM_PARTY", length = 45)
    private String ctClearingSystemParty;

    @Column(name = "CT_INSTR_ID", length = 45)
    private String ctInstrId;

    @Column(name = "CT_ENDTOEND_ID", length = 45)
    private String ctEndtoendId;

    @Column(name = "CT_TRANSACTION_ID", length = 45)
    private String ctTransactionId;

    @Column(name = "CT_UETR", length = 45)
    private String ctUetr;

    @Column(name = "CT_CLEARING_SYSTEM_REFERENCE", length = 45)
    private String ctClearingSystemReference;

    @Column(name = "CT_SERVICE_LEVEL_CODE", length = 45)
    private String ctServiceLevelCode;

    @Column(name = "CT_CATEGORY_PURPOSE_CODE", length = 45)
    private String ctCategoryPurposeCode;

    @Column(name = "CT_INBANK_SETTL_AMT", length = 45)
    private String ctInbankSettlAmt;

    @Column(name = "CT_INBANK_SETTL_AMT_CCY", length = 45)
    private String ctInbankSettlAmtCcy;

    @Column(name = "CT_INBANK_SETTL_DT", length = 45)
    private String ctInbankSettlDt;

    @Column(name = "CT_INSTRUCTED_AMT", length = 45)
    private String ctInstructedAmt;

    @Column(name = "CT_INSTRUCTED_AMT_CCY", length = 45)
    private String ctInstructedAmtCcy;

    @Column(name = "CT_EXCHANGE_RATE", length = 45)
    private String ctExchangeRate;

    @Column(name = "CT_CHARGE_BEARER", length = 45)
    private String ctChargeBearer;

    @Column(name = "CT_DEBTOR_NAME", length = 45)
    private String ctDebtorName;

    @Column(name = "CT_DEBTOR_ADDRESS", length = 45)
    private String ctDebtorAddress;

    @Column(name = "CT_DEBTOR_COUNTRY", length = 45)
    private String ctDebtorCountry;

    @Column(name = "CT_DEBTOR_ACCOUNT_ID", length = 45)
    private String ctDebtorAccountId;

    @Column(name = "CT_CREDITOR_NAME", length = 45)
    private String ctCreditorName;

    @Column(name = "CT_CREDITOR_ADDRESS", length = 45)
    private String ctCreditorAddress;

    @Column(name = "CT_CREDITOR_COUNTRY", length = 45)
    private String ctCreditorCountry;

    @Column(name = "CT_CREDITOR_ACCOUNT_ID", length = 45)
    private String ctCreditorAccountId;

    @Column(name = "CT_ULTIMATE_CREDITOR_NAME", length = 45)
    private String ctUltimateCreditorName;

    @Column(name = "CT_PROXY_TYPE", length = 45)
    private String ctProxyType;

    @Column(name = "CT_PROXY_VALUE", length = 45)
    private String ctProxyValue;

    @Column(name = "CT_PURPOSE_CODE", length = 45)
    private String ctPurposeCode;

    @Column(name = "CT_IFSC_CD", length = 45)
    private String ctIfscCd;

    @Column(name = "CT_RMT_INFO", length = 45)
    private String ctRmtInfo;

    @Column(name = "CT_NO_OF_TXNS")
    private int ctNoOfTxns;

    @Column(name = "PS_BIZ_MSG_IDENTIFIER", length = 45)
    private String psBizMsgIdentifier;

    @Column(name = "PS_MSG_IDENTIFIER", length = 45)
    private String psMsgIdentifier;

    @Column(name = "PS_MSG_DEF_IDENTIFIER", length = 45)
    private String psMsgDefIdentifier;

    @Column(name = "PS_CREATED_DT_TIME")
    private Date psCreatedDtTime;

    @Column(name = "PS_INSTRUCTING_AGENT", length = 45)
    private String psInstructingAgent;

    @Column(name = "PS_INSTRUCTED_AGENT", length = 45)
    private String psInstructedAgent;

    @Column(name = "PS_ORIGI_MSG_ID", length = 45)
    private String psOrigiMsgId;

    @Column(name = "PS_ORIGI_MSG_PACS", length = 45)
    private String psOrigiMsgPacs;

    @Column(name = "PS_ORIGI_MSG_CREATED_DT_TIME", length = 45)
    private Date psOrigiMsgCreatedDtTime;

    @Column(name = "PS_ORIGI_TXN_INSTR_ID", length = 45)
    private String psOrigiTxnInstrId;

    @Column(name = "PS_ORIGI_END_TO_END_ID", length = 45)
    private String psOrigiEndToEndId;

    @Column(name = "PS_ORIGI_TRANSACTION_ID", length = 45)
    private String psOrigiTransactionId;

    @Column(name = "PS_ORIGI_UETR", length = 45)
    private String psOrigiUetr;

    @Column(name = "PS_TRANSACTION_STATUS", length = 45)
    private String psTransactionStatus;

    @Column(name = "PS_TRANSACTION_REASON_CODE", length = 45)
    private String psTransactionReasonCode;

    @Column(name = "PS_ACCEPTED_DT_TIME", length = 45)
    private String psAcceptedDtTime;

    @Column(name = "PS_ORIGI_TXN_INBANK_SETTL_AMT", length = 45)
    private String psOrigiTxnInbankSettlAmt;

    @Column(name = "PS_ORIGI_TXN_INBANK_SETTL_CCY", length = 45)
    private String psOrigiTxnInbankSettlCcy;

    @Column(name = "PS_ORIGI_TXN_INBANK_SETTL_DT", length = 45)
    private String psOrigiTxnInbankSettlDt;

    @Column(name = "PS_ORIGI_TXN_SETTL_BANK", length = 45)
    private String psOrigiTxnSettlBank;

    @Column(name = "PS_ORIGI_TXN_DEBTOR_AGENT", length = 45)
    private String psOrigiTxnDebtorAgent;

    @Column(name = "PS_ORIGI_TXN_CREDITOR_AGENT", length = 45)
    private String psOrigiTxnCreditorAgent;

    @Column(name = "FAST_INSTR_ID", length = 45)
    private String fastInstrId;

    @Column(name = "FAST_END_TO_END_ID", length = 45)
    private String fastEndToEndId;

    @Column(name = "FAST_TXID", length = 45)
    private String fastTxid;

    @Column(name = "FAST_INSTG_AGT", length = 45)
    private String fastInstgAgt;

    @Column(name = "FAST_INSTD_AGT", length = 45)
    private String fastInstdAgt;

    @Column(name = "FAST_DBTR_AGT", length = 45)
    private String fastDbtrAgt;

    @Column(name = "FAST_CDTR_AGT", length = 45)
    private String fastCdtrAgt;

    @Column(name = "FAST_SETTL_DT", length = 45)
    private String fastSettlDt;

    @Column(name = "FAST_SETTL_CYCLE", length = 45)
    private String fastSettlCycle;

    @Column(name = "SCREENING_STATUS", length = 45)
    private String screeningStatus;

    @Column(name = "SCREENING_REASON_CODE", length = 45)
    private String screeningReasonCode;

    @Column(name = "FAST_STATUS", length = 45)
    private String fastStatus;

    @Column(name = "FAST_REASON_CODE", length = 45)
    private String fastReasonCode;

    @Column(name = "SETTL_CHECK_STATUS", length = 45)
    private String settlCheckStatus;

    @Column(name = "SETTL_CHECK_REASON_CODE", length = 45)
    private String settlCheckReasonCode;

    @Column(name = "CREATED_ON")
    private Timestamp createdOn;

    @Column(name = "LAST_UPDTD_ON")
    private Timestamp lastUpdtdOn;
    
    @Column(name = "PS_CLEARING_SYSTEM_REFERENCE", length = 45)
    private String psClearingSystemReference;

}