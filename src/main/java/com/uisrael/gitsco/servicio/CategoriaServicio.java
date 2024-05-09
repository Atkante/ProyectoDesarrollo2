package com.uisrael.gitsco.servicio;

import java.util.List;

import com.uisrael.gitsco.modelo.Categoria;

public interface CategoriaServicio {

	public void insertarCategoria(Categoria nuevaCategoria);

	public List<Categoria> listarCategoria();

	public Categoria buscarCatrgoriaId(int idCategoria);

	public List<Categoria> findByNombreCatergoria(String nombreCatergoria);

	public List<Categoria> findByEstado(boolean estado);
	
	public Categoria findByidCategoria(int id);
	
	public void eliminarCategoria(int id);
}
