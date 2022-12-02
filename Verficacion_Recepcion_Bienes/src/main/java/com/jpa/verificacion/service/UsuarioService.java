package com.jpa.verificacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.verificacion.entity.Enlace;
import com.jpa.verificacion.entity.Usuario;
import com.jpa.verificacion.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario loginUsuario(String nomUsuario) {
		return repo.iniciarSesion(nomUsuario);
	}
	public List<Enlace> enlacesPorUsuario(int codRol){
		return repo.traerEnlaces(codRol); 
	}
	
}
