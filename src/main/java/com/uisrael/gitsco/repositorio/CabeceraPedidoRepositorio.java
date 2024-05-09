package com.uisrael.gitsco.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.gitsco.modelo.CabeceraPedido;


@Repository
public interface CabeceraPedidoRepositorio extends JpaRepository<CabeceraPedido, Integer> {

	@Query("Select c from CabeceraPedido c")
	public List<CabeceraPedido> listarPedido();
	
	@Query("select c from CabeceraPedido c where c.idPedidos = ?1")
	public CabeceraPedido buscarPedidosId(int idPedidos);
	
}
