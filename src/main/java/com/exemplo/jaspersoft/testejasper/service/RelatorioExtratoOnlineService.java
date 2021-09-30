package com.exemplo.jaspersoft.testejasper.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RelatorioExtratoOnlineService {

	public void gerarRelatorioExtratoOnline(HashMap<String, Object> valores) {

		for (Map.Entry<String, Object> entry : valores.entrySet()) {
			System.out.println(entry.getKey());
			//System.out.println(entry.getValue());
		}
	}

}
