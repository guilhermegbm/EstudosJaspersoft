package com.exemplo.jaspersoft.testejasper.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumSituacaoFechamento {
	DOCUMENTACAO_RECEBIDA("Documentação recebida"),
	DOCUMENTACAO_EM_PRE_ANALISE("Documentação em pré-análise"),
	DOCUMENTACAO_EM_ANALISE("Documentação em análise"),
	EM_ANALISE_PELA_COMISSAO("Em análise pela comissão"),
	DOCUMENTACAO_VALIDADA("Documentação validada"),
	CERTIDAO_DIGITADA("Certidão digitada"),
	CERTIDAO_VALIDADA("Certidão validada"),
	LIBERADA_PARA_PAGAMENTO("Liberada para Pagamento"),
	PAGAMENTO_NAO_LIBERADO("Pagamento não Liberado"),
	PAGAMENTO_EM_ANDAMENTO("Pagamento em Andamento"),
	PAGAMENTO_BLOQUEADO("Pagamento bloqueado"),
	PAGAMENTO_EFETUADO("Pagamento efetuado"),
	DOCUMENTACAO_PENDENTE("Documentação pendente"),
	RETORNO_DE_DOCUMENTACAO_PENDENTE("Retorno de documentação Pendente");

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
		throw new Exception("Nenhuma Situação de Fechamento Encontrada para " + situacaoFechamento);
	}
}
