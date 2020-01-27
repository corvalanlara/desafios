package noveno;

public abstract class Articulo {
	String nombre;
	int precio;
	int codigo;
	int talla;
	String marca;
	
	public Articulo(String nombre, int precio, int codigo, int talla, String marca) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
		this.talla = talla;
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Articulo [precio=" + precio + ", codigo=" + codigo + "]";
	}
	
	
}
