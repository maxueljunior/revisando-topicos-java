package br.com.alura.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.alura.escola.gamificacao.dominio.selo.RepositorySelo;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;

public class RepositorioDeSelosEmMemoria implements RepositorySelo{

	private List<Selo> selos = new ArrayList<>();
	
	@Override
	public void adicionar(Selo selo) {
		this.selos.add(selo);
	}

	@Override
	public List<Selo> listarSeloPorCPF(CPF cpf) {
		return this.selos
				.stream()
				.filter(x -> x.getCpf().getNumero().equals(cpf.getNumero()))
				.collect(Collectors.toList());
	}
	
}
