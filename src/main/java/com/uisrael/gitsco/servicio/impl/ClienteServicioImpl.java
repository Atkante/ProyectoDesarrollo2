package com.uisrael.gitsco.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.gitsco.modelo.Cliente;
import com.uisrael.gitsco.repositorio.ClienteRepositorio;
import com.uisrael.gitsco.servicio.ClienteServicio;

@Component
@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteRepositorio repoCliente;
	@Override
	public void crearCliente(Cliente nuevoCliente) {
		// TODO Auto-generated method stub
		repoCliente.save(nuevoCliente);
		
	}

	@Override
	public List<Cliente> listarCliente() {
		// TODO Auto-generated method stub
		return repoCliente.listarCliente();
	}

	@Override
	public Cliente buscarClientesId(int idCliente) {
		// TODO Auto-generated method stub
		return repoCliente.buscarClientesId(idCliente);
	}

	@Override
	public void eliminarCliente(int idCliente) {
		// TODO Auto-generated method stub
		repoCliente.deleteById(idCliente);;
	}

}
