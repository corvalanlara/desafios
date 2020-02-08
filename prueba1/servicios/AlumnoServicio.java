package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Alumno;
import modelos.Materia;

public class AlumnoServicio {

	Map<String, Alumno> listaAlumnos;
	
	private static AlumnoServicio alumnoServicio;
	
	public AlumnoServicio(Map<String, Alumno> listaAlumnos) {
		super();
		this.listaAlumnos = listaAlumnos;
	}

	void crearAlumno(Alumno alumno) {
		
	}
	
	void agregarMateria(String rutAlumno, Materia currentMate) {
		
	}
	
	List<Materia> materiasPorAlumno(String rutAlumno) {
		return new ArrayList<Materia>();
	}
	
	Map<String, Alumno> listarAlumnos() {
		return new HashMap<String, Alumno>();
	}
	
    public static synchronized AlumnoServicio obtenerSingleton(Map<String, Alumno> lista) {
        if (alumnoServicio == null){
            alumnoServicio = new AlumnoServicio(lista);
        }
        
        return alumnoServicio;
    }
    
    public static synchronized AlumnoServicio obtenerSingleton() {
    	return alumnoServicio;
    }

	@Override
	public String toString() {
		return "AlumnoServicio [listaAlumnos=" + listaAlumnos + "]";
	}

	public Map<String, Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	
	public void addListaAlumnos(String rut, Alumno alumno) {
		listaAlumnos.put(rut, alumno);
	}
        
        public void addListaAListaAlumnos(Map<String, Alumno> lista) {
                listaAlumnos.putAll(lista);
        }

}
