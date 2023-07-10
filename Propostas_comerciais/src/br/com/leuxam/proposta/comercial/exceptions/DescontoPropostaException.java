package br.com.leuxam.proposta.comercial.exceptions;

public class DescontoPropostaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DescontoPropostaException(String msg) {
		super(msg);
	}
}
