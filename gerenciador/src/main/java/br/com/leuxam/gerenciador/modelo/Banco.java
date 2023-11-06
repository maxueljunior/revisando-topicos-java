package br.com.leuxam.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Long chaveSequencial = 1L; 
	
	static {
		empresas.add(new Empresa(chaveSequencial++, "Maxuel"));
		empresas.add(new Empresa(chaveSequencial++, "Leuxam"));
		
		Usuario u1 = new Usuario();
		u1.setLogin("maxuel");
		u1.setSenha("12345");
		
		Usuario u2 = new Usuario();
		u2.setLogin("marcos");
		u2.setSenha("12345");
		
		usuarios.add(u1);
		usuarios.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.empresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public void removeEmpresa(Long id) {
		
		Iterator<Empresa> it = empresas.iterator();
		
		while (it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscarEmpresa(Long id) {
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String paramLogin, String paramSenha) {
		for(Usuario u : usuarios) {
			if(u.ehIgual(paramLogin, paramSenha)) {
				return u;
			}
		}
		return null;
	}
}
