package com.conversor;

public enum Moneda {
	USD(1.0, "Dolar Estadounidense", "$"), 
	MXN(16.90, "Peso Mexicano", "$"), 
	EUR(0.90, "Euro", "€"), 
	GBP(0.046, "Libra Esterlina", "£"), 
	JPY(0.046, "Yen Japonés", "¥"), 
	KRW(0.046, "Won Surcoreano", "₩");
	
	private final double equivalencia;
	private final String nombreMoneda;
	private final String simbolo;

	Moneda(double equivalencia, String nombreMoneda, String simbolo) {
		// TODO Auto-generated constructor stub
		this.equivalencia = equivalencia;
		this.nombreMoneda = nombreMoneda;
		this.simbolo = simbolo;
	}

	public double getEquivalencia() {
		return this.equivalencia;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public String getSimbolo() {
		return simbolo;
	}
	
	@Override
	public String toString() {
		return this.name() + " - " + this.getNombreMoneda();
	}

}
