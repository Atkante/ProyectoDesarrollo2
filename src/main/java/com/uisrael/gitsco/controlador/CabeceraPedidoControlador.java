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

import com.uisrael.gitsco.modelo.CabeceraPedido;
import com.uisrael.gitsco.servicio.CabeceraPedidoServicio;
import com.uisrael.gitsco.servicio.CategoriaServicio;
import com.uisrael.gitsco.servicio.ClienteServicio;
import com.uisrael.gitsco.servicio.UsuariosServicio;
import com.uisrael.gitsco.servicio.ProductoServicio;



@Controller
public class CabeceraPedidoControlador implements Serializable {

	@Autowired
	private CabeceraPedidoServicio servicioPedido;
	
	@Autowired
	private ProductoServicio servicioProducto;
	
	@Autowired
	private CategoriaServicio servicioCategoria;
	
	@Autowired
	private ClienteServicio servicioCliente;
	
	@Autowired
	private UsuariosServicio servicioUsuarios;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GetMapping("/cabeceraPedido")
	public String verPedido(Model model) {
		List<CabeceraPedido> listaResultado = servicioPedido.listarPedido();
		model.addAttribute("listaPedidos", listaResultado);
		return "cabeceraPedido";
	}
	
	@GetMapping("/nuevoPedido")
	public String crearPedido(Model modelPedido) {
		CabeceraPedido nuevoPedido = new CabeceraPedido();
		modelPedido.addAttribute("nuevoPedido", nuevoPedido);
		
		modelPedido.addAttribute("usuarios", servicioUsuarios.listarUsuarios());
		modelPedido.addAttribute("clientes", servicioCliente.listarCliente());
		modelPedido.addAttribute("productos", servicioProducto.listarProductos());
		return "NuevoPedido";
	}
	
	@PostMapping("/guardarPedido")
	public String guardarPedido(@ModelAttribute("nuevoPedido")CabeceraPedido nuevo) {
		servicioPedido.crearCabeceraPedido(nuevo);
		nuevo.setFechaPedidos(new Date());
		this.servicioPedido.crearCabeceraPedido(nuevo);
		return "redirect:/cabeceraPedido";
	}
	@GetMapping("/editarPedido/{idPedidos}")
	public String editarPedido(@PathVariable(value = "idPedidos")int idPedidos, Model modelPedido) {
		modelPedido.addAttribute("nuevoPedido",servicioPedido.buscarPedidosId(idPedidos));
		
		modelPedido.addAttribute("usuarios", servicioUsuarios.listarUsuarios());
		modelPedido.addAttribute("clientes", servicioCliente.listarCliente());
		modelPedido.addAttribute("productos", servicioProducto.listarProductos());
		return"NuevoPedido";
	}
	@GetMapping("/eliminarPedido/{idPedidos}")
	public String eliminarPedido(@PathVariable(value="idPedidos")int idPedidos) {
		servicioPedido.eliminarPedido(idPedidos);
		return"redirect:/cabeceraPedido";
	}


}
