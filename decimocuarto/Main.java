package decimocuarto;

public class Main {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria(1, "Vestimenta");
		Producto producto = new Producto(1, "Bufanda", "Bufanda roja marca Style", 50, 2, categoria);
		Comprador comprador = new Comprador("Daniel", 1, "corvalan@daniel.cl", false, "contra");
		boolean haSidoComprado = comprador.realizarTransaccion(producto);
		System.out.println(haSidoComprado);
	}

}
