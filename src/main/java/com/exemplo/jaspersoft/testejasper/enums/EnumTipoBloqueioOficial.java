package com.exemplo.jaspersoft.testejasper.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumTipoBloqueioOficial {
	ATUALIZACAO_CADASTRAL("Atualização Cadastral");

	private final String nome;

	EnumTipoBloqueioOficial(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static List<String> valuesAsString() {
		List<String> valuesAsString = new ArrayList<String>();

		for (EnumTipoBloqueioOficial bloqueioOficial : values()) {
			valuesAsString.add(bloqueioOficial.getNome());
		}

		return valuesAsString;
	}

	public static EnumTipoBloqueioOficial valueOfNome(String nome) throws Exception {
		for (EnumTipoBloqueioOficial bloqueioOficial : values()) {
			if (bloqueioOficial.getNome().equals(nome)) {
				return bloqueioOficial;
			}
		}
		throw new Exception("Nenhum Tipo de Bloqueio Encontrado para " + nome);
	}
}
