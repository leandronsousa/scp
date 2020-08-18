package br.com.stefanini.scp.combos;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.stefanini.scp.entidades.Genero;
import br.com.stefanini.scp.entidades.Pais;
import br.com.stefanini.scp.services.PessoaService;

/**
 * Combos para view
 * 
 * @author leandro
 */
@Named
public class CombosBean {

	private @Inject PessoaService pessoaService;
	
	public List<Pais> getPaises() {
		return pessoaService.consultarPaises();
	}
	
	public List<Genero> getGeneros() {
		return pessoaService.consultarGeneros();
	}
	
}
