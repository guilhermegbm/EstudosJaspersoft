package com.exemplo.jaspersoft.testejasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.jaspersoft.testejasper.entity.Empresa;
import com.exemplo.jaspersoft.testejasper.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<Empresa> listarTodas() {
		return this.empresaRepository.findAll();
	}
}
