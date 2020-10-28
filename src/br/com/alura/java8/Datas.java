package br.com.alura.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {

		// DATAS
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);

		LocalDate copaDoMundo2022 = LocalDate.of(2022, Month.NOVEMBER, 21);

		int anos = copaDoMundo2022.getYear() - hoje.getYear();

		System.out.println(anos);

		Period periodo = Period.between(hoje, copaDoMundo2022);

		System.out.println("Anos:" + periodo.getYears() + " Dias:"+  periodo.getDays());
		
		LocalDate proximaCopaDoMundo = copaDoMundo2022.plusYears(4);
		
		System.out.println(proximaCopaDoMundo);
		
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String valorFormatado = proximaCopaDoMundo.format(formatadorData);
		System.out.println(valorFormatado);
		
		// DATAS e HORAS
		DateTimeFormatter formatadorDataHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorDataHoras));
		
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println(intervalo);
		
	}

}
