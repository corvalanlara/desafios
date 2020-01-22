package septimo;

public class EntradaVIP extends Entrada {
	boolean regalo;
	
	public EntradaVIP(int precio, int numeroAsiento, Cliente cliente, Vendedor vendedor, boolean regalo) {
		super(precio, numeroAsiento, cliente, vendedor);
		this.regalo = regalo;
	}
	
}
