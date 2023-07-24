package com.conversor;

public enum Longitud {
	MILIMETROS(1000.0, "mm"),
	CENTIMETROS(100.0, "cm"),
	METROS(1.0, "m"),
	KILOMETROS(0.001, "km");
	
	private final double equivalencia;
	private final String siglas;

	Longitud(double d, String sigla) {
		this.equivalencia = d;
		this.siglas = sigla;
	}

	public double getEquivalencia() {
		return equivalencia;
	}

	public String getSiglas() {
		return siglas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getSiglas();
	}
}
