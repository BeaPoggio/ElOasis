package web;

import java.io.IOException;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.*;

@WebServlet("/Producto/login")

public class LoginServlet extends HttpServlet {

	// 🔹 Mostrar formulario

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		request.getRequestDispatcher("/Login/login.jsp").forward(request, response);

	}

	// 🔹 Procesar login

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String usuario = request.getParameter("usuario");

		String password = request.getParameter("password");
		
		String usuarioAdmin = System.getenv("OASIS_ADMIN_USER");
		String passwordAdmin = System.getenv("OASIS_ADMIN_PASSWORD");

		
    if (usuarioAdmin != null && passwordAdmin != null
            && usuarioAdmin.equalsIgnoreCase(usuario)
            && passwordAdmin.equals(password)) {

        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);
        response.sendRedirect(request.getContextPath() + "/Admin/Panel");
		
		

		} else {

			// Error → volver al login

			request.getRequestDispatcher("/Login/login.jsp").forward(request, response);

		}

	}

}