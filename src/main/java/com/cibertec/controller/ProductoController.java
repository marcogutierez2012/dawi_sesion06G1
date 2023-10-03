package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Producto;
import com.cibertec.repository.IProductoRepository;

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoRepository repo;
	
	@GetMapping("/listar")
	public String listadoProducto(Model model) {
		model.addAttribute("lstProductos", repo.findAll());
		return "listado";
	}
	
	@GetMapping("/")
	public String cargarPag(Model model) {
		model.addAttribute("producto", new Producto());
		return "crudproductos";
	}
	
	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Producto producto) {
		repo.save(producto);
		return "exito";
	}
	
	@PostMapping("/eliminar")
	public String eliminarProd(@ModelAttribute Producto p) {
		repo.delete(p);
		return "eliminado";
	}
	
	@PostMapping("/editar")
	public String buscarProd(@ModelAttribute Producto p, Model model) {
		model.addAttribute("producto", repo.findById(p.getCodigo()));
		return "crudprodutos";
	}
	
}
