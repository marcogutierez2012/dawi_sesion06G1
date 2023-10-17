package com.cibertec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_productos")
public class Producto {
	
	@Id
	@Column(name="id_prod")
	private String codigo;
	@Column(name="des_prod")
	private String descripcion;
	@Column(name="stk_prod")
	private int stock;
	@Column(name="pre_prod")
	private double precio;
	
	//@Column(name="idcategoria")
	//private int idcategoria;
	
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;
	
	@Column(name="est_prod")
	private int estado;
	
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private Proveedor proveedor;
	
	//@Column(name="idcategoria")
	//private int idproveedor;
	
	// Métodos getters y setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}	
}
