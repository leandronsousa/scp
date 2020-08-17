package br.com.stefanini.scp.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.stefanini.scp.controllers.to.PessoaTO;
import br.com.stefanini.scp.entidades.Pessoa;
import br.com.stefanini.scp.enums.Mensagens;
import br.com.stefanini.scp.exceptions.ScpNegocioException;
import br.com.stefanini.scp.services.PessoaService;

@Model
public class PessoaController extends ScpController {

	private static final long serialVersionUID = 1L;

	private @Inject PessoaService pessoaService;
	
	private PessoaTO to;

	@PostConstruct
	public void init() {
		if(getRequest().getParameter("parametro") != null) {
			if (getRequest().getParameter("parametro").equals("new")) {
				getTo().setPessoa(new Pessoa());
 			} else if (getRequest().getParameter("parametro").equals("edit")) {
 				if (getRequest().getParameter("id") != null) {
 					consultarPessoa(Long.valueOf(getRequest().getParameter("id")));
 				}
 			}
		} else {
			consultarListaPessoas();
		}
	}

	private void consultarListaPessoas() {
		getTo().setPessoas(pessoaService.consultarPessoas());
	}

	private String alterar() {
		try {
			pessoaService.alterar(getTo().getPessoa());
			adicionarMensagemInfo(Mensagens.MSG_PESSOA_SUCESSO_ALTERACAO.getTexto(), Mensagens.MSG_PESSOA_SUCESSO_ALTERACAO.getTexto());
			return "/pages/pessoa/pessoas-list.xhtml?param=lista&faces-redirect=true&includeViewParams=true";
		} catch (ScpNegocioException e) {
			adicionarMensagemErro(e.getLocalizedMessage(), e.getLocalizedMessage());
			return "/pages/pessoa/pessoa-form.xhtml?faces-redirect=true&includeViewParams=true";
		} catch (Exception e) {
			adicionarMensagemErro(Mensagens.MSG_PESSOA_ERRO_ALTERACAO.getTexto(), Mensagens.MSG_PESSOA_ERRO_ALTERACAO.getTexto());
			return "/pages/pessoa/pessoa-form.xhtml?faces-redirect=true&includeViewParams=true";
		}
	}

	private void consultarPessoa(Long id) {
		try {
			getTo().setPessoa(pessoaService.consultarPessoa(id));
		} catch (Exception e) {
			adicionarMensagemErro(Mensagens.MSG_PESSOA_ERRO_CONSULTA.getTexto(), Mensagens.MSG_PESSOA_ERRO_CONSULTA.getTexto());
		}
	}
	
	public String salvar() {
		if (getTo().getPessoa().getId() == null) {
			return incluir();
		} else {
			return alterar();
		}
	}
	
	private String incluir() {
		try {
			pessoaService.incluir(getTo().getPessoa());
			adicionarMensagemInfo(Mensagens.MSG_PESSOA_SUCESSO_CADASTRO.getTexto(), Mensagens.MSG_PESSOA_SUCESSO_CADASTRO.getTexto());
			return "/pages/pessoa/pessoas-list.xhtml?faces-redirect=true&includeViewParams=true";
		} catch (ScpNegocioException e) {
			adicionarMensagemErro(e.getLocalizedMessage(), e.getLocalizedMessage());
			return "/pages/pessoa/pessoa-form.xhtml?parametro=new&faces-redirect=true&includeViewParams=true";
		} catch (Exception e) {
			adicionarMensagemErro(Mensagens.MSG_PESSOA_ERRO_CADASTRAR.getTexto(), Mensagens.MSG_PESSOA_ERRO_CADASTRAR.getTexto());
			return "/pages/pessoa/pessoa-form.xhtml?parametro=new&faces-redirect=true&includeViewParams=true";
		}
	}
	
	public void excluir(Long id) {
		try {
			pessoaService.excluir(id);
			adicionarMensagemInfo(Mensagens.MSG_PESSOA_SUCESSO_EXCLUSAO.getTexto(), Mensagens.MSG_PESSOA_SUCESSO_EXCLUSAO.getTexto());
			consultarListaPessoas();
		} catch (Exception e) {
			e.printStackTrace();
			adicionarMensagemInfo(Mensagens.MSG_PESSOA_ERRO_EXCLUSAO.getTexto(), Mensagens.MSG_PESSOA_ERRO_EXCLUSAO.getTexto());
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
