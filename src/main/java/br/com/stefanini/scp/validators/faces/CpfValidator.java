package br.com.stefanini.scp.validators.faces;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang3.StringUtils;

import br.com.stefanini.scp.utils.UtilValidadorCpf;

@FacesValidator(value = "cpfValidator")
public class CpfValidator implements Validator<String> {

	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
		if (!StringUtils.isBlank(value)) {
			String cpfSemMascara = value.replaceAll("[^0-9]", "");
			if(!UtilValidadorCpf.validaCPF(cpfSemMascara)){
				FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Invalido", "CPF Invalido");
				throw new ValidatorException(fmsg);
			}
		}
	}
	
}
