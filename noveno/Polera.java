package noveno;

public class Polera extends Articulo {

	String color;
	
	public Polera(String nombre, int precio, int codigo, int talla, String marca, String color) {
		super(nombre, precio, codigo, talla, marca);
		this.color = color;
	}
}
