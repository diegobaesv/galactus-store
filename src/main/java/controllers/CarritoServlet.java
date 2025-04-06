package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Venta;
import models.VentaDetalle;
import services.impl.VentaDetalleServiceImpl;
import services.impl.VentaServiceImpl;
import shared.Util;


@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VentaServiceImpl ventaServiceImpl;
	private VentaDetalleServiceImpl ventaDetalleServiceImpl;
       
	public CarritoServlet() {
        super();
        ventaServiceImpl = new VentaServiceImpl();
        ventaDetalleServiceImpl = new VentaDetalleServiceImpl();
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
				
		String sessionId = Util.getCookieValue(request.getCookies(), "JSESSIONID");
		
		Venta venta = ventaServiceImpl.obtenerVentaPorCodigoInterno(sessionId);
		if(venta==null) {
			Venta newVenta = new Venta();
			newVenta.setCodigoInterno(sessionId);
			venta = ventaServiceImpl.insertarVenta(newVenta);
		}
		
		System.out.println("Ventaid::"+venta.getIdVenta());
		
		VentaDetalle ventaDetalle = ventaDetalleServiceImpl.obtenerVentaDetallePorIdVentaYIdProducto(venta.getIdVenta(), idProducto); 
		if(ventaDetalle == null) {
			VentaDetalle newVentaDetalle = new VentaDetalle();
			newVentaDetalle.setIdVenta(venta.getIdVenta());
			newVentaDetalle.setIdProducto(idProducto);
			ventaDetalle = ventaDetalleServiceImpl.insertarVentaDetalle(newVentaDetalle);
		} else {
			ventaDetalleServiceImpl.aumentarVentaDetalleCantidad(ventaDetalle.getIdVentaDetalle());
		}
		
		System.out.println("VentaDetalleId::"+ventaDetalle.getIdVentaDetalle());
		
		
		/*
		 - capturar en un Sring el cookie de JSESSIONID con clase Util que recibe parametro Cookies[]
		 - buscar en la tabla ventas si ya existe ese cookie como codigoInterno
		 - si no existe, creo el reigstro en la tabla ventas
		 - agrego el producto, a la tabla venta_detalle ( pendiente conteo de cantidad )	 
		 * */
		
		response.getWriter().append("OK");
		
	}

}
