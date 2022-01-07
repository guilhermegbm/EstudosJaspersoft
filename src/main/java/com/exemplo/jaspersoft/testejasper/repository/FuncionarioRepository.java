package com.exemplo.jaspersoft.testejasper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exemplo.jaspersoft.testejasper.entity.Empresa;
import com.exemplo.jaspersoft.testejasper.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Query(value = "from Funcionario f where f.empresa = :empresa")
	List<Funcionario> findByEmpresa(@Param("empresa") Empresa empresa);

}
