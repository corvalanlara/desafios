package noveno;

public class Zapatos extends Articulo {

	String modelo;
	
	public Zapatos(String nombre, int precio, int codigo, int talla, String marca, String modelo) {
		super(nombre, precio, codigo, talla, marca);
		this.modelo = modelo;
		// TODO Auto-generated constructor stub
	}
}
