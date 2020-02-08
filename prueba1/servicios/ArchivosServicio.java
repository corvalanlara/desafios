package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelos.Alumno;

public class ArchivosServicio {
	PromedioServicioImp promedioServicioImp;
	List<?> alumnosACargar;
	
	List<?> cargarDatos(String ruta) {
		return new ArrayList<Alumno>();
	}
	
	void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
		
	}
}
