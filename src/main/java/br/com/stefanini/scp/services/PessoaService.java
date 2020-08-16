package br.com.stefanini.scp.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.stefanini.scp.repositories.PessoaDAO;

@Stateless
public class PessoaService {
	
	@Inject
	private PessoaDAO repository;

//	@SuppressWarnings("unchecked")
//	public Usuario salvar(Usuario usuario) throws ScpNegocioException {
//		try {
//			validarUsuarioParaCadastro(usuario);
//			prepararUsuarioParaSalvar(usuario);
//			return repository.save(usuario);
//		} catch (ScpNegocioException e) {
//			throw e;
//		} catch (Exception e) {
//			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_CADASTRAR.getTexto());
//		}
//	}
//
//	private void validarUsuarioParaCadastro(Usuario usuario) throws ScpNegocioException {
//		validarNomeUsuario(usuario.getNome());
//		validarDataNascimentoUsuario(usuario.getDataNascimento());
//		validarCPFUsuario(usuario.getCpf());
//	}
//
//	private void validarCPFUsuario(String cpf) throws ScpNegocioException {
//		if (cpf == null) {
//			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_CPF_NAO_PREENCHIDO.getTexto());
//		}
//		if (isCpfCadastrado(cpf)) {
//			
//		}
//	}
//
//	public boolean isCpfCadastrado(String cpf) {
//		return false;
//	}
//
//	private void validarDataNascimentoUsuario(LocalDate dataNascimento) throws ScpNegocioException {
//		if (dataNascimento == null) {
//			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_DATA_NASCIMENTO_NAO_PREENCHIDA.getTexto());
//		}
//		if (dataNascimento.isAfter(LocalDate.now())) {
//			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_DATA_NASCIMENTO_MAIOR_DATA_ATUAL.getTexto());
//		}
//	}
//
//	private void validarNomeUsuario(String nome) throws ScpNegocioException {
//		if (StringUtils.isBlank(nome)) {
//			throw new ScpNegocioException(Mensagens.MSG_USUARIO_ERRO_NOME_NAO_PREENCHIDO.getTexto());
//		}
//	}
//
//	private void prepararUsuarioParaSalvar(final Usuario usuario) {
//		usuario.setDataHoraCadastro(LocalDateTime.now());
//	}
//
//	public Optional<Usuario> recuperarPorId(Long id) {
//		return repository.findById(id);
//	}
//
//	public List<Usuario> listar() {
//		return repository.findAll();
//	}
//
//	public void excluirPorId(Long id) {
//		repository.deleteById(id);
//	}
//
//	public void excluir(Usuario usuario) {
//		repository.delete(usuario);
//	}

}
