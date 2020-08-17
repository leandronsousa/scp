package br.com.stefanini.scp.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.stefanini.scp.entidades.Genero;
import br.com.stefanini.scp.entidades.Pais;
import br.com.stefanini.scp.entidades.Pessoa;

@Stateless
@Default
public class PessoaDAO extends ScpDataAbstract<Pessoa> {

	public boolean isCpfCadastrado(String cpf) {
		CriteriaQuery<Long> criteriaLong = getCriteriaBuilder().createQuery(Long.class);
		Root<Pessoa> root = criteriaLong.from(Pessoa.class);
		criteriaLong.select(getCriteriaBuilder().count(root)).where(getCriteriaBuilder()
				.equal(getCriteriaBuilder().lower(getCriteriaBuilder().trim(root.get("cpf"))), cpf.toLowerCase()));
		return getManager().createQuery(criteriaLong).getSingleResult().intValue() > 0;
	}

	public List<Pais> consultarPaises() {
		CriteriaQuery<Pais> criteria = getCriteriaBuilder().createQuery(Pais.class);
		Root<Pais> root = criteria.from(Pais.class);
		return getManager().createQuery(criteria.select(root)).getResultList();
	}
	
	public List<Genero> consultarGeneros() {
		CriteriaQuery<Genero> criteria = getCriteriaBuilder().createQuery(Genero.class);
		Root<Genero> root = criteria.from(Genero.class);
		return getManager().createQuery(criteria.select(root)).getResultList();
	}

	public Genero consultarGenero(Integer codigo) {
		CriteriaQuery<Genero> criteria = getCriteriaBuilder().createQuery(Genero.class);
		Root<Genero> root = criteria.from(Genero.class);
		Predicate predicate = getCriteriaBuilder().equal(root.get("codigo"), codigo);
		return getManager().createQuery(criteria.select(root).where(predicate)).getSingleResult();
	}
	
	public Pais consultarPais(String sigla) {
		CriteriaQuery<Pais> criteria = getCriteriaBuilder().createQuery(Pais.class);
		Root<Pais> root = criteria.from(Pais.class);
		Predicate predicate = getCriteriaBuilder().equal(root.get("sigla"), sigla);
		return getManager().createQuery(criteria.select(root).where(predicate)).getSingleResult();
	}

	public void excluir(Long idPessoa) {
		iniciarTransacao();
		CriteriaDelete<Pessoa> criteria = getCriteriaBuilder().createCriteriaDelete(Pessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		getManager().createQuery(criteria.where(getCriteriaBuilder().equal(root.get("id"), idPessoa))).executeUpdate();
		commitTransacao();
	}

}
