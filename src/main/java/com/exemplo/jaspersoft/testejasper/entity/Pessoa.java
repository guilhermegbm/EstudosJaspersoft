package com.exemplo.jaspersoft.testejasper.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.exemplo.jaspersoft.testejasper.enums.EnumAutor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "pessoa", schema = "recompe")
@SequenceGenerator(name = "seq_id_pessoa", sequenceName = "seq_id_pessoa", schema = "recompe", allocationSize = 1)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pessoa {

	@Id
	@Column(name = "id_pessoa")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_pessoa")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg_orgao_expedidor")
	private String rgOrgaoExpedidor;

	@Column(name = "rg_uf_orgao_expedidor")
	private String rgUFOrgaoExpedidor;

	@Column(name = "rg")
	private String rg;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Oficial> oficiais;

	@Column(name = "deseja_carteira_funcional")
	private Boolean desejaCarteiraFuncional;

	@Column(name = "filiacao_nome_mae")
	private String filiacaoNomeMae;

	@Column(name = "filiacao_nome_pai")
	private String filiacaoNomePai;

	@Column(name = "pai_nao_declarado")
	private Boolean paiNaoDeclarado;

	@Column(name = "naturalidade_uf")
	private String naturalidadeUF;

	@Column(name = "naturalidade_municipio")
	private String naturalidadeMunicipio;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataNascimento;

	@Column(name = "lgpd")
	private Boolean lgpd;

	@Column(name = "data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Column(name = "cpf_autor_ultima_alteracao_auditoria")
	private String cpfAutorUltimaAlteracaoAuditoria;

	@Column(name = "autor_ultima_alteracao_auditoria")
	@Enumerated(EnumType.STRING)
	private EnumAutor autorUltimaAlteracaoAuditoria;

	public Pessoa() {

	}

	public Pessoa(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
}
