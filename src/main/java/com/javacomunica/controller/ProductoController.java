package com.javacomunica.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javacomunica.model.Producto;
import com.javacomunica.model.Usuario;
import com.javacomunica.service.IProductoService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("")
	public String show() {
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("este es el objeto producto{}",producto );
		Usuario usuario = new Usuario(1,"","","","","","","");
		producto.setUsuario(usuario);
		productoService.save(producto);
		return "redirect:/productos";
	}
	
	
	
	
	
	
	
}
