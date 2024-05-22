package com.uisrael.gitsco.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inicio {
	

	@GetMapping("/inicio")
	public String abrirIndex(){
		return "Inicio";
	}
}


