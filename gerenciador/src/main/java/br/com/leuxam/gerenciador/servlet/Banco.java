package br.com.leuxam.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		empresas.add(new Empresa(null, "Maxuel"));
		empresas.add(new Empresa(null, "Leuxam"));
	}
	
	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}
}
