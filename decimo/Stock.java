package decimo;

import java.util.ArrayList;
import java.util.Iterator;

public class Stock implements Iterable<Recurso> {
	
	private ArrayList<Recurso> listaRecursos;
    private static Stock stock;

	private Stock(ArrayList<Recurso> listaRecursos) {
		this.listaRecursos = listaRecursos;
	};
	
    public static Stock obtenerSingleton(ArrayList<Recurso> lista) {
        if (stock == null){
            stock = new Stock(lista);
        } else {
            System.out.println("No se puede crear el objeto porque ya existe un objeto de la clase Stock");
        }
        
        return stock;
    }

	@Override
	public Iterator<Recurso> iterator() {
		Iterator<Recurso> itera = listaRecursos.iterator();
        return itera; 
	}
}
