package com.jpa.verificacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.verificacion.repository.SupervisorRepository;
import com.jpa.verificacion.entity.Proveedor;
import com.jpa.verificacion.entity.Supervisor;


@Service
public class SupervisorService {
	
	@Autowired
	private SupervisorRepository repo;
		
	
	public List<Supervisor> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Supervisor bean) {
		repo.save(bean);
	}
	
	public Supervisor buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void eliminar(Integer cod){
		repo.deleteById(cod);
	}
	
}
