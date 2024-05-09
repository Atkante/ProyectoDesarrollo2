package com.uisrael.gitsco.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
public class Usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombreUsuario;
	private String apellidoUsuario;
	private BigDecimal salario;
	
	@Temporal(TemporalType.DATE)
	private Date fechaContrato;
	
	@OneToMany(mappedBy = "fkUsuarios")
	private List<CabeceraPedido> listaPedido = new ArrayList<>();
}
