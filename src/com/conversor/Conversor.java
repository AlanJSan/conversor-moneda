package com.conversor;

public abstract class Conversor<T extends Enum<T>>{	
	public abstract String convertir(String valorOrigen, String valorDestino, double cantidad);
	public abstract T[] getValues();
}
