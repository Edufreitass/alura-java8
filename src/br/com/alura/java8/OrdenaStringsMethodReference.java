package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStringsMethodReference {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length()) {
				return -1;
			}
			if (s1.length() > s2.length()) {
				return 1;
			}
			return 0;
		});

//		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));

		Function<String, Integer> funcao = String::length;
		Function<String, Integer> funcao2 = s -> s.length();

		Comparator<String> comparador = Comparator.comparing(funcao);
		Comparator<String> comparador2 = Comparator.comparing(funcao2);
		palavras.sort(comparador);
		palavras.sort(comparador2);

		System.out.println(palavras);

		Consumer<String> impressor = System.out::println;
		Consumer<String> impressor2 = s -> System.out.println(s);
		palavras.forEach(impressor);
		palavras.forEach(impressor2);

		palavras.forEach(System.out::println);
		palavras.forEach(s -> System.out.println(s));

	}

}
