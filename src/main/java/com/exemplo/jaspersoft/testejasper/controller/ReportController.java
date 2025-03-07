package com.exemplo.jaspersoft.testejasper.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.jaspersoft.testejasper.report.Teste1;
import com.exemplo.jaspersoft.testejasper.report.Teste10RelatorioFuncionario;
import com.exemplo.jaspersoft.testejasper.report.Teste11RelatorioEmpresa;
import com.exemplo.jaspersoft.testejasper.report.Teste2;
import com.exemplo.jaspersoft.testejasper.report.Teste3;
import com.exemplo.jaspersoft.testejasper.report.Teste4;
import com.exemplo.jaspersoft.testejasper.report.Teste5;
import com.exemplo.jaspersoft.testejasper.report.Teste6;
import com.exemplo.jaspersoft.testejasper.report.Teste7;
import com.exemplo.jaspersoft.testejasper.report.Teste8;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private Teste1 teste1;

	@Autowired
	private Teste2 teste2;

	@Autowired
	private Teste3 teste3;

	@Autowired
	private Teste4 teste4;

	@Autowired
	private Teste5 teste5;

	@Autowired
	private Teste6 teste6;

	@Autowired
	private Teste7 teste7;

	@Autowired
	private Teste8 teste8;

	@Autowired
	private Teste10RelatorioFuncionario teste10RelatorioFuncionario;
	
	@Autowired
	private Teste11RelatorioEmpresa teste11RelatorioEmpresa;

	@GetMapping(path = "/teste1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste1() {
		try {
			this.teste1.gerarRelatorioTeste1();
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste2", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste2() {
		try {
			this.teste2.gerarRelatorioTeste2();
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste3", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste3(BigDecimal tfj, Date data, int tabela) {

		String destino = "C:\\Users\\mariana\\Desktop\\reports_gerados\\Teste3.pdf";
		String origem = "C:\\Users\\mariana\\Documents\\apisbk\\testejasper\\src\\main\\resources\\relatorios\\Teste3_exemploLandscapeComParametros.jrxml";
		Map<String, Object> parametros = new HashMap<String, Object>();

		parametros.put("TFJ", tfj);
		parametros.put("DATA_INICIO_VIGENCIA", data);
		parametros.put("TABELA", tabela);

		//
		try {
			this.teste3.gerarRelatorioTeste3(destino, origem, parametros);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste4", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste4(BigDecimal issqn, Date data, int tabela) {

		String destino = "C:\\Users\\mariana\\Desktop\\reports_gerados\\Teste4.pdf";
		String origem = "C:\\Users\\mariana\\Documents\\apisbk\\testejasper\\src\\main\\resources\\relatorios\\Teste4_exemploCompletoTabelaEmolumentos.jrxml";
		Map<String, Object> parametros = new HashMap<String, Object>();

		parametros.put("ISSQN", issqn);
		parametros.put("DATA_INICIO_VIGENCIA", data);
		parametros.put("TABELA", tabela);

		//
		try {
			this.teste4.gerarRelatorioTeste4(destino, origem, parametros);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste5", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste5(BigDecimal valorFinal, Date dataInicioVigencia) {

		String destino = "C:\\Users\\mariana\\Desktop\\reports_gerados\\Teste5.pdf";
		String origem = "C:\\Users\\mariana\\Documents\\apisbk\\testejasper\\src\\main\\resources\\relatorios\\Teste5_ExemploDataSetCustom.jrxml";

		//		Map<String, Object> parametros = new HashMap<String, Object>(); 
		//		parametros.put("ISSQN", issqn); 
		//		parametros.put("DATA_INICIO_VIGENCIA", data);
		//		parametros.put("TABELA", tabela);

		//
		try {
			this.teste5.gerarRelatorioTeste5(destino, origem, valorFinal, dataInicioVigencia);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste6", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste6(BigDecimal valorFinal, Date dataInicioVigencia, BigDecimal issqn, int tabela) {

		String destino = "C:\\Users\\mariana\\Desktop\\reports_gerados\\Teste6.pdf";
		String origem = "C:\\Users\\mariana\\Documents\\apisBk\\testejasper\\src\\main\\resources\\relatorios\\Teste6_exemploCompletoDataSetCustomComImagem.jrxml";

		//
		try {
			this.teste6.gerarRelatorioTeste6(destino, origem, valorFinal, dataInicioVigencia, issqn, tabela);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste7", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste7(BigDecimal valorFinal, Date dataInicioVigencia) {

		String destino = "C:\\Users\\mariana\\Desktop\\reports_gerados\\Teste7.pdf";
		String origem = "C:\\Users\\mariana\\Documents\\apisbk\\testejasper\\src\\main\\resources\\relatorios\\Teste7_exemploSubReport.jrxml";

		//
		try {
			this.teste7.gerarRelatorioTeste7(destino, origem, valorFinal, dataInicioVigencia);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste8", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste8(BigDecimal valorFinal, Date dataInicioVigencia) {

		String destino = "C:\\Users\\mariana\\Desktop\\reports_gerados\\Teste8.pdf";
		String origem = "C:\\Users\\mariana\\Documents\\apisbk\\testejasper\\src\\main\\resources\\relatorios\\Teste8_exemploRepassandoParametroParaSubReport.jrxml";

		//
		try {
			this.teste8.gerarRelatorioTeste8(destino, origem, valorFinal, dataInicioVigencia);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste10RelatorioFuncionario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste10RelatorioFuncionario() {
		try {
			this.teste10RelatorioFuncionario.gerarRelatorioTeste10();
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}
	
	@GetMapping(path = "/teste11RelatorioEmpresa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste11RelatorioEmpresa() {
		try {
			this.teste11RelatorioEmpresa.gerarRelatorioTeste11();
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}

}
