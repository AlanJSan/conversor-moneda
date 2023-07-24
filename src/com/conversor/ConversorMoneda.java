package com.conversor;

import java.text.DecimalFormat;

public class ConversorMoneda extends Conversor<Moneda>{
	
	public ConversorMoneda() {
	}
	
	@Override
	public String convertir(String valorOrigen, String valorDestino, double cantidad) {
		// TODO Auto-generated method stub
		return new DecimalFormat("##0.0##")
				.format(cantidad * Moneda.valueOf(valorDestino).getEquivalencia() / Moneda.valueOf(valorOrigen).getEquivalencia());
	}

	@Override
	public Moneda[] getValues() {
		// TODO Auto-generated method stub
		return Moneda.values();
	}

}
