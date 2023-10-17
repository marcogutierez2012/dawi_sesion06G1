package com.cibertec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_proveedor")
public class Proveedor {
	
	@Id
	@Column(name="idproveedor")
	private int idproveedor;
	
	@Column(name="nombre_rs")
	private String nomproveedor;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNomproveedor() {
		return nomproveedor;
	}

	public void setNomproveedor(String nomproveedor) {
		this.nomproveedor = nomproveedor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
