package conversor;

public enum Moneda {
	USD(1.0), MXN(16.90), EUR(0.90), GBP(0.046), JPY(0.046), KRW(0.046);
	
	private final double moneda;

	Moneda(double d) {
		// TODO Auto-generated constructor stub
		this.moneda = d;
	}

	public double getMoneda() {
		return this.moneda;
	}
}
