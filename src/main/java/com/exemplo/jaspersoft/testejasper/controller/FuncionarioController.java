package com.exemplo.jaspersoft.testejasper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.jaspersoft.testejasper.service.FuncionarioService;

@CrossOrigin
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping(path = "/listarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listarTodos() {
		try {
			return new ResponseEntity<Object>(this.funcionarioService.listarTodos(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro n�o tratado: " + e.getMessage());
		}
	}
}
