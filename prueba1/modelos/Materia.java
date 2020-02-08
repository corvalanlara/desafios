package modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	MateriaEnum nombre;
	List<Double> notas = new ArrayList<Double>();
	
	public Materia(MateriaEnum nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void addNota(double nota) {
		this.notas.add(nota);
	}
        
        public String getNombre() {
                return nombre.toString();
        }
        
        public MateriaEnum getEnum() {
                return nombre;
        }

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
	}
	
	
}
