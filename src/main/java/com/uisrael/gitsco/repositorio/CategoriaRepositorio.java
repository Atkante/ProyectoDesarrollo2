package com.uisrael.gitsco.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.gitsco.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

	public List<Categoria> findByNombreCatergoria(String nombreCatergoria);
	
	public List<Categoria> findByEstado(boolean estado);
	
	public Categoria findByidCategoria(int id);
	
	@Query("Select c from Categoria c")
	public List<Categoria> listarCategorias();
	
	
}
