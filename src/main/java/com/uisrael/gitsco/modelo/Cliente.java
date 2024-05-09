package com.uisrael.gitsco.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String nombre;
	private String apellido;
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	
	@OneToMany(mappedBy = "fkClientes")
	private List<CabeceraPedido> listaPedido = new ArrayList<>();
}
