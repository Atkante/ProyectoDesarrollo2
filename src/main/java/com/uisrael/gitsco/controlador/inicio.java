package com.uisrael.gitsco.controlador;

public class inicio {
    @GetMapping("/inicio")
    public String abrirIndex(){
        return "Inicio";
        
    }
}
