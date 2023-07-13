package conversor;

public class Main {
	
	public static void main(String[] args) {
		ConversorMoneda ob = new ConversorMoneda();
		System.out.println(ob.convertir(Moneda.MXN.toString(),Moneda.EUR.toString(),23));
		System.out.println(Moneda.MXN.getMoneda());
	}

}
