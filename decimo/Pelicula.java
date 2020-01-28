package decimo;

public class Pelicula extends Recurso {
	
	int duracion; // en segundos
	String calidad;
	
	public Pelicula(String nombre, boolean reservado, int codigo, int duracion, String calidad) {
		super(nombre, reservado, codigo);
		this.duracion = duracion;
		this.calidad = calidad;
	}

	@Override
	public String toString() {
		return "Pelicula [duracion=" + duracion + ", calidad=" + calidad + ", nombre=" + nombre + ", reservado="
				+ reservado + ", codigo=" + codigo + "]";
	}

}
