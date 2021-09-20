package com.exemplo.jaspersoft.testejasper.report;

import org.springframework.stereotype.Component;

@Component
public class Teste1 {

	public void gerarRelatorioTeste1() throws Exception {
//		RelatorioPdfUtil.printReportWithEmptyDataSource("C:\\Users\\guilh\\Desktop\\reports_gerados\\Teste1.pdf", null, "/relatorios/teste1_exemploEstatico.jasper");
		RelatorioPdfUtil.printReportWithEmptyDataSource2("C:\\Users\\marry\\Desktop\\reports_gerados\\Teste1.pdf", null, "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\teste1_exemploEstatico.jrxml");
	}
}
