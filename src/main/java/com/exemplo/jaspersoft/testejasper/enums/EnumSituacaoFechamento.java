package com.exemplo.jaspersoft.testejasper.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumSituacaoFechamento {
	DOCUMENTACAO_RECEBIDA("Documenta��o recebida"),
	DOCUMENTACAO_EM_PRE_ANALISE("Documenta��o em pr�-an�lise"),
	DOCUMENTACAO_EM_ANALISE("Documenta��o em an�lise"),
	EM_ANALISE_PELA_COMISSAO("Em an�lise pela comiss�o"),
	DOCUMENTACAO_VALIDADA("Documenta��o validada"),
	CERTIDAO_DIGITADA("Certid�o digitada"),
	CERTIDAO_VALIDADA("Certid�o validada"),
	LIBERADA_PARA_PAGAMENTO("Liberada para Pagamento"),
	PAGAMENTO_NAO_LIBERADO("Pagamento n�o Liberado"),
	PAGAMENTO_EM_ANDAMENTO("Pagamento em Andamento"),
	PAGAMENTO_BLOQUEADO("Pagamento bloqueado"),
	PAGAMENTO_EFETUADO("Pagamento efetuado"),
	DOCUMENTACAO_PENDENTE("Documenta��o pendente"),
	RETORNO_DE_DOCUMENTACAO_PENDENTE("Retorno de documenta��o Pendente");

	private final String situacaoFechamento;

	EnumSituacaoFechamento(String situacaoFechamento) {
		this.situacaoFechamento = situacaoFechamento;
	}

	public String getSituacaoFechamento() {
		return this.situacaoFechamento;
	}

	public static List<String> valuesAsString() {
		List<String> valuesAsString = new ArrayList<String>();

		for (EnumSituacaoFechamento sitFec : values()) {
			valuesAsString.add(sitFec.getSituacaoFechamento());
		}

		return valuesAsString;
	}

	public static EnumSituacaoFechamento valueOfSituacaoFechamento(String situacaoFechamento) throws Exception {
		for (EnumSituacaoFechamento sitFec : values()) {
			if (sitFec.getSituacaoFechamento().equals(situacaoFechamento)) {
				return sitFec;
			}
		}
		throw new Exception("Nenhuma Situa��o de Fechamento Encontrada para " + situacaoFechamento);
	}
}
