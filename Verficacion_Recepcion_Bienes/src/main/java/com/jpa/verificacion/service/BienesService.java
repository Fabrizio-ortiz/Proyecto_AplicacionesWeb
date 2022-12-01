package com.jpa.verificacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.verificacion.entity.Bienes;
import com.jpa.verificacion.repository.BienesRepository;



@Service
public class BienesService {

	@Autowired
	private BienesRepository repo;
	
	public void guardar(Bienes bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Bienes buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Bienes> listarTodos(){
		return repo.findAll();
	}

}
