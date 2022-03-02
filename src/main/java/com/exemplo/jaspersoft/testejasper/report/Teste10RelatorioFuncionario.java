package com.exemplo.jaspersoft.testejasper.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Funcionario;
import com.exemplo.jaspersoft.testejasper.service.FuncionarioService;

@Component
public class Teste10RelatorioFuncionario {

	@Autowired
	private FuncionarioService funcionarioService;

	public void gerarRelatorioTeste10() throws Exception {
		List<Funcionario> funcionarios = this.funcionarioService.listarTodos();

		String destino = "C:\\Users\\guilh\\Desktop\\relatorios\\Teste10.pdf";
		String origem = "C:\\Users\\guilh\\Documents\\EclipseProjects\\testejasper\\src\\main\\resources\\relatorios\\Funcionarios2.jrxml";

		

		RelatorioPdfUtil.printDecompiledReportWithCustomCollectionDataSource(destino, origem, null, funcionarios);
	}
}
