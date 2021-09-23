package com.exemplo.jaspersoft.testejasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.jaspersoft.testejasper.entity.Banco;
import com.exemplo.jaspersoft.testejasper.repository.BancoRepository;


@Service
public class BancoService {

	@Autowired 
	private BancoRepository bancoRepository;
	
	public List<Banco> listarTodos () {
		return bancoRepository.findAll();
		
		
	}
	
}
