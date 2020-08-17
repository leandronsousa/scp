package br.com.stefanini.scp.repositories;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

import br.com.stefanini.scp.EMF;

public abstract class DataAbstract {
	
	private final EntityManager manager = EMF.createEntityManager();

	/**
	 * Retorna o(a) manager.
	 * 
	 * @return EntityManager
	 */
	protected EntityManager getManager() {
		return this.manager;
	}
	/**
	 * Retorna o(a) Criteria Builder.
	 * 
	 * @return EntityManager
	 */
	protected CriteriaBuilder getCriteriaBuilder() {
		return this.manager.getCriteriaBuilder();
	}
	
	protected void iniciarTransacao() {
		getManager().getTransaction().begin();
	}
	
	protected void commitTransacao() {
		getManager().getTransaction().commit();
	}
	
	protected void rollbackTransacao() {
		getManager().getTransaction().rollback();
	}

	protected Session getSession() {
		return getManager().unwrap(SessionImpl.class);
	}
	
}
