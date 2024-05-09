package com.uisrael.gitsco.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.gitsco.modelo.Producto;
import com.uisrael.gitsco.repositorio.ProductoRepositorio;
import com.uisrael.gitsco.servicio.ProductoServicio;

@Service
@Component
public class ProductoServicioImpl implements ProductoServicio{

	@Autowired
	private ProductoRepositorio repo;
	
	@Override
	public void crearProducto(Producto nuevoProducto) {
		
		repo.save(nuevoProducto);
	}

	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return repo.listarProductos() ;
	}

	
	@Override
	public Producto buscarProductosId(int idProductos) {
		// TODO Auto-generated method stub
		return repo.findById(idProductos).get();
	}

	@Override
	public List<Producto> listarProductoPrecio(Double precio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> ListarProductosPrecio(Double precio, boolean Estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProductosCategoria(int idCategoria, String nombreCatergoria) {
		// TODO Auto-generated method stub
		return repo.listarProductosCategoria(idCategoria, nombreCatergoria);
	}

	@Override
	public void eliminarProducto(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
