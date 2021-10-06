package com.exemplo.jaspersoft.testejasper.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "rubrica", schema = "recompe")
@SequenceGenerator(name = "seq_id_rubrica", sequenceName = "seq_id_rubrica", schema = "recompe", allocationSize = 1)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rubrica {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_rubrica")
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", nullable = true)
	private String descricao;

	@Column(name = "valor_unitario", nullable = false)
	private BigDecimal valorUnitario;

	@Column(name = "quantidade_maxima", nullable = true)
	private int quantidadeMaxima;

	@Column(name = "periodo_referencia", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date periodoReferencia;

	@Column(name = "documentos_necessarios", nullable = true)
	private String documentosNecessarios;

	// O usuário pode editar a qtde solicitada dessa rubrica
	@Column(name = "quantidade_editavel", nullable = false)
	private boolean quantidadeEditavel;

	// Mesmo que a mesma pessoa (CPF) tenha vários cartórios, essa rubrica será
	// contabilizada em apenas um cartório
	@Column(name = "unica_por_cpf", nullable = false)
	private boolean unicaPorCpf;

	// Essa rubrica só pode ser contabilizada em Cartórios Sede
	@Column(name = "somente_sede", nullable = false)
	private boolean somenteSede;

	// Dividir o valor dessa rubrica para mais de um oficial (quando um sai e outro
	// entra no meio do mês)
	@Column(name = "divide_mais_um_pagamento", nullable = false)
	private boolean divideMaisUmPagamento;

	// Rubrica com Termo, Livro e Folha
	@Column(name = "com_termo_livro_folha", nullable = false)
	private boolean comTermoLivroFolha; // TODO: Remover, quando possível

	// Rubrica com cálculo para Fechamentos de Unidade Interligada
	@Column(name = "unidade_interligada", nullable = false)
	private boolean unidadeInterligada;

	// Rubrica com cálculo para determinado tipo de Cartório
	@Column(name = "registro_civil", nullable = false)
	private boolean registroCivil;

	@Column(name = "notas", nullable = false)
	private boolean notas;

	@Column(name = "pessoa_juridica", nullable = false)
	private boolean pessoaJuridica;

	@Column(name = "protesto", nullable = false)
	private boolean protesto;

	@Column(name = "titulos", nullable = false)
	private boolean titulos;

	@Column(name = "imoveis", nullable = false)
	private boolean imoveis;

	@Column(name = "distribuicao", nullable = false)
	private boolean distribuicao;

	@Column(name = "adicionada_na_complementacao", nullable = false)
	private boolean adicionadaNaComplementacao;

	// Rubrica com cálculo para determinado ato
	@Column(name = "codigo_ato", nullable = true)
	private String codigoAto;

	// Quantidade padrão dessa rubrica
	@Column(name = "quantidade_padrao", nullable = false)
	private int quantidadePadrao;

	@Column(name = "data_cadastro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	@Column(name = "data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@OneToMany(mappedBy = "rubrica", fetch = FetchType.LAZY)
	private List<FechamentoRubrica> fechamentoRubrica;
}
