package web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReservaServlet")
public class ReservaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recoger datos del formulario
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String personas = request.getParameter("personas");
// Ruta donde se guardarán las reservas
	String ruta = System.getProperty("user.home")
        	+ File.separator + "ElOasis"
        	+ File.separator + "reservas.txt";
        File archivo = new File(ruta);
        archivo.getParentFile().mkdirs();
        archivo.createNewFile();

        

        // Escribir en modo añadir (append = true)
        FileWriter fw = new FileWriter(archivo, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Nombre: " + nombre);
        pw.println("Telefono: " + telefono);
        pw.println("Fecha: " + fecha);
        pw.println("Hora: " + hora);
        pw.println("Personas: " + personas);
        pw.println("---------------------------");

        pw.close();
        fw.close();

        // Volver a la página principal
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<script>");
        out.println("alert('Reserva enviada correctamente');");
        out.println("window.location='Producto';");
        out.println("</script>");
    }
}