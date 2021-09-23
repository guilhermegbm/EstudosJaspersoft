package com.exemplo.jaspersoft.testejasper.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exemplo.jaspersoft.testejasper.entity.Ato;

public interface AtoRepository extends JpaRepository<Ato, Long> {
	
	@Query (value = "FROM Ato a WHERE a.valorFinal >= :valorFinal and a.inicioVigencia = :dataInicioVigencia")
	List<Ato> findByValorFinalAndInicioVigencia (@Param("valorFinal")BigDecimal valorFinal, @Param("dataInicioVigencia")Date dataInicioVigencia); 
	
	

}
