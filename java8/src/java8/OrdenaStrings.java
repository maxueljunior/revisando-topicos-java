package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {
	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura");
		palavras.add("editora");
		palavras.add("caelum");

		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		//palavras.sort(Comparator.comparing(String::length));
		palavras.sort(Comparator.comparing(String::hashCode));
		
		System.out.println(palavras);
		
		//palavras.forEach(System.out::println);
		palavras.forEach(System.out::println);
	}
}
