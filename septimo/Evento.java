package septimo;

import java.util.ArrayList;

public class Evento {
	private String nombre;
	private int edadMinima;
	private ArrayList<Entrada> listaEntradas = new ArrayList<Entrada>();;
	private ArrayList<EntradaVIP> listaEntradasVIP = new ArrayList<EntradaVIP>();
	private ArrayList<Entrada> listaEntradasUsadas = new ArrayList<Entrada>();
	private ArrayList<EntradaVIP> listaEntradasVIPUsadas = new ArrayList<EntradaVIP>();
	private boolean enCurso;
	
	public Evento(String nombre, int edadMinima) {
		this.nombre = nombre;
		this.edadMinima = edadMinima;
		this.listaEntradas = new ArrayList<Entrada>();
		this.listaEntradasVIP = new ArrayList<EntradaVIP>();
		this.enCurso = false;
		System.out.printf("Creando evento %s (Edad minima: %d)%n", this.nombre, this.edadMinima);
	}
	
	public boolean isEnCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		if (enCurso) {
			System.out.printf("El evento %s se ha cambiado: en curso%n", this.nombre);
		} else {
			System.out.printf("El evento %s se ha cambiado: no está en curso%n", this.nombre);
		}
		this.enCurso = enCurso;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdadMinima() {
		return edadMinima;
	}
	
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	
	public ArrayList<Entrada> getListaEntradas() {
		return listaEntradas;
	}
	
	public void addListaEntradas(Entrada entrada) {
		this.listaEntradas.add(entrada);
	}
	
	public ArrayList<EntradaVIP> getListaEntradasVIP() {
		return listaEntradasVIP;
	}
	
	public void addListaEntradasVIP(EntradaVIP entradaVIP) {
		this.listaEntradasVIP.add(entradaVIP);
	}
	
	public ArrayList<Entrada> getListaEntradasUsadas() {
		return listaEntradasUsadas;
	}
	
	public void addEntradaUsada(Entrada entrada) {
		this.listaEntradasUsadas.add(entrada);
	}
	
	public ArrayList<EntradaVIP> getListaEntradasVIPUsadas() {
		return listaEntradasVIPUsadas;
	}
	
	public void addEntradaVIPUsada(EntradaVIP entradaVIP) {
		this.listaEntradasVIPUsadas.add(entradaVIP);
	}
	
	public boolean entrarEvento(Cliente cliente) {
		for(Entrada entrada: cliente.getEntradasCompradas()) {
			if(this.getListaEntradas().contains(entrada) && !this.getListaEntradasUsadas().contains(entrada) && this.isEnCurso()) {
				this.addEntradaUsada(entrada);
				System.out.printf("Usando entrada con cliente %s (%s) para evento %s%nEntrada encontrada, %s puede pasar%n", cliente.getNombre(), cliente.getRut(), this.getNombre(), cliente.getNombre());
				return true;
			} else if(this.getListaEntradas().contains(entrada) && !this.getListaEntradasUsadas().contains(entrada) && !this.isEnCurso()) {
				System.out.printf("Usando entrada con cliente %s (%s) para evento %s%nNo se puede usar la entrada porque el evento %s no está en curso.%n", cliente.getNombre(), cliente.getRut(), this.getNombre(), this.getNombre());
				return false;
			} else if (this.getListaEntradas().contains(entrada) && this.getListaEntradasUsadas().contains(entrada) && this.isEnCurso()) {
				System.out.printf("Usando entrada con cliente %s (%s) para evento %s%nEntrada para rut %s ya fue usada, no puede pasar.%n", cliente.getNombre(), cliente.getRut(), this.getNombre(), cliente.getRut());
				return false;
			}
		}
		System.out.println("El cliente no tiene entrada para el evento");
		return false;
	}
	

}
