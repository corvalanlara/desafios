package decimo;

import java.util.ArrayList;

public abstract class Recurso {
	String nombre;
	boolean reservado;
	int codigo;
	
	public Recurso(String nombre, boolean reservado, int codigo) {
		super();
		this.nombre = nombre;
		this.reservado = reservado;
		this.codigo = codigo;
	}

	public static Recurso buscar(String texto, Stock single) {
		Recurso recurso = null;
		for(Recurso item: single) {
			if(item.nombre == texto) {
				recurso = item;
			}
		}
		return recurso;
	}
	
	public void reservar(Recurso recurso) {
		
		
	}
}
