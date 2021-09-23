package com.exemplo.jaspersoft.testejasper.report;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Ato;
import com.exemplo.jaspersoft.testejasper.entity.Banco;
import com.exemplo.jaspersoft.testejasper.repository.AtoRepository;
import com.exemplo.jaspersoft.testejasper.service.BancoService;

@Component
public class Teste7 {
	
	@Autowired
	private AtoRepository atoRepository; 
	
	@Autowired
	private BancoService bancoService;
	

	public void gerarRelatorioTeste7(String destino, String origem, BigDecimal valorFinal, Date dataInicioVigencia) {
		
		List<Ato> l = this.atoRepository.findByValorFinalAndInicioVigencia(valorFinal, dataInicioVigencia); 
		System.out.println(l.size());
		
		List<Banco> lb = this.bancoService.listarTodos();
		System.out.println(lb.size());
		
	}
	
	

}
