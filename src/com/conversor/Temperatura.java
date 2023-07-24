package com.conversor;

public enum Temperatura {
	C,K,F;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "°" + this.name();
	}
	
}
