package com.example.nativeqry.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;

@Repository
@AllArgsConstructor
public class DomesticPaymentRepositoryImpl {

    private static final String QRY = "select d.ctInstrId from DomesticPayment d WHERE d.fastInstrId is not null and d.fastReasonCode is null and d.lastUpdtdOn  < ?1 ORDER BY d.fastInstrId DESC";
    private EntityManager entityManager;

    public List<String> findNoResponseFastTransactions(Timestamp expiredRecordTimestamp, int limit) {
        return entityManager.createQuery(QRY, String.class)
                .setParameter(1, expiredRecordTimestamp)
                .setMaxResults(limit).getResultList();
    }
}
