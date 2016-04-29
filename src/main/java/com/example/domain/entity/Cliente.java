package com.example.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.domain.entity.enums.TipoDocumentoEnum;
import com.example.domain.shared.BaseEntity;

@Entity
public class Cliente implements BaseEntity{
	private static final long serialVersionUID = 7713394845972669093L;
	
	private  Long id;
	private String nome;
	private String endereco;
	private String cidade;
	private String uf;
	private TipoDocumentoEnum tipoDocumento;
	private String numeroDocumento;
	private LocalDate dataNascimento;
	private Double receitaMensal;
	
	//Metamodel
	public static class Cliente_ {
	    public static final String ID = "id";
	    public static final String TIPO_DOCUMENTO = "tipoDocumento"; 
	    public static final String NUMERO_DOCUMENTO = "numeroDocumento"; 
	}	
	
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(nullable=false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public TipoDocumentoEnum getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Double getReceitaMensal() {
		return receitaMensal;
	}
	public void setReceitaMensal(Double receitaMensal) {
		this.receitaMensal = receitaMensal;
	}
	
}