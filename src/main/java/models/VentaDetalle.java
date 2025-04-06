package models;

import java.sql.Date;

public class VentaDetalle {
	private Integer idVentaDetalle;
	private Integer idVenta;
	private Integer idProducto;
	private Float precioUnitario;
	private Integer cantidad;
	private Date fechaCreacion;
	public Integer getIdVentaDetalle() {
		return idVentaDetalle;
	}
	public void setIdVentaDetalle(Integer idVentaDetalle) {
		this.idVentaDetalle = idVentaDetalle;
	}
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
}
