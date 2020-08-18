package br.com.stefanini.scp.repositories;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

import br.com.stefanini.scp.EMF;

/**
 * @author leandro
 *
 */
public abstract class DataAbstract {
	
	private final EntityManager manager = EMF.createEntityManager();

	/**
	 * Prove o objeto entityManager para as classes que herdam
	 * 
	 * @return
	 */
	protected EntityManager getManager() {
		return this.manager;
	}

	/**
	 * Prove o objeto criteriaBuilder
	 * 
	 * @return
	 */
	protected CriteriaBuilder getCriteriaBuilder() {
		return this.manager.getCriteriaBuilder();
	}
	
	/**
	 * iniciar uma transacao quando nao gerenciada pelo container
	 */
	protected void iniciarTransacao() {
		getManager().getTransaction().begin();
	}
	
	/**
	 * commit na transacao quando nao gerenciada pelo container
	 */
	protected void commitTransacao() {
		getManager().getTransaction().commit();
	}
	
	/**
 	 * rollback na transacao quando nao gerenciada pelo container
	 */
	protected void rollbackTransacao() {
		getManager().getTransaction().rollback();
	}
	
	/**
	 * Prove a sessao da transacao
	 * 
	 * @return
	 */
	protected Session getSession() {
		return getManager().unwrap(SessionImpl.class);
	}
	
}
