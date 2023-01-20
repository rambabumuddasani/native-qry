package com.example.nativeqry.enity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "XB_SW_LOOKUP")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@DynamicUpdate
public class Lookup {

    @Id
    private String id;

    private String status;

    private String linkage;

    private String proxyOnlyId;

    private String overseasLookupId;

    private String domesticLookupId;

    private String overseasLookupInstructionId;

    private Date gwRequestReceivedTime;
    private Date gwRequestGeneratedTime;
    private Date gwResponseReceivedTime;
    private Date gwRequestCompletedTime;
    private Date createdOn;
    private Date lastUpdatedOn;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSACTION_STATUS", length = 45)
    private TransactionStatus transactionStatus;

}