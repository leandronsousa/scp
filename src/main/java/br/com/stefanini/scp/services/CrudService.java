package br.com.stefanini.scp.services;

import java.io.Serializable;
import java.util.Optional;

import br.com.stefanini.scp.exceptions.ScpNegocioException;

/**
 * Interface que deve ser implementada para servicos que precisem 
 * implementar CRUD
 * 
 * @author leandro
 *
 * @param <T>
 * @param <ID>
 */
public interface CrudService<T, ID extends Serializable> {

	/**
	 * Metodo responsavel por salvar uma entidade
	 * 
	 * @param entity
	 * @return
	 */
	<S extends T> S salvar(S entity) throws ScpNegocioException;

	/**
	 * Metodo responsavel por recuperar uma entidade por ID
	 * 
	 * @param id
	 * @return
	 */
	Optional<T> recuperarPorId(ID id);

	/**
	 * Metodo responsavel por listar entidade
	 * 
	 * @return
	 */
	Iterable<T> listar();

	/**
	 * Metodo responsavel por excluir uma entidade por ID
	 * 
	 * @param id
	 */
	void excluirPorId(ID id);

	/**
	 * Metodo responsavel por excluir uma entidade
	 * 
	 * @param entity
	 */
	void excluir(T entity);

}
