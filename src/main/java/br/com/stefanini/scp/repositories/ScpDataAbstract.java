package br.com.stefanini.scp.repositories;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

/**
 * @author leandro
 *
 * @param <T>
 */
public abstract class ScpDataAbstract<T> extends DataAbstract	 {

	/**
	 * alterar registro
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void alterar(T entity) throws Exception {
		iniciarTransacao();
		getManager().merge(entity);
		getManager().flush();
		commitTransacao();
	}

	/**
	 * incluir novo registro
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T incluir(T entity) throws Exception {
		try {
			iniciarTransacao();
			getManager().persist(entity);
			getManager().flush();
			commitTransacao();
			return entity;
		} catch (ConstraintViolationException e) {
			throw e;
		} catch (Exception e) {
			if (e instanceof java.sql.BatchUpdateException) {
				((java.sql.BatchUpdateException) e).getNextException().printStackTrace();
				throw new RuntimeException(e);
			}
			else{
			    throw e;
			}	
		}
	}

	/**
	 * LIstar entidade
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> listar() {
		Class entityType = this.getEntityType();
		Annotation[] annotations = entityType.getAnnotations();
		String namedQuery = null;
		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(NamedQuery.class)) {
				NamedQuery named = (NamedQuery) annotation;
				namedQuery = named.name();
				break;
			}
		}
		Query query = null;
		if (namedQuery != null) {
			query = this.getManager().createNamedQuery(namedQuery);
		} else {
			query =
					this.getManager().createQuery(
							"FROM ".concat(entityType.getName()));
		}
		return query.getResultList();
	}
	
	/**
	 * Recuperar Entidade
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public T recuperar(Serializable id) throws Exception{
		T r = (T) this.getManager().find(this.getEntityType(), id);
		if(r == null){
//			throw new BusinessException(ConstantesMensagem.NENHUM_REGISTRO_ENCONTRADO);
		}
		return r;
	}
	
	/**
	 * Retorna o Tipo da Parametrizacao da concretizacao do Bean
	 * 
	 * @return clazz Class
	 */
	@SuppressWarnings("rawtypes")
	protected Class getEntityType() {
		ParameterizedType parameterizedType =
				(ParameterizedType) this.getClass().getGenericSuperclass();
		Class entityType =
				(Class) parameterizedType.getActualTypeArguments()[0];
		return entityType;
	}
	
}
