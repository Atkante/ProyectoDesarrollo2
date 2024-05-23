package com.uisrael.gitsco.modelo;

import java.io.Serializable;
import java.util.Date;

import com.uisrael.gitsco.modelo.Cliente;

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
public class CabeceraPedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedidos;
	@Temporal(TemporalType.DATE)
	private Date fechaPedidos;
	
	@ManyToOne
	@JoinColumn(name = "fkClientes")
	private Cliente fkClientes;
	
	@ManyToOne
	@JoinColumn(name = "fkUsuarios")
	private Usuarios fkUsuarios;
	
	
}
