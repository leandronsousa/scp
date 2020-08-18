package br.com.stefanini.scp.converters.faces;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.stefanini.scp.entidades.Pais;
import br.com.stefanini.scp.services.PessoaService;

/**
 * conversor de nacionalidade para faces
 * 
 * @author leandro
 */
@Named
public class NacionalidadeFacesConverter implements Converter<Pais> {
	
	private @Inject PessoaService pessoaService;

	@Override
	public Pais getAsObject(FacesContext context, UIComponent component, String value) {
		Pais pais = null;
		if (!StringUtils.isBlank(value)) {
			try {
				pais = pessoaService.consultarPais(value);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pais;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Pais value) {
		if (value == null) {
			return null;
		}
		if (value instanceof Pais) {
			return value.getSigla();
		} else {
			throw new IllegalArgumentException("Cannot convert object");
		}
	}

}
