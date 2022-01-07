package com.exemplo.jaspersoft.testejasper.report;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Empresa;
import com.exemplo.jaspersoft.testejasper.service.EmpresaService;
import com.exemplo.jaspersoft.testejasper.service.FuncionarioService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

@Component
public class Teste11RelatorioEmpresa {

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private FuncionarioService funcionarioService;

	public void gerarRelatorioTeste11() throws Exception {
		List<Empresa> empresas = this.empresaService.listarTodas();

		for (Empresa e : empresas) {
			e.setFuncionarios(funcionarioService.listarPorEmpresa(e));
		}

		String destino = "C:\\Users\\guilh\\Desktop\\relatorios\\Teste11.pdf";
		String origemPai = "C:\\Users\\guilh\\Documents\\EclipseProjects\\testejasper\\src\\main\\resources\\relatorios\\Empresas.jrxml";

		String origemFilho = "C:\\Users\\guilh\\Documents\\EclipseProjects\\testejasper\\src\\main\\resources\\relatorios\\FuncionariosSubreport.jrxml";
		File fileSubReportFuncionarios = new File(origemFilho);
		JasperReport subReportFuncionarios = JasperCompileManager.compileReport(fileSubReportFuncionarios.getAbsolutePath());

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("SUB_REPORT_FUNCIONARIOS", subReportFuncionarios);

		RelatorioPdfUtil.printDecompiledReportWithCustomCollectionDataSource(destino, origemPai, parameters, empresas);
	}
}
