package septimo;

public class Entrada {
	int precio;
	int numeroAsiento;
	Cliente cliente;
	Vendedor vendedor;
	
	public Entrada(int precio, int numeroAsiento, Cliente cliente, Vendedor vendedor) {
		this.precio = precio;
		this.numeroAsiento = numeroAsiento;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}
}
