package com.exemplo.jaspersoft.testejasper.report;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Ato;
import com.exemplo.jaspersoft.testejasper.repository.AtoRepository;

@Component
public class Teste6 {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	
	@Autowired
	private AtoRepository atoRepository;
	
	public void gerarRelatorioTeste6(String destino, String origem, BigDecimal valorFinal, Date dataInicioVigencia, BigDecimal issqn, int tabela) throws Exception {
		
		Map<String, Object> parametros = new HashMap<String, Object>(); 
		
		String pathImagem = resourceLoader.getResource("classpath:imagens/logo.jpeg").getURL().toString();
		System.out.println(pathImagem);
		
		parametros.put("ISSQN", issqn); 
		parametros.put("DATA_INICIO_VIGENCIA", dataInicioVigencia);
		parametros.put("TABELA", tabela);
		parametros.put("PATH_IMAGEM", pathImagem);
		
		List<Ato> l = this.atoRepository.findByValorFinalAndInicioVigencia(valorFinal, dataInicioVigencia); 
		System.out.println(l.size());
		RelatorioPdfUtil.printDecompiledReportWithCustomCollectionDataSource(destino, origem, parametros, l);
		
		
	}

}
