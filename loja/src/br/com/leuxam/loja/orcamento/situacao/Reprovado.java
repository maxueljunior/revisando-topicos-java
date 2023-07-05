package br.com.leuxam.loja.orcamento.situacao;

import br.com.leuxam.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {
	
	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new Reprovado());
	}
}
