package com.exemplo.jaspersoft.testejasper.controller;

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
	public ResponseEntity<Object> teste3() {
		try {
			this.teste3.gerarRelatorioTeste3();
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
		}
	}
	
	
	
}
