package br.com.stefanini.scp.exceptions;

public class ScpException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ScpException() {
		super();
	}
	
	public ScpException(String mensagem) {
		super(mensagem);
	}

}
