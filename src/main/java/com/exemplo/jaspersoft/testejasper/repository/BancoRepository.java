package com.exemplo.jaspersoft.testejasper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.jaspersoft.testejasper.entity.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {

}
