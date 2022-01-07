package com.exemplo.jaspersoft.testejasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.jaspersoft.testejasper.entity.Empresa;
import com.exemplo.jaspersoft.testejasper.entity.Funcionario;
import com.exemplo.jaspersoft.testejasper.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> listarTodos() {
		return this.funcionarioRepository.findAll();
	}

	public List<Funcionario> listarPorEmpresa(Empresa e) {
		return this.funcionarioRepository.findByEmpresa(e);
	}
}
