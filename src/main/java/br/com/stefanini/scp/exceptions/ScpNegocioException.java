package br.com.stefanini.scp.exceptions;

public class ScpNegocioException extends ScpException {

	private static final long serialVersionUID = 1L;

	public ScpNegocioException() {
	}
	
	public ScpNegocioException(String mensagem) {
		super(mensagem);
	}
	
}
