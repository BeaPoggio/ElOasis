package web;

import java.io.IOException;
import java.util.List;

import dao.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Producto;

@WebServlet("/Admin/Panel")
public class AdminServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Llamamos al nuevo método que trae TODO
        ProductoDAO dao = new ProductoDAO();
        List<Producto> todosLosProductos = dao.listarTodoElPanel();
        
        // 2. Guardamos la lista en el request
        request.setAttribute("productosAdmin", todosLosProductos);
        
        // 3. Mandamos al JSP del panel
        request.getRequestDispatcher("/Panel/panelControl.jsp").forward(request, response);
    }
}