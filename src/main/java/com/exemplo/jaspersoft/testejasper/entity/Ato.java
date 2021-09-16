package com.exemplo.jaspersoft.testejasper.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "ato", schema = "recompe")
@Data
public class Ato {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "tfj")
	private BigDecimal tfj;

	@Column(name = "final")
	private BigDecimal valorFinal;

	// Emolumento LÍQUIDO!!
	@Column(name = "emolumento")
	private BigDecimal emolumento;

	@Column(name = "recompe")
	private BigDecimal recompe;

	@Column(name = "inicio_vigencia")
	@Temporal(TemporalType.DATE)
	private Date inicioVigencia;

	@Column(name = "fim_vigencia")
	@Temporal(TemporalType.DATE)
	private Date fimVigencia;

	/*@JsonIgnore
	@OneToMany(mappedBy = "ato", fetch = FetchType.LAZY)
	private List<AtoRessarcimento> atoRessarcimentos;*/
}
