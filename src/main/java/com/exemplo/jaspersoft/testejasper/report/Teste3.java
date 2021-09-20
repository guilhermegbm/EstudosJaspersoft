package com.exemplo.jaspersoft.testejasper.report;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teste3 {
	@Autowired
	private DataSource dataSource;
	
	public void gerarRelatorioTeste3() throws Exception {
		
		Connection con = dataSource.getConnection();
		
		RelatorioPdfUtil.printDecompiledReportWithCustomConnection("C:\\Users\\marry\\Desktop\\reports_gerados\\Teste3.pdf", null, "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\Teste3_exemploLandscapeComParametros.jrxml", con);
	}
}
