package br.com.stefanini.scp.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.stefanini.scp.entidades.Pessoa;
import br.com.stefanini.scp.enums.Mensagens;
import br.com.stefanini.scp.exceptions.ScpNegocioException;
import br.com.stefanini.scp.repositories.PessoaDAO;

@Stateless
public class PessoaService {
	
	@Inject
	private PessoaDAO dao;

	public Pessoa salvar(Pessoa pessoa) throws ScpNegocioException {
		try {
			validarPessoaParaCadastro(pessoa);
			prepararPessoaParaSalvar(pessoa);
			return dao.salvar(pessoa);
		} catch (ScpNegocioException e) {
			throw e;
		} catch (Exception e) {
			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_CADASTRAR.getTexto());
		}
	}

	private void validarPessoaParaCadastro(Pessoa pessoa) throws ScpNegocioException {
		validarNomePessoa(pessoa.getNome());
		validarDataNascimentoPessoa(pessoa.getDataNascimento());
		validarCPFPessoa(pessoa.getCpf());
	}

	private void validarCPFPessoa(String cpf) throws ScpNegocioException {
		if (cpf == null) {
			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_CPF_NAO_PREENCHIDO.getTexto());
		}
		if (isCpfCadastrado(cpf)) {
			
		}
	}

	public boolean isCpfCadastrado(String cpf) {
		return false;
	}

	private void validarDataNascimentoPessoa(LocalDate dataNascimento) throws ScpNegocioException {
		if (dataNascimento == null) {
			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_DATA_NASCIMENTO_NAO_PREENCHIDA.getTexto());
		}
		if (dataNascimento.isAfter(LocalDate.now())) {
			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_DATA_NASCIMENTO_MAIOR_DATA_ATUAL.getTexto());
		}
	}

	private void validarNomePessoa(String nome) throws ScpNegocioException {
		if (StringUtils.isBlank(nome)) {
			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_NOME_NAO_PREENCHIDO.getTexto());
		}
	}

	private void prepararPessoaParaSalvar(final Pessoa pessoa) {
		pessoa.setDataHoraCadastro(LocalDateTime.now());
	}

//	public Optional<Pessoa> recuperarPorId(Long id) {
//		return dao.findById(id);
//	}
//
//	public List<Pessoa> listar() {
//		return dao.findAll();
//	}
//
//	public void excluirPorId(Long id) {
//		dao.deleteById(id);
//	}
//
//	public void excluir(Pessoa pessoa) {
//		dao.delete(pessoa);
//	}

}
