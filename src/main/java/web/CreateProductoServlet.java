package web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import dao.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Producto;

@WebServlet("/Producto/nuevo")
@MultipartConfig // Necesario para procesar la imagen
public class CreateProductoServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("formularioCrear.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String precioStr = request.getParameter("precio");
        String categoriaStr = request.getParameter("categoria");
        double precio = Double.parseDouble(precioStr);
        int categoria = Integer.parseInt(categoriaStr);
        
        // Obtener la imagen
        Part archivo = request.getPart("imagen");
        String nombreArchivo = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();
        
        // Ruta donde se guardarán las imágenes en el servidor
        String rutaCarpetaImagenes = request.getServletContext().getRealPath("/img");
        File rutaDirectorioImagenes = new File(rutaCarpetaImagenes);
        
        if (!rutaDirectorioImagenes.exists()) {
            rutaDirectorioImagenes.mkdir();
        }

        // Guardar el archivo físicamente en la carpeta
        archivo.write(rutaCarpetaImagenes + File.separator + nombreArchivo);

        // Crear objeto Producto (el nombre del archivo se guarda en la BD)
        Producto producto = new Producto(0, nombre, categoria, "", precio, nombreArchivo); 

        // Insertar en la base de datos
        ProductoDAO productoDao = new ProductoDAO();
        productoDao.insertar(producto);

        response.sendRedirect(request.getContextPath() + "/Admin/Panel");
    }
}