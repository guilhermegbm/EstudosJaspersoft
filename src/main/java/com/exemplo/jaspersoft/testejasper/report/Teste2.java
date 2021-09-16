package com.exemplo.jaspersoft.testejasper.report;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teste2 {

	@Autowired
	private DataSource dataSource;

	public void gerarRelatorioTeste2() throws Exception {

		Connection con = dataSource.getConnection();

		RelatorioPdfUtil.printReportWithCustomConnection("C:\\Users\\guilh\\Desktop\\reports_gerados\\Teste2.pdf", null, "/relatorios/teste2_exemploAdapter.jasper", con);
	}
}
