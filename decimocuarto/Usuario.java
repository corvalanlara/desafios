package decimocuarto;

/**
 * 
 */
public class Usuario {

    /**
     * 
     */
    protected String nombre;

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    protected String correo;

    /**
     * 
     */
    protected boolean esAdmin;

    /**
     * 
     */
    protected String password;

	public Usuario(String nombre, int id, String correo, boolean esAdmin, String password) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.correo = correo;
		this.esAdmin = esAdmin;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    

}