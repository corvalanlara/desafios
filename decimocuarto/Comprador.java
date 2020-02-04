package decimocuarto;

/**
 * 
 */
public class Comprador extends Usuario {



    public Comprador(String nombre, int id, String correo, boolean esAdmin, String password) {
		super(nombre, id, correo, esAdmin, password);
		// TODO Auto-generated constructor stub
	}

	/**
     * @param producto 
     * @return
     */
    public boolean realizarTransaccion(Producto producto) {
        // TODO implement here
        return true;
    }

}