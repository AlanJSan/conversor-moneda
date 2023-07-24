package com.conversor;

import java.text.DecimalFormat;

public class ConversorLongitud extends Conversor<Longitud>{
	
	public ConversorLongitud() {
	}

	@Override
	public String convertir(String valorOrigen, String valorDestino, double cantidad) {
		// TODO Auto-generated method stub
		return new DecimalFormat("#.#######")
				.format(cantidad * Longitud.valueOf(valorDestino).getEquivalencia() / Longitud.valueOf(valorOrigen).getEquivalencia());
	}

	@Override
	public Longitud[] getValues() {
		// TODO Auto-generated method stub
		return Longitud.values();
	}

}
