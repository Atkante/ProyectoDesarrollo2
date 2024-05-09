package com.uisrael.gitsco.servicio;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.uisrael.gitsco.modelo.Producto;

public interface ProductoServicio {

	public void crearProducto(Producto nuevoProducto);

	public List<Producto> listarProductos();

	public Producto buscarProductosId(int idProductos);

	public List<Producto> ListarProductosPrecio(Double precio, boolean Estado);
	
	public List<Producto> listarProductoPrecio(@Param("valor") Double precio);

	public List<Producto> listarProductosCategoria(@Param("idCategoria") int idCategoria, @Param("nombreCatergoria") String nombreCatergoria);


	public void eliminarProducto(int id);
}
