package com.exemplo.jaspersoft.testejasper.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "empresa", schema = "jasper")
@Data
public class Empresa {

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@Column(name = "razao_social", nullable = true)
	private String razaoSocial;

	@Column(name = "sede", nullable = true)
	private String sede;

	@Column(name = "capital_social", nullable = true)
	private BigDecimal capitalSocial;

	@JsonIgnore
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;
}
