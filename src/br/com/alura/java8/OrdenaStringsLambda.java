package br.com.alura.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsLambda {

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

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		System.out.println(palavras);

		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor);

		palavras.forEach(s -> System.out.println(s));

	}

}
