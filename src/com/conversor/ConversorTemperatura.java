package com.conversor;

import java.text.DecimalFormat;

public class ConversorTemperatura extends Conversor<Temperatura>{

	public ConversorTemperatura() {
	}

	@Override
	public String convertir(String valorOrigen, String valorDestino, double cantidad) {
		// TODO Auto-generated method stub
		double resultado = 0;
		switch (valorOrigen) {
		case "C":
			resultado = valorDestino.equals(Temperatura.F.name()) ? cantidad * 1.8 + 32 : cantidad + 273.15;
			break;
		case "F":
			resultado = valorDestino.equals(Temperatura.C.name()) ? (cantidad - 32) / (1.8) : 5/9D * (cantidad - 32) + 273.15;
			break;
		case "K":
			resultado = valorDestino.equals(Temperatura.C.name()) ? cantidad - 273.15 : 1.8 * (cantidad - 273.15) + 32;
			break;
		default:
			break;
		}
		return new DecimalFormat("##0.###").format(resultado);
	}

	@Override
	public Temperatura[] getValues() {
		// TODO Auto-generated method stub
		return Temperatura.values();
	}

	

}
