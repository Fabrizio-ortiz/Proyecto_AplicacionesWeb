package com.jpa.verificacion.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tb_supervisor")
public class Supervisor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_supervisor")
	private Integer codigo;
	@Column(name = "nom_supervisor")
	private String nombre;
	@Column(name = "ape_supervisor")
	private String apellido;
	@Column(name = "dni_supervisor")
	private int dni;
	@Column(name = "nacionalidad")
	private String nacionalidad;
	
	@JsonIgnore
	@OneToMany(mappedBy = "supervisor")
	private List<OrdenCompra> listaOrden;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<OrdenCompra> getListaOrden() {
		return listaOrden;
	}

	public void setListaOrden(List<OrdenCompra> listaOrden) {
		this.listaOrden = listaOrden;
	}

	

	

	
	
}	