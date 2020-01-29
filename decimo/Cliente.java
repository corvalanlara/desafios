package decimo;

import java.util.ArrayList;

public class Cliente {
	String nombre;
	String rut;
	String password;
	ArrayList<Recurso> prestados = new ArrayList<Recurso>();
	
	public Cliente(String nombre, String rut, String password) {
		super();
		this.nombre = nombre;
		this.rut = rut;
		this.password = password;
	}
	
	public void addPrestado(Recurso recurso) {
		this.prestados.add(recurso);
	}
	
}
