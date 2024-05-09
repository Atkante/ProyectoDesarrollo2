package com.uisrael.gitsco.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.gitsco.modelo.Usuarios;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios, Integer> {

	@Query("Select u from Usuarios u")
	public List<Usuarios> listarUsuarios();
	
	@Query("select u from Usuarios u where u.idUsuario = ?1")
	public Usuarios buscarUsuariosId(int idUsuario);
}
