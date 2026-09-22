package web;

// Importamos IOException para posibles errores
import java.io.IOException;

// Importamos nuestro DAO
import dao.ProductoDAO;

// Librerías servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// URL que activará este servlet
// Cuando entres en /Producto/eliminar
@WebServlet("/Producto/actualizarPrecio")
public class UpdateProductoServlet extends HttpServlet {

    // Se ejecuta cuando entramos por URL (GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recogemos el id que viene en la URL
        // Ejemplo:
        // /Producto/eliminar?id=5
        String idTexto = request.getParameter("id");
        String idPrecio = request.getParameter("precio");

        // Convertimos texto a número entero
        int id = Integer.parseInt(idTexto);
        double nuevoPrecio = Double.parseDouble(idPrecio);

        // Creamos objeto DAO
        ProductoDAO dao = new ProductoDAO();

        // Llamamos al método eliminar de la BD
        dao.actualizarPrecio(nuevoPrecio, id);

        // Cuando termina, volvemos al panel admin
        response.sendRedirect(request.getContextPath() + "/Admin/Panel");
    }
}