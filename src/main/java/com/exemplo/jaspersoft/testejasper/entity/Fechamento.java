package com.exemplo.jaspersoft.testejasper.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.exemplo.jaspersoft.testejasper.enums.EnumAutor;
import com.exemplo.jaspersoft.testejasper.enums.EnumSituacaoFechamento;
import com.exemplo.jaspersoft.testejasper.enums.EnumTipoFechamento;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "fechamento", schema = "recompe")
@SequenceGenerator(name = "seq_id_fechamento", sequenceName = "seq_id_fechamento", schema = "recompe", allocationSize = 1)
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fechamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_fechamento")
	@Column(name = "id")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "periodo_referencia", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date periodoReferencia;

	@Column(name = "tipo_fechamento", nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumTipoFechamento tipoFechamento;

	@Column(name = "cpf_pessoa", nullable = false)
	private String cpfPessoa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_oficial", nullable = false)
	private Oficial oficial;

	@Column(name = "registro_civil", nullable = false)
	private boolean registroCivil;

	@Column(name = "situacao_fechamento", nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumSituacaoFechamento situacaoFechamento;

	@Column(name = "data_hora_primeiro_envio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraPrimeiroEnvio;

	@Column(name = "data_hora_ultimo_envio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraUltimoEnvio;

	@Column(name = "cpf_ultimo_analista", nullable = true)
	private String cpfUltimoAnalista;

	@Column(name = "data_hora_digitacao_certidao", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraDigitacaoCertidao;

	@Column(name = "cpf_digitador_certidao", nullable = true)
	private String cpfDigitadorCertidao;

	@Column(name = "valor_bruto", nullable = true)
	private BigDecimal valorBruto;

	@Column(name = "valor_liquido", nullable = true)
	private BigDecimal valorLiquido;

	@Column(name = "valor_recivil", nullable = true)
	private BigDecimal valorRecivil;

	@Column(name = "valor_ir", nullable = true)
	private BigDecimal valorIR;

	@Transient
	private BigDecimal valorBrutoAcumulado;

	@Transient
	private BigDecimal valorIRAcumulado;

	@Column(name = "mes_pagamento")
	@Temporal(TemporalType.DATE)
	private Date mesPagamento;

	@Column(name = "motivo_bloqueio")
	private String motivoBloqueio;

	@OneToMany(mappedBy = "fechamento", fetch = FetchType.EAGER) // TODO URGENTE: Trocar para 'FetchType.LAZY'
	private List<FechamentoRubrica> fechamentosRubrica;

	@Column(name = "data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Enumerated(EnumType.STRING)
	@Column(name = "autor_delecao", nullable = true)
	private EnumAutor autorDelecao;

	@Column(name = "cpf_autor_delecao", nullable = true)
	private String cpfAutorDelecao;

	@Column(name = "tipo_oficial_migracao", nullable = true)
	private String tipoOficialMigracao;

	@Column(name = "motivo_nao_liberacao_pagamento", nullable = true)
	private String motivoNaoLiberacaoPagamento;

	@Column(name = "motivo_nao_processamento", nullable = true)
	private String motivoNaoProcessamento;

	// TODO: Parcialmente inútil. Era usado apenas para uma simples validação
	@Column(name = "valor_emolumento_bruto_pelo_oficial", nullable = true)
	private BigDecimal valorEmolumentoBrutoPeloOficial;

	// TODO: Parcialmente inútil. Era usado apenas para uma simples validação
	@Column(name = "valor_emolumento_bruto_pelo_cpf", nullable = true)
	private BigDecimal valorEmolumentoBrutoPeloCpf;

	// TODO: Parcialmente inútil. Era usado apenas para uma simples validação
	@Column(name = "valor_teto_complementacao_renda", nullable = true)
	private BigDecimal valorTetoComplementacaoRenda;

	// TODO: Parcialmente inútil. Era usado apenas para uma simples validação
	@Column(name = "valor_somatorio_rubricas_complementacao_renda", nullable = true)
	private BigDecimal valorSomatorioRubricasComplementacaoRenda;

}
