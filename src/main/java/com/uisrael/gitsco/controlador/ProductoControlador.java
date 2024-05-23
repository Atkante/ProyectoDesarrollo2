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


import com.uisrael.gitsco.modelo.Producto;

import com.uisrael.gitsco.servicio.ProductoServicio;
@Controller
public class ProductoControlador implements Serializable  {
    
	@Autowired
	private ProductoServicio servicioProducto;

    private static final long serialVersionUID = 1L;


	@GetMapping("/Producto")
	public String verProducto(Model model) {
		List<Producto> listaResultado = servicioProducto.listarProductos();
		model.addAttribute("ListadoProducto", listaResultado);
		return "Producto";
	}

    @GetMapping("/nuevoProducto")
	public String crearProducto(Model modelPro) {
		Producto nuevoProducto = new Producto();
		modelPro.addAttribute("nuevoPro", nuevoProducto);
		return "NuevoProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String guardarProducto(@ModelAttribute("nuevoPro")Producto nuevo) {
		servicioProducto.crearProducto(nuevo);
		nuevo.setFechaIngreso(new Date());
		this.servicioProducto.crearProducto(nuevo);
		return "redirect:/Producto";
	}

}
