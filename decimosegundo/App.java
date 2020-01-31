package decimosegundo;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		getUsers();
		getAlbums(5);
		getAlbum(77);
		getFotos("ipsam do");
	}
	
	private static void getUsers() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("users");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response respuestaPublicaciones = invocationBuilder.get();
		List<Usuario> listaUsers = respuestaPublicaciones.readEntity(new GenericType<List<Usuario>>() {});
		listaUsers.forEach(System.out::println);
	}
	
	private static void getAlbums(int idUsuario) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("albums");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response respuestaPublicaciones = invocationBuilder.get();
		List<Album> listaAlbums = respuestaPublicaciones.readEntity(new GenericType<List<Album>>() {});
		listaAlbums.stream().filter(n -> n.getUserId() == idUsuario).forEach(System.out::println);
	}
	
	private static void getAlbum(int num) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("albums/" + num);
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response respuestaPublicaciones = invocationBuilder.get();
		Album album = respuestaPublicaciones.readEntity(new GenericType<Album>() {});
		System.out.println(album);
	}
	
	private static void getFotos(String palabra) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("photos");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response respuestaPublicaciones = invocationBuilder.get();
		List<Foto> listaFotos = respuestaPublicaciones.readEntity(new GenericType<List<Foto>>() {});
		listaFotos.stream().filter(n -> n.getTitle().contains(palabra)).sorted((a,b) -> a.getTitle().compareTo(b.getTitle()))
		.map(n -> n.getTitle()).forEach(System.out::println);;
	}
	
}
