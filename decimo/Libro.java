package decimo;

public class Libro extends Recurso {

	int paginas;
	String imprenta;
	
	public Libro(String nombre, boolean reservado, int codigo, int paginas, String imprenta) {
		super(nombre, reservado, codigo);
		this.paginas = paginas;
		this.imprenta = imprenta;
	}

	@Override
	public String toString() {
		return "Libro [paginas=" + paginas + ", imprenta=" + imprenta + ", nombre=" + nombre + ", reservado="
				+ reservado + ", codigo=" + codigo + "]";
	}


}
