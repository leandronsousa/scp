package br.com.stefanini.scp.entidades;

import javax.persistence.Id;

public class Pais extends EntidadeGenerica {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String sigla;
	
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
