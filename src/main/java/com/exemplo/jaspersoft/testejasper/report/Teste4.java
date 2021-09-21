package com.exemplo.jaspersoft.testejasper.report;

import java.sql.Connection;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teste4 {
	@Autowired
	private DataSource dataSource;
	
	public void gerarRelatorioTeste4(String destino , String origem, Map<String, Object> parameters) throws Exception {
		
		Connection con = dataSource.getConnection();
		
		RelatorioPdfUtil.printDecompiledReportWithCustomConnection(destino,origem, parameters, con);
	}
}
