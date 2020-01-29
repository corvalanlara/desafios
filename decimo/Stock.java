package decimo;

import java.util.ArrayList;
import java.util.Iterator;

public class Stock implements Iterable<Recurso> {
	
	private ArrayList<Recurso> listaRecursos;
    private static Stock stock;

	private Stock(ArrayList<Recurso> listaRecursos) {
		this.listaRecursos = listaRecursos;
	};
	
    public static synchronized Stock obtenerSingleton(ArrayList<Recurso> lista) {
        if (stock == null){
            stock = new Stock(lista);
        }
        
        return stock;
    }

	@Override
	public Iterator<Recurso> iterator() {
		Iterator<Recurso> itera = listaRecursos.iterator();
        return itera; 
	}

	@Override
	public String toString() {
		return "Stock [listaRecursos=" + listaRecursos + "]";
	}
}
