package decimosegundo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        getTwo(1, 2);
        getAlbumTitles(1);
        getAlbumTitles(2);
        getAlbumTitles(3);
	}
	
	private static void getUsers() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("users");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response respuestaPublicaciones = invocationBuilder.get();
        List<Usuario> listaUsers = respuestaPublicaciones.readEntity(new GenericType<List<Usuario>>() {});
        listaUsers.forEach(System.out::println);
	}

    /**
     * 
     * @param idUsuario if 0 returns all albums, else all albums corresponding to a user
     * @return list of albums
     */
	private static List<Album> getAlbumsFiltered(int idUsuario) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://jsonplaceholder.typicode.com")
                .path("albums");
        Invocation.Builder invocationBuilder = target
                .request(MediaType.APPLICATION_JSON);
        Response respuestaPublicaciones = invocationBuilder.get();
        List<Album> listaAlbums = respuestaPublicaciones.readEntity(new GenericType<List<Album>>() {});
        if (idUsuario != 0) {
            List<Album> seleccionados = listaAlbums.stream().filter(n -> n.getUserId() == idUsuario)
                .collect(Collectors.toList());
            return seleccionados;
        } else {
            return listaAlbums;
        }
	}
        
    private static void getAlbums(int id) {
        List<Album> lista = getAlbumsFiltered(id);
        lista.forEach(System.out::println);
    }

	private static void getAlbum(int num) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .target("https://jsonplaceholder.typicode.com")
                .path("albums")
                .path(String.valueOf(num));
        Invocation.Builder invocationBuilder = target
                .request(MediaType.APPLICATION_JSON);
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
        .map(n -> n.getTitle()).forEach(System.out::println);
	}
        
    private static Usuario getUser(int user) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .target("https://jsonplaceholder.typicode.com")
                .path("users")
                .path(String.valueOf(user));
        Invocation.Builder invocationBuilder = target
                .request(MediaType.APPLICATION_JSON);
        Response respuesta = invocationBuilder.get();
        Usuario usuario = respuesta.readEntity(new GenericType<Usuario>() {});
        return usuario;
    }
        
    private static void getTwo(int user1, int user2) {
        Map<Usuario, List<Album>> mapa = new HashMap<Usuario, List<Album>>();
        mapa.putAll(getOne(user1));
        mapa.putAll(getOne(user2));
        Set<Usuario> lista = mapa.keySet();
        for(Usuario user: lista) {
            for(List<Album> albumes: mapa.values()) {
                for(Album album: albumes) {
                    System.out.printf("id usuario: %s - nombre usuario: %s | album %s album %s\n", user.getId(), user.getName(), album.getId(), album.getTitle());
                }
            }
        }

    }
        
    private static void getAlbumTitles(int user) {
        Map<Usuario, List<Album>> mapa = getOne(user);
        Usuario usuario = (Usuario) mapa.keySet().toArray()[0];
        List<Album> albumes = mapa.get(usuario);
        List<String> lista =  albumes.stream().map(n -> n.getTitle()).collect(Collectors.toList());
        System.out.printf("album: %s - titulos %s\n", usuario.getId(), lista.toString());
    }
    
    private static Map<Usuario, List<Album>> getOne(int user) {
        Usuario usuario = getUser(user);
        List<Album> todosAlbumes = getAlbumsFiltered(user);
        List<Album> albumes = todosAlbumes.stream()
                .filter(n -> n.getUserId() == user)
                .collect(Collectors.toList());
        Map<Usuario, List<Album>> mapa = new HashMap<Usuario, List<Album>>();
        mapa.put(usuario, albumes);
        return mapa;
    }
}
