package com.exemplo.jaspersoft.testejasper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exemplo.jaspersoft.testejasper.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
