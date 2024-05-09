package com.uisrael.gitsco.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.gitsco.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

	@Query("Select c from Cliente c")
	public List<Cliente> listarCliente();
	
	@Query("select c from Cliente c where c.idCliente = ?1")
	public Cliente buscarClientesId(int idCliente);
}
