package com.uisrael.gitsco.servicio;

import java.util.List;



import com.uisrael.gitsco.modelo.Usuarios;

public interface UsuariosServicio {

	public void crearUsuario(Usuarios nuevoUsuarios);
	
	public List<Usuarios> listarUsuarios();
	
	public Usuarios buscarUsuariosId(int idUsuario);
	
	public void eliminarUsuarios(int idUsuario);
}
