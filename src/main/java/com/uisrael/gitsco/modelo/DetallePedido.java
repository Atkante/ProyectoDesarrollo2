package com.uisrael.gitsco.modelo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Entity
@Data
public class DetallePedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalles;
	@Temporal(TemporalType.DATE)
	private Date fechaDetallePedido;
	
	@ManyToOne
	@JoinColumn(name = "fkClientes")
	private Cliente fkClientes;
	
	@ManyToOne
	@JoinColumn(name = "fkUsuarios")
	private Usuarios fkUsuarios;
	
	@ManyToOne
	@JoinColumn(name = "fkCategoria")
	private Categoria fkCategoria;
	
	@ManyToOne
	@JoinColumn(name = "fkProducto")
	private Producto fkProducto;
	@ManyToOne
	@JoinColumn(name="fkPedido")
	private  CabeceraPedido fkPedido;
	
}
