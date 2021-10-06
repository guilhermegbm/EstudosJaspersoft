package com.exemplo.jaspersoft.testejasper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exemplo.jaspersoft.testejasper.entity.ExtratoMensal;
import com.exemplo.jaspersoft.testejasper.report.Teste9RelatorioExtratoOnlineReport;
import com.exemplo.jaspersoft.testejasper.vo.RelatorioExtratoOnlineVO;

@Service
public class RelatorioExtratoOnlineService {
	@Autowired 
	private Teste9RelatorioExtratoOnlineReport teste9RelatorioExtratoOnlineReport;

	public ResponseEntity<Object> gerarRelatorioExtratoOnline(RelatorioExtratoOnlineVO valores) {

		
		String destino = "C:\\Users\\marry\\Desktop\\reports_gerados\\Teste9_RelatorioExtratoOnline.pdf";
		String origem = "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\Teste9_RelatorioExtratoOnline.jrxml";
		
		try {
			ExtratoMensal em =  valores.getExtratoMensal();
			System.out.println(em.getId());
			this.teste9RelatorioExtratoOnlineReport.gerarRelatorioExtratoOnline(destino, origem, valores);
			
			return new ResponseEntity<Object>("OK", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
		}

		
		
	}

}
