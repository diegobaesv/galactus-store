package services.impl;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.VentaDetalleMapper;
import models.VentaDetalle;
import services.VentaDetalleService;

public class VentaDetalleServiceImpl implements VentaDetalleService {
	
	

	@Override
	public VentaDetalle obtenerVentaDetallePorIdVentaYIdProducto(Integer idVenta, Integer idProducto) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			VentaDetalleMapper ventaDetalleMapper = session.getMapper(VentaDetalleMapper.class);
			return ventaDetalleMapper.obtenerVentaDetallePorIdVentaYIdProducto(idVenta, idProducto);
		} catch (Exception e) {
			System.out.println("obtenerVentaDetallePorIdVentaYIdProducto::"+e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public VentaDetalle insertarVentaDetalle(VentaDetalle ventaDetalle) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			VentaDetalleMapper ventaDetalleMapper = session.getMapper(VentaDetalleMapper.class);
			ventaDetalleMapper.insertarVentaDetalle(ventaDetalle);
			session.commit();
			return ventaDetalle;
		} catch (Exception e) {
			System.out.println("insertarVentaDetalle::"+e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void aumentarVentaDetalleCantidad(Integer idVentaDetalle) {
		try {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			VentaDetalleMapper ventaDetalleMapper = session.getMapper(VentaDetalleMapper.class);
			ventaDetalleMapper.aumentarVentaDetalleCantidad(idVentaDetalle);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertarVentaDetalle::"+e);
			e.printStackTrace();
		}
	}

}
