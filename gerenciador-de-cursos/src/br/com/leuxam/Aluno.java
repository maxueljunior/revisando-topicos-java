package br.com.leuxam;

import java.util.Objects;

public class Aluno {

	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int numeroMatricula) {
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Aluno)) return false;
		Aluno aluno = (Aluno) o;
		return Objects.equals(getNome(), aluno.getNome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNome());
	}

	@Override
	public String toString() {
		return "[Aluno: " + this.nome + ", matricula: " + this.numeroMatricula
				+ "]";
	}
}
