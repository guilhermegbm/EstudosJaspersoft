package com.exemplo.jaspersoft.testejasper.report;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Ato;
import com.exemplo.jaspersoft.testejasper.repository.AtoRepository;


import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class Teste7 {
	
	@Autowired
	private AtoRepository atoRepository; 
	

	


	public void gerarRelatorioTeste7(String destino, String origem, BigDecimal valorFinal, Date dataInicioVigencia) throws Exception {
		
		Map<String, Object> parametros = new HashMap<String, Object>(); 

		
		
		List<Ato> l = this.atoRepository.findByValorFinalAndInicioVigencia(valorFinal, dataInicioVigencia); 
		System.out.println(l.size());
		
//		List<Banco> lb = this.bancoService.listarTodos();
//		System.out.println(lb.size());
		
		String pathSubReport1 = "C:\\Users\\mariana\\Documents\\apisBk\\testejasper\\src\\main\\resources\\relatorios\\Teste7_SubReport1.jrxml";
		String pathSubReport2 = "C:\\Users\\mariana\\Documents\\apisBk\\testejasper\\src\\main\\resources\\relatorios\\Teste7_SubReport2.jrxml"; 
		
		File fileSubReport1 = new File (pathSubReport1); 
		File fileSubReport2 = new File (pathSubReport2); 
		
		JasperReport jasperSubReport1 = JasperCompileManager.compileReport(fileSubReport1.getAbsolutePath()); 
		JasperReport jasperSubReport2 = JasperCompileManager.compileReport(fileSubReport2.getAbsolutePath()); 
		

		parametros.put("SUB_REPORT_1", jasperSubReport1);
		parametros.put("SUB_REPORT_2", jasperSubReport2);

		parametros.put("LISTA_ATOS", new JRBeanCollectionDataSource(l));
		parametros.put("LISTA_BANCOS", new JRBeanCollectionDataSource(l));
		
		
		RelatorioPdfUtil.printDecompiledReportWithEmptyDataSource(destino, origem, parametros);
	}
}
	
	

