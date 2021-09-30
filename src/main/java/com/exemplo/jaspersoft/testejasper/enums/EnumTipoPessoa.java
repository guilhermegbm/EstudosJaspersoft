package com.exemplo.jaspersoft.testejasper.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumTipoPessoa {
	FISICA("Física"),
	JURIDICA("Jurídica");

	private final String nome;

	EnumTipoPessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static List<String> valuesAsString() {
		List<String> valuesAsString = new ArrayList<String>();

		for (EnumTipoPessoa tipoPessoa : values()) {
			valuesAsString.add(tipoPessoa.getNome());
		}

		return valuesAsString;
	}

	public static EnumTipoPessoa valueOfNome(String nome) throws Exception {
		for (EnumTipoPessoa tipoPessoa : values()) {
			if (tipoPessoa.getNome().equals(nome)) {
				return tipoPessoa;
			}
		}
		throw new Exception("Nenhum Tipo de Pessoa Encontrado para " + nome);
	}
}
