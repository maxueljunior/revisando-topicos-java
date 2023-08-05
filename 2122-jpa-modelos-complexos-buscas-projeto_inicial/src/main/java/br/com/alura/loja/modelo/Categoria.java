package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@EmbeddedId
	private CategoriaId categoria;
	
	public Categoria() {
	}
	
	public Categoria(String nome) {
		this.categoria = new CategoriaId(nome, "XPTO");
	}

	public String getNome() {
		return this.categoria.getNome();
	}

}
