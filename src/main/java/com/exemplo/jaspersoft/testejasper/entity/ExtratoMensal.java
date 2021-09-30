package com.exemplo.jaspersoft.testejasper.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "extrato_mensal", schema = "recompe")
@SequenceGenerator(name = "seq_id_extrato_mensal", sequenceName = "seq_id_extrato_mensal", schema = "recompe", allocationSize = 1)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtratoMensal {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_extrato_mensal")
	private Long id;

	@Column(name = "mes_pagamento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date mesPagamento;

	@Column(name = "valor_bruto_mensal", nullable = false)
	private BigDecimal valorBrutoMensal;

	@Column(name = "valor_recivil", nullable = false)
	private BigDecimal valorRecivil;

	@Column(name = "valor_unimed", nullable = false)
	private BigDecimal valorUnimed;

	@Column(name = "valor_ir_retido", nullable = false)
	private BigDecimal valorIRRetido;

	@Column(name = "valor_recebido", nullable = false)
	private BigDecimal valorRecebido;

	@Column(name = "cpf_pessoa", nullable = false)
	private String cpfPessoa;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;
}
