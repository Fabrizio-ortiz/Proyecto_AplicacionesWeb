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
@Table(name="tb_enlace")
public class Enlace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idenlace;
	private String descripcion;
	private String ruta;
	
	@JsonIgnore
	@OneToMany(mappedBy = "enlace")
	private List<RolEnlace> listaRolEnlace;

	public Integer getIdenlace() {
		return idenlace;
	}

	public void setIdenlace(Integer idenlace) {
		this.idenlace = idenlace;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<RolEnlace> getListaRolEnlace() {
		return listaRolEnlace;
	}

	public void setListaRolEnlace(List<RolEnlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}
	
	
	
}