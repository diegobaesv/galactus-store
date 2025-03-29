package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public CarritoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/carrito.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idProducto = Integer.parseInt(request.getParameter("idProducto"));
		System.out.println("Se esta agregando un elemento al carrito: "+idProducto);
		
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println("cookie: "+cookie.getName()+ " - " + cookie.getValue());
		}
		
		response.getWriter().append("OK");
		
	}

}
