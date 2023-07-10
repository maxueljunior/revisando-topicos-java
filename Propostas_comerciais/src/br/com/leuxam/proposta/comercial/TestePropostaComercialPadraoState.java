package br.com.leuxam.proposta.comercial;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class TestePropostaComercialPadraoState {
	
	public static void main(String[] args) {
		PropostaComercial p1 = new PropostaComercial(null, null, null);
		System.out.println(p1.getStatus());
		p1.elaborar();
		System.out.println(p1.getStatus());
		p1.liberar();
		System.out.println(p1.getStatus());
		p1.consolidar();
		System.out.println(p1.getStatus());
		p1.cancelar();
	}
}
