package com.exemplo.jaspersoft.testejasper.vo;

import java.util.List;

import com.exemplo.jaspersoft.testejasper.entity.Cartorio;
import com.exemplo.jaspersoft.testejasper.entity.ExtratoMensal;
import com.exemplo.jaspersoft.testejasper.entity.Oficial;
import com.exemplo.jaspersoft.testejasper.entity.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class RelatorioExtratoOnlineVO {
	private Pessoa valoresPorPessoaEMes;
	private List<String> periodos;
	private ExtratoMensal extratoMensal;

}
//DTO - Data Transfer Object 
//VO  - Virtual Object
//
