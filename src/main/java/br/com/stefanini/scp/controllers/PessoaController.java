package br.com.stefanini.scp.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.stefanini.scp.controllers.to.PessoaTO;
import br.com.stefanini.scp.entidades.Pessoa;
import br.com.stefanini.scp.services.PessoaService;

@Model
public class PessoaController extends ScpController {

	private static final long serialVersionUID = 1L;

	private @Inject PessoaService pessoaService;
	
	private PessoaTO to;

	@PostConstruct
	public void init() {
		if(getRequest().getParameter("id") != null){
			consultarPessoa(Integer.valueOf(getRequest().getParameter("id")));
		} else {
			iniciarPessoaParaCadastro();
		}
	}

	private void iniciarPessoaParaCadastro() {
		getTo().setPessoa(new Pessoa());
	}

	private void consultarListaPessoas() {
		
	}

	private void consultarPessoa(Integer valueOf) {
//		to.setPessoa(pessoa);
	}
	
	public void incluir() {
		try {
			getTo().getPessoa();
		} catch (Exception e) {
		}
	}
	
	public void excluir(Long idPessoa) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public PessoaTO getTo() {
		if (to == null) {
			to = new PessoaTO();
		}
		return to;
	}

	public void setTo(PessoaTO to) {
		this.to = to;
	}

}
