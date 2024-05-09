package com.uisrael.gitsco.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.gitsco.modelo.Categoria;
import com.uisrael.gitsco.repositorio.CategoriaRepositorio;
import com.uisrael.gitsco.servicio.CategoriaServicio;

@Service
@Component
public class CategoriaServicioImpl implements CategoriaServicio {

	@Autowired
	private CategoriaRepositorio repositorio;

	@Override
	public void insertarCategoria(Categoria nuevaCategoria) {
		// TODO Auto-generated method stub
		try {
			repositorio.save(nuevaCategoria);
		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
		
	}

	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		return repositorio.listarCategorias();
		
	}

	@Override
	public Categoria buscarCatrgoriaId(int idCategoria) {
		// TODO Auto-generated method stub
		return repositorio.findByidCategoria(idCategoria);
	}

	@Override
	public List<Categoria> findByNombreCatergoria(String nombreCatergoria) {
		// TODO Auto-generated method stub
		return repositorio.findByNombreCatergoria(nombreCatergoria);
	}

	@Override
	public List<Categoria> findByEstado(boolean estado) {
		// TODO Auto-generated method stub
		return repositorio.findByEstado(estado);
	}

	@Override
	public Categoria findByidCategoria(int id) {
		// TODO Auto-generated method stub
		return repositorio.findByidCategoria(id);
	}

	@Override
	public void eliminarCategoria(int id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
