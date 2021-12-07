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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "fechamento_rubrica", schema = "recompe")
@SequenceGenerator(name = "seq_id_fechamento_rubrica", sequenceName = "seq_id_fechamento_rubrica", schema = "recompe", allocationSize = 1)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FechamentoRubrica {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_fechamento_rubrica")
	private Long id;

	@Column(name = "periodo_referencia", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date periodoReferencia;

	@Column(name = "quantidade_dap", nullable = true)
	private int quantidadeDap;

	@Column(name = "quantidade_solicitada", nullable = false)
	private int quantidadeSolicitada;

	@Column(name = "valor_unitario_praticado", nullable = false)
	private BigDecimal valorUnitarioPraticado;

	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fechamento", nullable = false)
	private Fechamento fechamento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rubrica", nullable = false)
	private Rubrica rubrica;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cartorio_ui", nullable = true)
	private Cartorio cartorioUI;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_oficial_ui", nullable = true)
	private Oficial oficialUI;

	@Column(name = "nome_maternidade", nullable = true)
	private String nomeMaternidade;

	@Column(name = "termo_inicial", nullable = true)
	private int termoInicial;

	@Column(name = "termo_final", nullable = true)
	private int termoFinal;

	@Column(name = "quantidade_termos_cancelados", nullable = true)
	private int quantidadeTermosCancelados;

	@Column(name = "observacoes_no_termo", nullable = true)
	private String observacoesNoTermo;

	@Column(name = "data_fim", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataFim;
}
