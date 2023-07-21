package com.conversor;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		ConversorMoneda ob = new ConversorMoneda();
		System.out.println(ob.convertir(Moneda.MXN.name(),Moneda.EUR.name(),23));
		System.out.println(Moneda.MXN.getSimbolo()+Moneda.MXN.getEquivalencia()+" - "+Moneda.MXN.getNombreMoneda());
		Moneda[] monedas = Moneda.values();
		List<Moneda> listaMoneda = new ArrayList<>();
		
		for (Moneda moneda : monedas) {
			listaMoneda.add(moneda);
			System.out.println(moneda + " " + moneda.getEquivalencia() + " " + moneda.getNombreMoneda() + " " + moneda.getSimbolo());			
		}
		System.out.println(Moneda.MXN.name() instanceof String);
		
		listaMoneda.forEach(System.out::println);
	}

}
