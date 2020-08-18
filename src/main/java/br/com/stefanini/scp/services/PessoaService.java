package br.com.stefanini.scp.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import br.com.stefanini.scp.entidades.Genero;
import br.com.stefanini.scp.entidades.Pais;
import br.com.stefanini.scp.entidades.Pessoa;
import br.com.stefanini.scp.enums.Mensagens;
import br.com.stefanini.scp.exceptions.ScpNegocioException;
import br.com.stefanini.scp.repositories.PessoaDAO;
import br.com.stefanini.scp.utils.UtilValidadorCpf;

/**
 * Negocio de pessoa
 * 
 * @author leandro
 *
 */
@Stateless
public class PessoaService {
	
	@Inject
	private PessoaDAO dao;

	/**
	 * Inclui Pessoa
	 * 
	 * @param pessoa
	 * @return
	 * @throws ScpNegocioException
	 */
	public Pessoa incluir(Pessoa pessoa) throws ScpNegocioException {
		try {
			prepararPessoaParaIncluir(pessoa);
			validarCadastroPessoa(pessoa);
			return dao.incluir(pessoa);
		} catch (ScpNegocioException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScpNegocioException(Mensagens.MSG_PESSOA_ERRO_CADASTRAR.getTexto());
		}
	}

	/**
	 * Verifica se CPF ja esta cadastrado
	 * 
	 * @param cpf
	 * @return
	 */
	public boolean isCpfCadastrado(String cpf) {
		return dao.isCpfCadastrado(cpf);
	}
	
	/**
	 * Consulta todos os paises
	 * 
	 * @return
	 */
	public List<Pais> consultarPaises() {
		return dao.consultarPaises();
	}
	
	/**
	 * Consulta todos os generos
	 * 
	 * @return
	 */
	public List<Genero> consultarGeneros() {
		return dao.consultarGeneros();
	}

	/**
	 * Consulta genero por id
	 * 
	 * @param codigo
	 * @return
	 */
	public Genero consultarGenero(Integer codigo) {
		return dao.consultarGenero(codigo);
	}
	
	/**
	 * Consulta Pais por sigla
	 * 
	 * @param sigla
	 * @return
	 */
	public Pais consultarPais(String sigla) {
		return dao.consultarPais(sigla);
	}

	/**
	 * Consulta Pessoa por ID
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Pessoa consultarPessoa(Long id) throws Exception {
		return dao.recuperar(id);
	}

	/**
	 * Consulta todas as pessoas
	 * 
	 * @return
	 */
	public List<Pessoa> consultarPessoas() {
		return dao.listar();
	}

	/**
	 * Exclui pessoa por ID
	 * 
	 * @param idPessoa
	 */
	public void excluir(Long idPessoa) {
		dao.excluir(idPessoa);
	}
	
	/**
	 * Altera pessoa
	 * 
	 * @param pessoa
	 * @throws ScpNegocioException
	 */
	public void alterar(Pessoa pessoa) throws ScpNegocioException {
		try {
			prepararPessoaParaAlterar(pessoa);
			validarAlteracaoPessoa(pessoa);
			dao.alterar(pessoa);
		} catch (ScpNegocioException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScpNegocioException(Mensagens.MSG_PESSOA_ERRO_CADASTRAR.getTexto());
		}
	}
	
	private void validarCadastroPessoa(Pessoa pessoa) throws ScpNegocioException {
		validarNomePessoa(pessoa.getNome());
		validarDataNascimentoPessoa(pessoa.getDataNascimento());
		validarCPFPessoa(pessoa.getCpf());
	}

	private void validarCPFPessoa(String cpf) throws ScpNegocioException {
		validarCpfPreenchido(cpf);
		validarCpfValido(cpf);
		validarCpfCadastrado(cpf);
	}

	private void validarCpfPreenchido(String cpf) throws ScpNegocioException {
		if (cpf == null) {
			throw new ScpNegocioException(Mensagens.MSG_PESSOA_ERRO_CPF_NAO_PREENCHIDO.getTexto());
		}
	}

	private void validarCpfValido(String cpf) throws ScpNegocioException {
		if (!UtilValidadorCpf.validaCPF(cpf)) {
			throw new ScpNegocioException(Mensagens.MSG_PESSOA_ERRO_CPF_INVALIDO.getTexto());
		}
	}

	private void validarCpfCadastrado(String cpf) throws ScpNegocioException {
		if (isCpfCadastrado(cpf)) {
			throw new ScpNegocioException(Mensagens.MSG_PESSOA_ERRO_CPF_JA_CADASTRADO.getTexto());
		}
	}

	private void validarDataNascimentoPessoa(LocalDate dataNascimento) throws ScpNegocioException {
		validarDataNascimentoPreenchida(dataNascimento);
		validarDataNascimentoMaiorDataAtual(dataNascimento);
	}

	private void validarDataNascimentoMaiorDataAtual(LocalDate dataNascimento) throws ScpNegocioException {
		if (dataNascimento.isAfter(LocalDate.now())) {
			throw new ScpNegocioException(Mensagens.MSG_PESSOA_ERRO_DATA_NASCIMENTO_MAIOR_DATA_ATUAL.getTexto());
		}
	}

	private void validarDataNascimentoPreenchida(LocalDate dataNascimento) throws ScpNegocioException {
		if (dataNascimento == null) {
			throw new ScpNegocioException(Mensagens.MSG_PESSOA_ERRO_DATA_NASCIMENTO_NAO_PREENCHIDA.getTexto());
		}
	}

	private void validarNomePessoa(String nome) throws ScpNegocioException {
		if (StringUtils.isBlank(nome)) {
			throw new ScpNegocioException(Mensagens.MSG_PESSOA_ERRO_NOME_NAO_PREENCHIDO.getTexto());
		}
	}

	private void prepararPessoaParaIncluir(final Pessoa pessoa) {
		pessoa.setDataHoraCadastro(LocalDateTime.now());
		pessoa.setCpf(RegExUtils.removePattern(pessoa.getCpf(), "[^0-9]"));
	}

	private void validarAlteracaoPessoa(Pessoa pessoa) throws ScpNegocioException {
		validarNomePessoa(pessoa.getNome());
		validarDataNascimentoPessoa(pessoa.getDataNascimento());
		validarCPFPessoaAlteracao(pessoa.getCpf());
	}

	private void validarCPFPessoaAlteracao(String cpf) throws ScpNegocioException {
		validarCpfPreenchido(cpf);
		validarCpfValido(cpf);
	}

	private void prepararPessoaParaAlterar(Pessoa pessoa) {
		pessoa.setCpf(RegExUtils.removePattern(pessoa.getCpf(), "[^0-9]"));
	}

}
