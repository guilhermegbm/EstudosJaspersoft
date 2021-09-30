package com.exemplo.jaspersoft.testejasper.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "valor_periodo", schema = "recompe")
@SequenceGenerator(name = "seq_id_valor_periodo", sequenceName = "seq_id_valor_periodo", schema = "recompe", allocationSize = 1)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValorPeriodo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_valor_periodo")
	private Long id;

	@Column(name = "periodo_referencia", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date periodoReferencia;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	@Column(name = "data_fim", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataFim;
}
