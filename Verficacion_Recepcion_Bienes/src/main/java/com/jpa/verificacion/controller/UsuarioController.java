package com.jpa.verificacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jpa.verificacion.entity.Enlace;
import com.jpa.verificacion.entity.Usuario;
import com.jpa.verificacion.service.UsuarioService;

@SessionAttributes({"ENLACES"})
@Controller
public class UsuarioController {

	
	@Autowired
	private UsuarioService servicio;
	
	
	@RequestMapping("/login")
	public String inicio() {
		
		return "inicio";
	}

	@RequestMapping("/intranet")
	public String intranet(Authentication auth,Model model) {
		
		//obtener usurio que inicio sesión
		String vUsuario=auth.getName();
		//
		Usuario bean=servicio.loginUsuario(vUsuario);
		//traer enlaces
		List<Enlace> data=servicio.enlacesPorUsuario(bean.getRol().getIdrol());
		//
		model.addAttribute("ENLACES",data);
		return "intranet";
	}
	
}





