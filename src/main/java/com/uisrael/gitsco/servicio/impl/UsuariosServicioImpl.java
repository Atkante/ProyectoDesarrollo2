package com.uisrael.gitsco.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.gitsco.modelo.Usuarios;
import com.uisrael.gitsco.repositorio.UsuariosRepositorio;
import com.uisrael.gitsco.servicio.UsuariosServicio;

@Component
@Service
public class UsuariosServicioImpl implements UsuariosServicio {

	@Autowired
	private UsuariosRepositorio repoUsuarios;
	@Override
	public void crearUsuario(Usuarios nuevoUsuarios) {
		// TODO Auto-generated method stub
		repoUsuarios.save(nuevoUsuarios);
	}

	@Override
	public List<Usuarios> listarUsuarios() {
		// TODO Auto-generated method stub
		return repoUsuarios.listarUsuarios();
	}

	@Override
	public Usuarios buscarUsuariosId(int idUsuario) {
		// TODO Auto-generated method stub
		return repoUsuarios.buscarUsuariosId(idUsuario);
	}

	@Override
	public void eliminarUsuarios(int idUsuario) {
		// TODO Auto-generated method stub
		repoUsuarios.deleteById(idUsuario);
	}

}
