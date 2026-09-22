package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import utils.ConexionMariaDB;

public class ProductoDAO {

	    public List<Producto> listarComida() {

	        List<Producto> listaProductos = new ArrayList<>();

	        // Consulta para recuperar todos los usuarios de la tabla "Producto".
	        //String sql = "SELECT id_prod, nombre, categoria, descripcion, precio FROM Producto";
	        String sql1 = "SELECT id_prod, nombre, categoria, descripcion, precio, imagen FROM Producto WHERE categoria = 1";
	        // Este sql te saca una tabla sólo de las comidas

	        // Se llama a getConexion() para recuperar la conexión a la
	        // base de datos para poder ejecutar la consulta que recupera
	        // los usuarios.
	        try (Connection con = ConexionMariaDB.getConexion();
	             PreparedStatement ps = con.prepareStatement(sql1);
	             // Guardo los productos recuperados de la base de datos
	             // en una variable de tipo ResultSet (productosRecuperados).
	             ResultSet ProductosRecuperados = ps.executeQuery()) {

	            while (ProductosRecuperados.next()) {

	                // Se añade cada usuario recuperado a "listaProductos".
	                listaProductos.add(
	                        new Producto(
	                        		ProductosRecuperados.getInt("id_prod"),
	                        		ProductosRecuperados.getString("nombre"),
	                        		ProductosRecuperados.getInt("categoria"),
	                        		ProductosRecuperados.getString("descripcion"),
	                        		ProductosRecuperados.getDouble("precio"),
	                        		ProductosRecuperados.getString("imagen")
	                        )
	                );
	            }
	            System.out.println(listaProductos);
	            System.out.println(listaProductos);
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return listaProductos;
	    }
	    
	    public List<Producto> listarBebida() {

	        List<Producto> listaProductos = new ArrayList<>();

	        // Consulta para recuperar todos los usuarios de la tabla "Producto".
	        //String sql = "SELECT id_prod, nombre, categoria, descripcion, precio FROM Producto";
	        String sql2 = "SELECT id_prod, nombre, categoria, descripcion, precio, imagen FROM Producto WHERE categoria = 2";
	        // Este sql te saca una tabla sólo de las comidas

	        // Se llama a getConexion() para recuperar la conexión a la
	        // base de datos para poder ejecutar la consulta que recupera
	        // los usuarios.
	        try (Connection con = ConexionMariaDB.getConexion();
	             PreparedStatement ps = con.prepareStatement(sql2);
	             // Guardo los productos recuperados de la base de datos
	             // en una variable de tipo ResultSet (productosRecuperados).
	             ResultSet ProductosRecuperados = ps.executeQuery()) {

	            while (ProductosRecuperados.next()) {

	                // Se añade cada usuario recuperado a "listaProductos".
	                listaProductos.add(
	                        new Producto(
	                        		ProductosRecuperados.getInt("id_prod"),
	                        		ProductosRecuperados.getString("nombre"),
	                        		ProductosRecuperados.getInt("categoria"),
	                        		ProductosRecuperados.getString("descripcion"),
	                        		ProductosRecuperados.getDouble("precio"),
	                        		ProductosRecuperados.getString("imagen")
	                        )
	                );
	            }
	            System.out.println(listaProductos);
	            System.out.println(listaProductos);
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return listaProductos;
	    }
	    
	    //mostrar todos los productos (administrador) 
	    
	    public List<Producto> listarTodoElPanel() {
	        List<Producto> listaCompleta = new ArrayList<>();
	        // SQL sin filtros para el Admin
	        String sql = "SELECT id_prod, nombre, categoria, descripcion, precio, imagen FROM Producto";

	        try (Connection con = ConexionMariaDB.getConexion();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                listaCompleta.add(new Producto(
	                    rs.getInt("id_prod"),
	                    rs.getString("nombre"),
	                    rs.getInt("categoria"),
	                    rs.getString("descripcion"),
	                    rs.getDouble("precio"),
	                    rs.getString("imagen")
	                ));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return listaCompleta;
	    }
	    
	 // --- NUEVO MÉTODO: INSERTAR COMIDA --
	    
	    public void insertar(Producto p) {
	        // Consulta SQL para insertar los datos
	        String sql = "INSERT INTO Producto (nombre, categoria, precio, imagen, descripcion) VALUES (?, ?, ?, ?, ?)";
	        
	      
	        	   try (Connection con = ConexionMariaDB.getConexion();
	      	             PreparedStatement ps = con.prepareStatement(sql)) {
	      	            
	      	            // Sustituimos los "?" por los datos reales del objeto Producto
	      	            ps.setString(1, p.getNombre());
	      	            ps.setInt(2, p.getCategoria());
	      	            ps.setDouble(3, p.getPrecio());
	      	            ps.setString(4, p.getImagen());
	      	            ps.setString(5, p.getDescripcion());
	      	            
	      	            // Ejecutamos la inserción en la base de datos
	      	            ps.executeUpdate();
	      	            
	      	        } catch (Exception e) {
	      	            e.printStackTrace();
	      	        }
	      	    
	        }
	    public void eliminar(int id) {

	        // Consulta SQL para borrar un producto según su id
	        String sql = "DELETE FROM Producto WHERE id_prod = ?";

	        // Abrimos conexión con la base de datos
	        // Preparamos la consulta SQL
	        try (Connection con = ConexionMariaDB.getConexion();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            // Sustituimos el primer ? por el valor de id
	            // Si id = 5, quedaría:
	            // DELETE FROM Producto WHERE id_prod = 5
	            ps.setInt(1, id);

	            // Ejecutamos la consulta DELETE en la base de datos
	            ps.executeUpdate();

	            // executeUpdate se usa para:
	            // INSERT
	            // UPDATE
	            // DELETE

	        } catch (Exception e) {

	            // Si hay error lo mostramos en consola
	            e.printStackTrace();
	        }
	    }
	     
	    
	    public void actualizarPrecio(double nuevoPrecio, int id) {

	        // Consulta SQL para borrar un producto según su id
	        String sql = "UPDATE Producto SET precio = ? WHERE id_prod = ?";

	        // Abrimos conexión con la base de datos
	        // Preparamos la consulta SQL
	        try (Connection con = ConexionMariaDB.getConexion();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	        	// El primer '?' corresponde al nuevo precio
	            ps.setDouble(1, nuevoPrecio);
	        	
	            // Sustituimos el primer ? por el valor de id
	            // Si id = 5, quedaría:
	            // DELETE FROM Producto WHERE id_prod = 5
	            ps.setInt(2, id);

	            int filasAfectadas = ps.executeUpdate();
	            
	            //Para ver en el Eclipse que funciona
	            if (filasAfectadas > 0) {
	                System.out.println("¡Precio actualizado con éxito!");
	            } else {
	                System.out.println("No se encontró ningún producto con ID: " + id);
	            }

	        } catch (Exception e) {

	            // Si hay error lo mostramos en consola
	            e.printStackTrace();
	        }
	    }
	    
}
	     

