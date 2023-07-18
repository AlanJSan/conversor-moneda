package com.conversor;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ConversorMoneda implements Conversor{
	
	
	public ConversorMoneda() {
		
	}
	

	@Override
	public String convertir(String monedaOrigen, String monedaDestino, double cantidad) {
		// TODO Auto-generated method stub
		return new DecimalFormat("#.00")
				.format(cantidad * Moneda.valueOf(monedaDestino).getEquivalencia() / Moneda.valueOf(monedaOrigen).getEquivalencia());
	}

}
