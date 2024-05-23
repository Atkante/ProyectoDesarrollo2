package com.uisrael.gitsco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_categoria")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	@Column(name = "nombre_cate", length = 85)
	private String nombreCatergoria;
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	private boolean estado;
	
	@OneToMany(mappedBy = "fkCategoria")
	private List<Producto> listaProducto = new ArrayList<>();
	

}
