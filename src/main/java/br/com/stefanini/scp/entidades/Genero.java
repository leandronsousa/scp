package br.com.stefanini.scp.entidades;

import javax.persistence.Entity;

/**
 * Entidade Genero
 * 
 * @author leandro
 */
@Entity
public class Genero extends EntidadeGenerica {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	private String descricao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
