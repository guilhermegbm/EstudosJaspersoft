package com.exemplo.jaspersoft.testejasper.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumTipoConta {
	CORRENTE("Corrente"),
	POUPANCA("Poupança");

	private final String nome;

	EnumTipoConta(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static List<String> valuesAsString() {
		List<String> valuesAsString = new ArrayList<String>();

		for (EnumTipoConta tipoConta : values()) {
			valuesAsString.add(tipoConta.getNome());
		}

		return valuesAsString;
	}

	public static EnumTipoConta valueOfNome(String nome) throws Exception {
		for (EnumTipoConta tipoConta : values()) {
			if (tipoConta.getNome().equals(nome)) {
				return tipoConta;
			}
		}
		throw new Exception("Nenhum Tipo de Conta Encontrado para " + nome);
	}
}
