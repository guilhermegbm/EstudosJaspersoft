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
import com.exemplo.jaspersoft.testejasper.report.Teste2;
import com.exemplo.jaspersoft.testejasper.report.Teste3;
import com.exemplo.jaspersoft.testejasper.report.Teste4;

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
	

	@GetMapping(path = "/teste1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste1() {
		try {
			this.teste1.gerarRelatorioTeste1();
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
		}
	}

	@GetMapping(path = "/teste2", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste2() {
		try {
			this.teste2.gerarRelatorioTeste2();
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
		}
	}
	
	@GetMapping(path = "/teste3", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste3(BigDecimal tfj, Date data, int tabela) {
		
		
		String destino = "C:\\Users\\marry\\Desktop\\reports_gerados\\Teste3.pdf";
		String origem = "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\Teste3_exemploLandscapeComParametros.jrxml";
		Map<String, Object> parametros = new HashMap<String, Object>(); 
		
		parametros.put("TFJ", tfj); 
		parametros.put("DATA_INICIO_VIGENCIA", data);
		parametros.put("TABELA", tabela);
		
		// 
		try {
			this.teste3.gerarRelatorioTeste3(destino ,origem , parametros);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
		}
	}
	
	@GetMapping(path = "/teste4", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> teste4(BigDecimal issqn, Date data, int tabela) {
		
		
		String destino = "C:\\Users\\marry\\Desktop\\reports_gerados\\Teste4.pdf";
		String origem = "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\Teste4_exemploCompletoTabelaEmolumentos.jrxml";
		Map<String, Object> parametros = new HashMap<String, Object>(); 
		
		parametros.put("ISSQN", issqn); 
		parametros.put("DATA_INICIO_VIGENCIA", data);
		parametros.put("TABELA", tabela);
		
		// 
		try {
			this.teste4.gerarRelatorioTeste4(destino ,origem , parametros);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
		}
	}
	
	
	
}
