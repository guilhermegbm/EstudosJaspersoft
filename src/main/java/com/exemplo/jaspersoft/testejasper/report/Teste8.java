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
public class Teste8 {
	@Autowired
	private AtoRepository atoRepository;

	public void gerarRelatorioTeste8(String destino, String origem, BigDecimal valorFinal, Date dataInicioVigencia)
			throws Exception {

		Map<String, Object> parametros = new HashMap<String, Object>();

		List<Ato> l = this.atoRepository.findByValorFinalAndInicioVigencia(valorFinal, dataInicioVigencia);
		System.out.println(l.size());

		String pathSubReport1 = "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\Teste8_SubReport1.jrxml";

		File fileSubReport1 = new File(pathSubReport1);

		JasperReport jasperSubReport1 = JasperCompileManager.compileReport(fileSubReport1.getAbsolutePath());

		parametros.put("SUB_REPORT_1", jasperSubReport1);
		parametros.put("LISTA_ATOS", new JRBeanCollectionDataSource(l));
		parametros.put("VALOR_FINAL", new BigDecimal(1234));
		parametros.put("DATA_INICIO_VIGENCIA", dataInicioVigencia);

		RelatorioPdfUtil.printDecompiledReportWithEmptyDataSource(destino, origem, parametros);
	}

}
