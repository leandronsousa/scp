package br.com.stefanini.scp.controllers.to;

import java.io.Serializable;
import java.util.List;

import br.com.stefanini.scp.entidades.Pessoa;

/**
 * CLasse para transitar objetos entre view e controller
 * 
 * @author leandro
 *
 */
public class PessoaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	
	private List<Pessoa> pessoas;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
