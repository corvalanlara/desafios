package septimo;

public class Entrada {
	private int precio;
	private int numeroAsiento;
	private Cliente cliente;
	private Vendedor vendedor;
	
	public Entrada(int precio, int numeroAsiento, Cliente cliente, Vendedor vendedor) {
		this.precio = precio;
		this.numeroAsiento = numeroAsiento;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}
	
	
	
	@Override
	public String toString() {
		return "Entrada [numeroAsiento=" + numeroAsiento + ", cliente=" + cliente + "]";
	}



	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getNumeroAsiento() {
		return numeroAsiento;
	}

	public void setNumeroAsiento(int numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
