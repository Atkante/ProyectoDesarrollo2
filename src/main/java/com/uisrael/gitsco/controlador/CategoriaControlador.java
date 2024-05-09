package com.uisrael.gitsco.controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.gitsco.modelo.Categoria;
import com.uisrael.gitsco.servicio.CategoriaServicio;

@Controller
public class CategoriaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaServicio servicioCategoria;
	//listar categorias
	@GetMapping("/categoria")
	public String abrirCategoria(Model model ) {
		List<Categoria> listaResultado= servicioCategoria.listarCategoria();
		model.addAttribute("listaCategoria", listaResultado);
		return "listaCategoria";
	}
	
	//crear categoria
	@GetMapping("/nuevaCategoria")
	public String nuevaCategoria(Model model) {
		Categoria nuevaCategoria= new Categoria();
		model.addAttribute("nueva", nuevaCategoria);
		return "nuevaCategoria";
	}
	
	//guardar categoria
	@PostMapping("/guardarCategoria")
	public String guardarCategoria(@ModelAttribute("nuevaCategoria") Categoria nuevaHtml) {
		nuevaHtml.setFechaRegistro(new Date());
		nuevaHtml.setEstado(true);
		servicioCategoria.insertarCategoria(nuevaHtml);
		return "redirect:/categoria";
	}

}
