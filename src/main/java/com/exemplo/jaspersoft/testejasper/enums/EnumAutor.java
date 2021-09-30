package com.exemplo.jaspersoft.testejasper.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumAutor {

	FUNCIONARIO_INTERNO("Funcionário interno"),
	AUTOR_EXTERNO("Autor Externo"),
	SISTEMA("Sistema");

	private final String nome;

	public String getNome() {
		return nome;
	}

	private EnumAutor(String nome) {
		this.nome = nome;
	}

	public static EnumAutor valueOfNome(String nome) throws Exception {
		for (EnumAutor autor : values()) {
			if (autor.getNome().equals(nome)) {
				return autor;
			}
		}
		throw new Exception("Nenhum Autor da última Alteração encontrado para a descrição " + nome);
	}

	public static List<String> valuesNomesAsList() {
		List<String> valuesNomesAsString = new ArrayList<String>();

		for (EnumAutor autorUltimaAlt : values()) {
			valuesNomesAsString.add(autorUltimaAlt.getNome());
		}

		return valuesNomesAsString;
	}
}
