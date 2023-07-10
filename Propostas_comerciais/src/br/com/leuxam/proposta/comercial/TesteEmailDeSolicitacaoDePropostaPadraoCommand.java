package br.com.leuxam.proposta.comercial;

import java.time.LocalDate;
import java.time.Month;

import br.com.leuxam.proposta.comercial.models.GeraEmailDeSolicitaoDeProposta;
import br.com.leuxam.proposta.comercial.models.handlers.GeraEmailDeSolicitacaoDePropostaHandler;

public class TesteEmailDeSolicitacaoDePropostaPadraoCommand {

	public static void main(String[] args) {
		String cliente = "Atvos - Paraná";
		String maquina = "RTS-800";
		LocalDate prazo = LocalDate.of(2023, Month.JULY, 29);
		
		GeraEmailDeSolicitaoDeProposta gerador = new GeraEmailDeSolicitaoDeProposta(cliente, prazo, maquina);
		GeraEmailDeSolicitacaoDePropostaHandler handler = new GeraEmailDeSolicitacaoDePropostaHandler();
		handler.executa(gerador);
	}

}
