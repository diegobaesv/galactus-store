package models;

import java.sql.Date;

public class Venta {
	private Integer idVenta;
	private String codigoInterno;
	private String codigoBoleta;
	private Integer idUsuarioComprador;
	private Integer idUsuarioVendedor;
	private String estadoVenta;
	private String metodoPago;
	private Float montoTotal;
	private Date fechaCreacion;
	
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public String getCodigoInterno() {
		return codigoInterno;
	}
	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
	public String getCodigoBoleta() {
		return codigoBoleta;
	}
	public void setCodigoBoleta(String codigoBoleta) {
		this.codigoBoleta = codigoBoleta;
	}
	public Integer getIdUsuarioComprador() {
		return idUsuarioComprador;
	}
	public void setIdUsuarioComprador(Integer idUsuarioComprador) {
		this.idUsuarioComprador = idUsuarioComprador;
	}
	public Integer getIdUsuarioVendedor() {
		return idUsuarioVendedor;
	}
	public void setIdUsuarioVendedor(Integer idUsuarioVendedor) {
		this.idUsuarioVendedor = idUsuarioVendedor;
	}
	public String getEstadoVenta() {
		return estadoVenta;
	}
	public void setEstadoVenta(String estadoVenta) {
		this.estadoVenta = estadoVenta;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public Float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
}
