package com.uisrael.gitsco.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.gitsco.modelo.DetallePedido;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer> {

	@Query("Select d from DetallePedido d")
	public List<DetallePedido> listarDetalles();
	
	@Query("select d from DetallePedido d where d.idDetalles = ?1")
	public DetallePedido buscarDetallePedidoId(int idDetalles);
}
