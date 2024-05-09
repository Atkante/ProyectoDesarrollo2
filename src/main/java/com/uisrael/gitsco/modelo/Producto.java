package com.uisrael.gitsco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProductos;
	private String nombre;
	private Double precio;
	private String descripcion;
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	private boolean estado;
	
	@OneToMany(mappedBy = "fkProducto")
	private List<CabeceraPedido> listapedidos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "fkCategoria")
	private Categoria fkCategoria;
}