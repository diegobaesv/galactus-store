package services;

import models.VentaDetalle;

public interface VentaDetalleService {
	VentaDetalle obtenerVentaDetallePorIdVentaYIdProducto(Integer idVenta, Integer idProducto);
	VentaDetalle insertarVentaDetalle(VentaDetalle ventaDetalle);
	void aumentarVentaDetalleCantidad(Integer idVentaDetalle);
}
