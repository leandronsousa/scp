package br.com.stefanini.scp.validators.faces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang3.StringUtils;

import br.com.stefanini.scp.enums.Mensagens;

/**
 * Valida email na view
 * 
 * @author leandro
 */
@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator<String> {
	
	private static final Pattern PATTERN = Pattern.compile("[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");

	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
		if (!StringUtils.isBlank(value.toString())) {
			Matcher matcher = PATTERN.matcher(value.toString());
			
			if (!matcher.matches()) {
				FacesMessage fmsg = new FacesMessage( FacesMessage.SEVERITY_ERROR, Mensagens.MSG_PESSOA_ERRO_EMAIL_INVALIDO.getTexto(), 
						Mensagens.MSG_PESSOA_ERRO_EMAIL_INVALIDO.getTexto());
				 throw new ValidatorException(fmsg);
			}
		}	
	}
	
}
