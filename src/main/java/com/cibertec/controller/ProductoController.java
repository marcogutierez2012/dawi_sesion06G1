package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Producto;
import com.cibertec.repository.ICategoriaRepository;
import com.cibertec.repository.IProductoRepository;
import com.cibertec.repository.IProveedorRepository;

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoRepository repo;
	
	@Autowired
	private ICategoriaRepository cat;
	
	@Autowired
	private IProveedorRepository pro;
	
	@GetMapping("/listar")
	public String listadoProducto(Model model) {
		model.addAttribute("lstProductos", repo.findAll());
		return "listado";
	}
	
	@GetMapping("/")
	public String cargarPag(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("lstCategorias", cat.findAll());
		model.addAttribute("lstProveedores", pro.findAll());
		return "crudproductos";
	}
	
	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Producto producto) {
		repo.save(producto);
		return "exito";
		//return "redirect:/listar";
	}
	
	@PostMapping("/actualizar")
	public String actualizarPag(@ModelAttribute Producto producto) {
		repo.save(producto);
		return "actualizado";
	}
	
	@GetMapping("/editar/{codigo}")
	public String editar(@ModelAttribute Producto producto, Model model) {
		model.addAttribute("producto", repo.findBycodigo(producto.getCodigo()));
		model.addAttribute("lstCategorias", cat.findAll());
		model.addAttribute("lstProveedores", pro.findAll());
		return "editar";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(@ModelAttribute Producto producto, Model model) {
		Producto prod = repo.findBycodigo(producto.getCodigo());
		repo.delete(prod);
		return "redirect:/listar";
	}
	
}
