package com.exemplo.jaspersoft.testejasper.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.exemplo.jaspersoft.testejasper.enums.EnumAutor;
import com.exemplo.jaspersoft.testejasper.enums.EnumTipoBloqueioOficial;
import com.exemplo.jaspersoft.testejasper.enums.EnumTipoConta;
import com.exemplo.jaspersoft.testejasper.enums.EnumTipoOficial;
import com.exemplo.jaspersoft.testejasper.enums.EnumTipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "oficial", schema = "recompe")
@SequenceGenerator(name = "seq_id_oficial", sequenceName = "seq_id_oficial", schema = "recompe", allocationSize = 1)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Oficial {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_oficial")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "tipo_oficial", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoOficial tipoOficial;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "codigo_cartorio")
	private String codigoCartorio;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "email_validado", nullable = true)
	private Boolean emailValidado;

	@Column(name = "telefone_ddd", nullable = true)
	private String telefoneDDD;

	@Column(name = "telefone_numero", nullable = true)
	private String telefoneNumero;

	@Column(name = "telefone_validado", nullable = true)
	private Boolean telefoneValidado;

	@Column(name = "cartorio_anexado")
	private Boolean cartorioAnexado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cartorio_sede", nullable = true)
	private Cartorio cartorioSede;

	@Column(name = "data_inicio_mandato", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInicioMandato;

	@Column(name = "data_fim_mandato")
	@Temporal(TemporalType.DATE)
	private Date dataFimMandato;

	@Column(name = "cpf_cnpj_titular_conta", nullable = true)
	private String cpfCnpjTitularConta;

	@Column(name = "cpf_oficial_resp_pagamento", nullable = true)
	private String cpfOficialRespPagamento;

	@Column(name = "valor_pago_dependentes", nullable = true)
	private BigDecimal valorPagoDependentes;

	@Column(name = "tipo_titular_conta", nullable = true)
	@Enumerated(EnumType.STRING)
	private EnumTipoPessoa tipoTitularConta;

	@Column(name = "nome_titular_conta", nullable = true)
	private String nomeTitularConta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "banco_conta", nullable = true)
	private Banco bancoConta;

	@Column(name = "agencia", nullable = true)
	private String agencia;

	@Column(name = "conta", nullable = true)
	private String conta;

	@Column(name = "tipo_conta", nullable = true)
	@Enumerated(EnumType.STRING)
	private EnumTipoConta tipoConta;

	@Column(name = "data_ultima_atualizacao", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cartorio", nullable = false)
	private Cartorio cartorio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@Column(name = "bloqueado", nullable = false)
	private Boolean bloqueado;

	@Column(name = "tipo_bloqueio", nullable = true)
	@Enumerated(EnumType.STRING)
	private EnumTipoBloqueioOficial tipoBloqueio;

	/*@JsonIgnore
	@OneToMany(mappedBy = "oficial", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Dap> daps;*/

	/*@JsonIgnore
	@OneToMany(mappedBy = "oficial", fetch = FetchType.LAZY)
	private List<BorderoOficial> borderosOficiais;*/

	@JsonIgnore
	@OneToMany(mappedBy = "oficial", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Fechamento> fechamentos;

	@Column(name = "data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Column(name = "cpf_autor_ultima_alteracao_auditoria")
	private String cpfAutorUltimaAlteracaoAuditoria;

	@Column(name = "autor_ultima_alteracao_auditoria")
	@Enumerated(EnumType.STRING)
	private EnumAutor autorUltimaAlteracaoAuditoria;
}
