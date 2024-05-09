package com.uisrael.gitsco.servicio;

import java.util.List;


import com.uisrael.gitsco.modelo.CabeceraPedido;

public interface CabeceraPedidoServicio {

	public void crearCabeceraPedido(CabeceraPedido nuevoCabeceraPedido);
	
	public List<CabeceraPedido> listarPedido();
	
	public CabeceraPedido buscarPedidosId(int idPedidos);
	
	public void eliminarPedido(int idPedidos);
}
