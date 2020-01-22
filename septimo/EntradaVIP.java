package septimo;

public class EntradaVIP extends Entrada {
	private boolean regalo;
	
	public EntradaVIP(int precio, int numeroAsiento, Cliente cliente, Vendedor vendedor, boolean regalo) {
		super(precio, numeroAsiento, cliente, vendedor);
		this.regalo = regalo;
	}

	public boolean isRegalo() {
		return regalo;
	}

	public void setRegalo(boolean regalo) {
		this.regalo = regalo;
	}
	
}
