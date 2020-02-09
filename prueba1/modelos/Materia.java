package modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	MateriaEnum nombre;
	List<Double> notas = new ArrayList<>();
	
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
        
        public List<Double> getNotas() {
                return notas;
        }
        
        public double getPromedio() {
            if(!getNotas().isEmpty())
                return Math.round(getNotas().stream().mapToDouble(n -> n).average().getAsDouble() * 10) / 10.0;
            return -1;
        }

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
	}
	
	
}
