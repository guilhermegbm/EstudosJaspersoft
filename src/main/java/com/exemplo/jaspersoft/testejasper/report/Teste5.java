package com.exemplo.jaspersoft.testejasper.report;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Ato;
import com.exemplo.jaspersoft.testejasper.repository.AtoRepository;

@Component
public class Teste5 {

	@Autowired
	private AtoRepository atoRepository;
	
	public void gerarRelatorioTeste5(String destino, String origem, BigDecimal valorFinal, Date dataInicioVigencia) throws Exception {

		List<Ato> l = this.atoRepository.findByValorFinalAndInicioVigencia(valorFinal, dataInicioVigencia); 
		System.out.println(l.size());
		RelatorioPdfUtil.printDecompiledReportWithCustomCollectionDataSource(destino, origem, null, l);
		

	}
	
	

}
