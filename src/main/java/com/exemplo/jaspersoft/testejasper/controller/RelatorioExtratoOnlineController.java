package com.exemplo.jaspersoft.testejasper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.jaspersoft.testejasper.service.RelatorioExtratoOnlineService;
import com.exemplo.jaspersoft.testejasper.vo.RelatorioExtratoOnlineVO;

@CrossOrigin
@RestController
@RequestMapping("/relatorio-extrato-online")
public class RelatorioExtratoOnlineController {

	@Autowired
	private RelatorioExtratoOnlineService relatorioExtratoOnlineService;

	@PostMapping(path = "/gerarRelatorioExtratoOnline")
	public ResponseEntity<Object> gerarRelatorioExtratoOnline(boolean tipoUsuario, @RequestBody(required = true) RelatorioExtratoOnlineVO valores) {
		try {
			this.relatorioExtratoOnlineService.gerarRelatorioExtratoOnline(tipoUsuario, valores);
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
		}
	}
}
