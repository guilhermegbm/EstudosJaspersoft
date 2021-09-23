package com.exemplo.jaspersoft.testejasper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


// Relacao de participantes do STR - 25/06/2021
// https://www.bcb.gov.br/pom/spb/estatistica/port/ASTR003.pdf

@Data
@Entity
@Table(name = "banco", schema = "recompe")
@SequenceGenerator(name = "seq_id_banco", sequenceName = "seq_id_banco", schema = "recompe", allocationSize = 1)
public class Banco {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_banco")
	private Long id;

	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "nome_reduzido")
	private String nomeReduzido;

	@Column(name = "codigo_ispb")
	private String codigoIspb;
	
	@Column(name = "nome_extenso")
	private String nomeExtenso;
	



}
