package com.uisrael.gitsco.servicio;

import java.util.List;



import com.uisrael.gitsco.modelo.Cliente;

public interface ClienteServicio {

	public void crearCliente(Cliente nuevoCliente);
	
	public List<Cliente> listarCliente();
	
	public Cliente buscarClientesId(int idCliente);
	
	public void eliminarCliente(int idCliente);
}
