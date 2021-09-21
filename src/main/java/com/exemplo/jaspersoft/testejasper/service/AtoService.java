package com.exemplo.jaspersoft.testejasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.exemplo.jaspersoft.testejasper.entity.Ato;
import com.exemplo.jaspersoft.testejasper.repository.AtoRepository;

@Service
public class AtoService {

	@Autowired
	private AtoRepository atoRepository;

	@Autowired
	private ResourceLoader resourceLoader;

	public List<Ato> listarTodos() {
		return this.atoRepository.findAll();
	}



	public void gerarReportListarTodos() throws Exception {

	}
}
