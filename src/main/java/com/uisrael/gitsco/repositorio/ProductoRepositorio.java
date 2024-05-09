package com.uisrael.gitsco.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uisrael.gitsco.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

	@Query("Select P from Producto P")
	public List<Producto> listarProductos();
	
	@Query("select p from Producto p where p.idProductos = ?1")
	public Producto buscarProductosId(int idProductos);
	
	@Query("SELECT p FROM Producto p WHERE p.fkCategoria.idCategoria = :idCategoria and p.fkCategoria.nombreCatergoria = :nombreCatergoria")
	public List<Producto> listarProductosCategoria(@Param("idCategoria") int idCategoria, @Param("nombreCatergoria") String nombreCatergoria);

	/*@Query("SELECT p FROM Producto p WHERE p.Precio = : ?1 and p.estado > :?2")
	public List<Producto> ListarProductosPrecio(Double precio,boolean Estado);
	
	@Query("SELECT p FROM Producto p WHERE p.Precio > :valor")
	public List<Producto> listarProductoPrecio(@Param("valor") Double precio);
	
	@Query("SELECT p fron Producto p WHERE p.fkCategoria.idCategoria =:id and p.fkCategoria =:fechaRegistro")
	public List<Producto> listarProductosCategoria(@Param("categoria")Categoria categoria,@Param("fechaRegistro") Categoria fechaRegistro);
	*/

}
