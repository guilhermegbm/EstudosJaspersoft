package com.exemplo.jaspersoft.testejasper.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumTipoOficial {
	TITULAR("Titular"),
	SUBSTITUTO("Substituto"),
	INTERVENTOR("Interventor"),
	EX_TITULAR("Ex Titular"),
	INTERINO("Interino");

	private final String nome;

	EnumTipoOficial(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static List<String> valuesAsString() {
		List<String> valuesAsString = new ArrayList<String>();

		for (EnumTipoOficial tipoOficial : values()) {
			valuesAsString.add(tipoOficial.getNome());
		}

		return valuesAsString;
	}

	public static EnumTipoOficial valueOfNome(String nome) throws Exception {
		for (EnumTipoOficial tipoOficial : values()) {
			if (tipoOficial.getNome().equals(nome)) {
				return tipoOficial;
			}
		}
		throw new Exception("Nenhum Tipo de Oficial Encontrado para " + nome);
	}

	public boolean isInterino() {
		return EnumTipoOficial.INTERINO.equals(this);
	}
}
