package br.com.stefanini.scp.converters.faces;

import java.time.LocalDate;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.stefanini.scp.utils.UtilData;
import br.com.stefanini.scp.utils.UtilData.FormatoData;

@FacesConverter(value = "localDateConverter")
public class LocalDateFacesConverter implements Converter<LocalDate> {

	private String pattern;

	@Override
	public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		LocalDate localDate = null;
		try {
			localDate = UtilData.converterStringParaLocalDate(value, FormatoData.DATA);
		} catch (Exception e) {
			throw new ConverterException();
		}
		return localDate;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, LocalDate value) {
		if (value != null) {
			if (value instanceof LocalDate) {
				try {
					return UtilData.converterLocalDateParaString((LocalDate) value, FormatoData.DATA);
				} catch (Exception e) {
					throw new ConverterException();
				}
			}
		}
		return null;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
