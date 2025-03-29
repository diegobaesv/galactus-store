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
		
		/*
		 - obtener todos los datos de venta detalle filtrado por cookie y mandarlos hacia la vista 
		 * */
		
		
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
		
		/*
		 - capturar en un Sring el cookie de JSESSIONID con clase Util que recibe parametro Cookies[]
		 - buscar en la tabla ventas si ya existe ese cookie como codigoInterno
		 - si no existe, creo el reigstro en la tabla ventas
		 - agrego el producto, a la tabla venta_detalle ( pendiente conteo de cantidad )	 
		 * */
		
		response.getWriter().append("OK");
		
	}

}
