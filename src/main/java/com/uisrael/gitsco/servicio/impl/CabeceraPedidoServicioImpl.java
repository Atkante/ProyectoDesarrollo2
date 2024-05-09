package com.uisrael.gitsco.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.gitsco.modelo.CabeceraPedido;
import com.uisrael.gitsco.repositorio.CabeceraPedidoRepositorio;
import com.uisrael.gitsco.servicio.CabeceraPedidoServicio;

@Component
@Service
public class CabeceraPedidoServicioImpl implements CabeceraPedidoServicio {

	@Autowired
	private CabeceraPedidoRepositorio repoPedido;
	@Override
	public void crearCabeceraPedido(CabeceraPedido nuevoCabeceraPedido) {
		
		repoPedido.save(nuevoCabeceraPedido);
		
	}

	@Override
	public List<CabeceraPedido> listarPedido() {
	
		return repoPedido.listarPedido();
	}

	@Override
	public CabeceraPedido buscarPedidosId(int idPedidos) {
		
		return repoPedido.buscarPedidosId(idPedidos);
	}

	@Override
	public void eliminarPedido(int idPedidos) {
		
		repoPedido.deleteById(idPedidos);
	}

}
