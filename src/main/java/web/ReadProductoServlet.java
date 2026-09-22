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



@WebServlet("/Producto")
public class ReadProductoServlet extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    
            throws ServletException, IOException {
            
        ProductoDAO dao = new ProductoDAO();
        
        List<Producto> lista = dao.listarComida();
        List<Producto> listab = dao.listarBebida();
        
        System.out.println("COMIDAS: " + lista.size());
        System.out.println("BEBIDAS: " + listab.size());
        

        request.setAttribute("misProductos", lista);
        request.setAttribute("misBebidas", listab);
        
        
        
        request.getRequestDispatcher("lista.jsp").forward(request, response);
    }
}