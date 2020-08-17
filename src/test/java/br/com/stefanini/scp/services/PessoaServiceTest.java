package br.com.stefanini.scp.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.stefanini.scp.entidades.Pessoa;
import br.com.stefanini.scp.enums.Mensagens;
import br.com.stefanini.scp.exceptions.ScpNegocioException;
import br.com.stefanini.scp.repositories.PessoaDAO;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

	@InjectMocks
	private PessoaService service;
	
	@Mock
	private PessoaDAO dao;
	
	public void init() {
		MockitoAnnotations.openMocks(PessoaService.class);
	}
	
	@Test(expected = ScpNegocioException.class)
	public void testeSalvarPessoaSemDataNascimento() throws ScpNegocioException {
		Pessoa pessoa = getPessoa();
		pessoa.setDataNascimento(null);
		service.incluir(pessoa);
		fail(Mensagens.MSG_PESSOA_ERRO_DATA_NASCIMENTO_NAO_PREENCHIDA.getTexto());
	}
	
	@Test(expected = ScpNegocioException.class)
	public void testeSalvarPessoaDataNascimentoMaiorDataAtual() throws ScpNegocioException {
		Pessoa pessoa = getPessoa();
		pessoa.setDataNascimento(LocalDate.now().plusDays(2));
		service.incluir(pessoa);
		fail(Mensagens.MSG_PESSOA_ERRO_DATA_NASCIMENTO_MAIOR_DATA_ATUAL.getTexto());
	}
	
	@Test(expected = ScpNegocioException.class)
	public void testeSalvarPessoaCpfInvalido() throws ScpNegocioException {
		Pessoa pessoa = getPessoa();
		pessoa.setCpf("154646445644");
		service.incluir(pessoa);
		fail(Mensagens.MSG_PESSOA_ERRO_CPF_INVALIDO.getTexto());
	}
	
	@Test(expected = ScpNegocioException.class)
	public void testeSalvarPessoaCpfNaoPreenchido() throws ScpNegocioException {
		Pessoa pessoa = getPessoa();
		pessoa.setCpf(null);
		service.incluir(pessoa);
		fail(Mensagens.MSG_PESSOA_ERRO_CPF_NAO_PREENCHIDO.getTexto());
	}
	
	@Test(expected = ScpNegocioException.class)
	public void testeSalvarPessoaCpfJaCadastrado() throws ScpNegocioException {
		Pessoa pessoa = getPessoa();
		when(dao.isCpfCadastrado(anyString())).thenReturn(true);
		service.incluir(pessoa);
		fail(Mensagens.MSG_PESSOA_ERRO_CPF_JA_CADASTRADO.getTexto());
	}
	
	@Test(expected = ScpNegocioException.class)
	public void testeSalvarPessoaNomeNaoPreenchido() throws ScpNegocioException {
		Pessoa pessoa = getPessoa();
		pessoa.setNome(null);
		service.incluir(pessoa);
		fail(Mensagens.MSG_PESSOA_ERRO_NOME_NAO_PREENCHIDO.getTexto());
	}
	
	@Test(expected = ScpNegocioException.class)
	public void testeSalvarPessoaException() throws Exception {
		Pessoa pessoa = getPessoa();
		doThrow(new Exception()).when(dao).incluir(any());
		service.incluir(pessoa);
		fail(Mensagens.MSG_PESSOA_ERRO_CADASTRAR.getTexto());
	}
	
	@Test
	public void testeSalvarPessoaSucesso() throws Exception {
		Pessoa pessoa = getPessoa();
		pessoa.setId(2L);
		when(dao.incluir(any())).thenReturn(pessoa);
		Pessoa pessoaSalva = service.incluir(pessoa);
		assertEquals(pessoa.getId(), pessoaSalva.getId());
	}

	private Pessoa getPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("leandro");
		pessoa.setCpf("41373093021");
		pessoa.setEmail("leandronsousa@gmail.com");
		pessoa.setNaturalidade("Bsb");
		pessoa.setDataNascimento(LocalDate.now().minusYears(10));
		return pessoa;
	}
	
}
