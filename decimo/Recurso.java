package decimo;

import java.util.ArrayList;

public abstract class Recurso {
	String nombre;
	boolean reservado;
	int codigo;
	Cliente prestadoA;
	
	public Recurso(String nombre, boolean reservado, int codigo, Cliente prestadoA) {
		super();
		this.nombre = nombre;
		this.reservado = reservado;
		this.codigo = codigo;
		this.prestadoA = prestadoA;
	}

	public void setPrestadoA(Cliente prestadoA) {
		this.prestadoA = prestadoA;
	}

	public static Recurso buscar(String texto) {
		Recurso recurso = null;
		Stock single = Stock.obtenerSingleton(null);
		texto = texto.trim().toLowerCase();
		for(Recurso item: single) {
			if(item.nombre.trim().toLowerCase().contentEquals(texto)) {
				recurso = item;
			}
		}
		return recurso;
	}
	
	public static Recurso buscarPorCodigo(int codigo) {
		Recurso recurso = null;
		Stock single = Stock.obtenerSingleton(null);
		for(Recurso item: single) {
			if(item.codigo == codigo) {
				recurso = item;
			}
		}
		return recurso;
	}
	
	public static boolean reservar(Recurso recurso, Cliente cliente) {
		
		if (recurso.reservado == true) {
			return false;
		} else {
			recurso.reservado = true;
			recurso.setPrestadoA(cliente);
			cliente.addPrestado(recurso);
			return true;
		}
		
	}
}
