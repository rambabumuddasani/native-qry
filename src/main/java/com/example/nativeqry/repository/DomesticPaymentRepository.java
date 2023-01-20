package com.example.nativeqry.repository;

import com.example.nativeqry.enity.DomesticPayment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DomesticPaymentRepository extends CrudRepository<DomesticPayment, String>{
	@Query("SELECT dp FROM DomesticPayment dp WHERE dp.ctInstrId = ?1")
	DomesticPayment findPaymentByInstId(String instrId);

	@Query("SELECT dp.ctInstructingAgent FROM DomesticPayment dp WHERE dp.ctInstrId = ?1")
	String findCtInstructingAgentByInstId(String instrId);

	//FIXME  Native query is used to delete cause Datatype is misaligned in some fields. Use JPA once its fixed
	@Modifying
	@Query(value = "DELETE FROM domestic_payment p WHERE p.id IN ?1",nativeQuery = true)
	void deleteByIdIn(List<String> ids);

}