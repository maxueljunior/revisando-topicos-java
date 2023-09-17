package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {
	private String nome;
	private Integer alunos;
	
	public Curso(String nome, Integer alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public Integer getAlunos() {
		return alunos;
	}
	
}

public class ExemploCursos{
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		
		
//		cursos = cursos.stream()
//				   .filter(c -> c.getAlunos() > 50)
//				   .collect(Collectors.toList());
		
		
//		OptionalDouble numero = cursos.stream()
//				.mapToInt(Curso::getAlunos)
//				.average();
//				
//		System.out.println(numero);
		
//		cursos.stream()
//			.filter(c -> c.getAlunos() > 50)
//			.findFirst()
//			.ifPresent(c -> System.out.println(c.getNome() + " tem " + c.getAlunos()));
		
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
//		cursos.stream()
//		   .filter(c -> c.getAlunos() > 50)
//		   .map(Curso::getNome)
//		   .forEach(System.out::println);
		
//		cursos.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.findAny()
//			.ifPresent(c -> System.out.println(c.getNome()));
		
//		cursos = cursos.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.collect(Collectors.toList());
		
		
//		cursos.stream()
//				.filter(c -> c.getAlunos() >= 100)
//				.collect(Collectors.toMap(
//						c -> c.getNome(),
//						c -> c.getAlunos()))
//				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos));
	}
}

























