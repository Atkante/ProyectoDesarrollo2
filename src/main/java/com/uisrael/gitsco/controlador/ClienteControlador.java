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

import com.uisrael.gitsco.modelo.Cliente;
import com.uisrael.gitsco.servicio.ClienteServicio;

@Controller
public class ClienteControlador implements Serializable {

	@Autowired
	private ClienteServicio servicioCliente;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GetMapping("/cliente")
	public String verCliente(Model model) {
		List<Cliente> listaResultado = servicioCliente.listarCliente();
		model.addAttribute("listaCliente", listaResultado);
		return "cliente";
	}
	
	@GetMapping("/nuevoCliente")
	public String crearCliente(Model modelCli) {
		Cliente nuevaCliente = new Cliente();
		modelCli.addAttribute("nuevoCli", nuevaCliente);
		return "NuevoCliente";
	}
	
	@PostMapping("/guardarCliente")
	public String guardarCliente(@ModelAttribute("nuevoCli")Cliente nuevo) {
		servicioCliente.crearCliente(nuevo);
		nuevo.setFechaNac(new Date());
		this.servicioCliente.crearCliente(nuevo);
		return "redirect:/cliente";
	}
	@GetMapping("/editarCliente/{idCliente}")
	public String editarCliente(@PathVariable(value = "idCliente")int idCliente, Model modelCli) {
		modelCli.addAttribute("nuevoCli",servicioCliente.buscarClientesId(idCliente));
		return"NuevoCliente";
	}
	@GetMapping("/eliminarCliente/{idCliente}")
	public String eliminarCliente(@PathVariable(value="idCliente")int idCliente) {
		servicioCliente.eliminarCliente(idCliente);
		return"redirect:/cliente";
	}
	
}
