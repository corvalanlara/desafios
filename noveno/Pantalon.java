package noveno;

public class Pantalon extends Articulo{

	String color;
	int bolsillos;
	public Pantalon(String nombre, int precio, int codigo, int talla, String marca, String color, int bolsillos) {
		super(nombre, precio, codigo, talla, marca);
		this.color = color;
		this.bolsillos = bolsillos;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Pantalon [color=" + color + ", bolsillos=" + bolsillos + ", nombre=" + nombre + ", precio=" + precio
				+ ", codigo=" + codigo + ", talla=" + talla + ", marca=" + marca + "]";
	}
	

}
