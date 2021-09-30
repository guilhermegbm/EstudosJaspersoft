package com.exemplo.jaspersoft.testejasper.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumTipoFechamento {
	GRATUIDADE("Gratuidade"),
	COMPLEMENTACAO_DE_RENDA("Complementação de Renda"),
	UNIDADE_INTERLIGADA("Unidade Interligada");

	private final String tipoFechamento;

	EnumTipoFechamento(String tipoFechamento) {
		this.tipoFechamento = tipoFechamento;
	}

	public String getTipoFechamento() {
		return this.tipoFechamento;
	}

	public static List<String> valuesAsString() {
		List<String> valuesAsString = new ArrayList<String>();

		for (EnumTipoFechamento tipoFechamento : values()) {
			valuesAsString.add(tipoFechamento.getTipoFechamento());
		}

		return valuesAsString;
	}

	public static EnumTipoFechamento valueOfTipoFechamento(String tipoFechamento) throws Exception {
		for (EnumTipoFechamento tipoFec : values()) {
			if (tipoFec.getTipoFechamento().equals(tipoFechamento)) {
				return tipoFec;
			}
		}
		throw new Exception("Nenhum Tipo de Fechamento Encontrado para " + tipoFechamento);
	}
}
