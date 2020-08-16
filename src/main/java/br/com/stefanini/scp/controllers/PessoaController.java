package br.com.stefanini.scp.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.stefanini.scp.controllers.to.PessoaTO;
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
			consultarListaPessoas();
		}
	}

	private void consultarListaPessoas() {
		
	}

	private void consultarPessoa(Integer valueOf) {
//		to.setPessoa(pessoa);
	}

	public PessoaTO getTo() {
		return to;
	}

	public void setTo(PessoaTO to) {
		this.to = to;
	}

}
