package br.com.stefanini.scp.converters.faces;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.stefanini.scp.entidades.Genero;
import br.com.stefanini.scp.services.PessoaService;

/**
 * Conversor de genero para faces
 * 
 * @author leandro
 */
@Named
public class GeneroFacesConverter implements Converter<Genero> {
	
	private @Inject PessoaService pessoaService;

	@Override
	public Genero getAsObject(FacesContext context, UIComponent component, String value) {
		Genero genero = null;
		if (!StringUtils.isBlank(value)) {
			try {
				genero = pessoaService.consultarGenero(Integer.valueOf(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return genero;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Genero value) {
		if (value == null) {
			return null;
		}
		if (value instanceof Genero) {
			return value.getCodigo().toString();
		} else {
			throw new IllegalArgumentException("Cannot convert object");
		}
	}

}
