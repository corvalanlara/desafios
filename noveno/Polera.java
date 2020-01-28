package noveno;

public class Polera extends Articulo {

	String color;
	
	public Polera(String nombre, int precio, int codigo, int talla, String marca, String color) {
		super(nombre, precio, codigo, talla, marca);
		this.color = color;
	}

	@Override
	public String toString() {
		return "Polera [color=" + color + ", nombre=" + nombre + ", precio=" + precio + ", codigo=" + codigo
				+ ", talla=" + talla + ", marca=" + marca + "]";
	}
}
