package modelo;

public class Producto {
    private int id_prod, categoria;
    private String nombre, descripcion, imagen;
    private double precio;

    // Constructor vacío (necesario para muchos frameworks en el futuro)
    public Producto() {}

    // Constructor
	public Producto(int id_prod, String nombre, int categoria, String descripcion, double precio, String imagen) {
		super();
		this.id_prod = id_prod;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen=imagen;
	}

	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria  = categoria;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
    
}