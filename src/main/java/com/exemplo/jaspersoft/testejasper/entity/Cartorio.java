package com.exemplo.jaspersoft.testejasper.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.exemplo.jaspersoft.testejasper.enums.EnumAutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cartorio", schema = "recompe")
@Data
@EqualsAndHashCode(of = "codigo")
@SequenceGenerator(name = "seq_id_cartorio", sequenceName = "seq_id_cartorio", schema = "recompe", allocationSize = 1)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cartorio {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_cartorio")
	private Long id;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "cns")
	private String cns;

	@Column(name = "nome")
	private String nome;

	@Column(name = "municipio")
	private String municipio;

	@Column(name = "distrito")
	private String distrito;

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

	@Column(name = "cep", nullable = true)
	private String cep;

	@Column(name = "logradouro", nullable = true)
	private String logradouro;

	@Column(name = "complemento", nullable = true)
	private String complemento;

	@Column(name = "numero", nullable = true)
	private String numero;

	@Column(name = "bairro", nullable = true)
	private String bairro;

	@Column(name = "telefone_ddd", nullable = true)
	private String telefoneDDD;

	@Column(name = "telefone_numero", nullable = true)
	private String telefoneNumero;

	@Column(name = "data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Column(name = "cpf_autor_ultima_alteracao_auditoria")
	private String cpfAutorUltimaAlteracaoAuditoria;

	@Column(name = "autor_ultima_alteracao_auditoria")
	@Enumerated(EnumType.STRING)
	private EnumAutor autorUltimaAlteracaoAuditoria;

	public Cartorio() {

	}

	public Cartorio(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

}
