package decimocuarto;

/**
 * 
 */
public class Producto {

    public Producto(int id, String nombre, String descripcion, int cantidad, int status, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.status = status;
		this.categoria = categoria;
	}

	/**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String descripcion;

    /**
     * 
     */
    private int cantidad;

    /**
     * 
     */
    private int status;

    /**
     * 
     */
    private Categoria categoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
    

}