package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso2 {
	private String nome;
	private int alunos;
	
	public Curso2(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
	
}

public class ExemploCursos2 {

	public static void main(String[] args) {
		
		List<Curso2> cursos2 = new ArrayList<>();
		cursos2.add(new Curso2("Python", 45));
		cursos2.add(new Curso2("JavaScript", 150));
		cursos2.add(new Curso2("Java 8", 113));
		cursos2.add(new Curso2("C", 55));
		
		cursos2.sort(Comparator.comparing(Curso2::getAlunos));
		
		int sum = cursos2.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso2::getAlunos)
				.sum();
		
		System.out.println(sum);
		
		OptionalDouble media = cursos2.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso2::getAlunos)
				.average();
		
		// Curso, me de o fluxo de todos os cursos, 
		// filtre quem tem mais de 100,
		// encontre algum deles, 
		// se encontrou, faça isso, se não, não faça nada.
//		cursos2.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.findAny()
//			.ifPresent(c -> System.out.println(c.getNome()));
//		
//		cursos2.stream()
//			.filter(c -> c.getAlunos() >= 100);
		
		// Trabalhando com Collectors
//		cursos2 = cursos2.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.collect(Collectors.toList());
//		
//		cursos2.stream()
//			.forEach(c -> System.out.println(c.getNome()));
		
		// Trabalhando com Collectors e Map
//		Map<String, Integer> map = cursos2.stream()
//				.filter(c -> c.getAlunos() >= 100)
//				.collect(Collectors.toMap(
//						c -> c.getNome(),
//						c -> c.getAlunos()));
//		
//		System.out.println(map);
		
		// Trabalhando com Collectors, Map e forEach(que neste caso recebe um BiConsumer<K,V>
		cursos2.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(
						c -> c.getNome(),
						c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
	}
	
}
