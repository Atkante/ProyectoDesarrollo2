package com.uisrael.gitsco.controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.uisrael.gitsco.modelo.Usuarios;
import com.uisrael.gitsco.servicio.UsuariosServicio;

@Controller
public class UsuariosControlador implements Serializable {

	@Autowired
	private UsuariosServicio servicioUsuarios;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GetMapping("/usuario")
	public String verUsuarios(Model model) {
		List<Usuarios> listaResultado = servicioUsuarios.listarUsuarios();
		model.addAttribute("listaUsuarios", listaResultado);
		return "usuario";
	}
	
	@GetMapping("/nuevoUsuarios")
	public String crearUsuarios(Model modelUsuario) {
		Usuarios nuevaUsuarios = new Usuarios();
		modelUsuario.addAttribute("nuevoUsuario", nuevaUsuarios);
		return "NuevoUsuarios";
	}
	
	@PostMapping("/guardarUsuarios")
	public String guardarUsuarios(@ModelAttribute("nuevoUsuario")Usuarios nuevo) {
		servicioUsuarios.crearUsuario(nuevo);
		nuevo.setFechaContrato(new Date());
		this.servicioUsuarios.crearUsuario(nuevo);
		return "redirect:/usuario";
	}
	@GetMapping("/editarUsuarios/{idUsuario}")
	public String editarUsuarios(@PathVariable(value = "idUsuario")int idUsuario, Model modelUsuario) {
		modelUsuario.addAttribute("nuevoUsuario",servicioUsuarios.buscarUsuariosId(idUsuario));
		return"NuevoUsuarios";
	}
	@GetMapping("/eliminarUsuarios/{idUsuario}")
	public String eliminarUsuarios(@PathVariable(value="idUsuario")int idUsuario) {
		servicioUsuarios.eliminarUsuarios(idUsuario);
		return"redirect:/usuarios";
	}

}
