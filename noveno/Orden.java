package noveno;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Orden {
	String direccion;
	String nombre;
	ArrayList<Articulo> lista = new ArrayList<Articulo>();
	int monto;
	LocalDateTime fecha;
	
	public Orden(String direccion, String nombre, ArrayList<Articulo> lista, int monto, LocalDateTime fecha) {
		super();
		this.direccion = direccion;
		this.nombre = nombre;
		this.lista = lista;
		this.monto = monto;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Orden [direccion=" + direccion + ", nombre=" + nombre + ", lista=" + lista + ", monto=" + monto
				+ ", fecha=" + fecha + "]";
	}
	
	
}
