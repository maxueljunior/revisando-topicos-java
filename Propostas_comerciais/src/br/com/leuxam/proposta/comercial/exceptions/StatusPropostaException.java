package br.com.leuxam.proposta.comercial.exceptions;

public class StatusPropostaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public StatusPropostaException(String msg) {
		super(msg);
	}
}
