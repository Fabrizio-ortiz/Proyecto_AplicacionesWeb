package com.jpa.verificacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpa.verificacion.entity.Supervisor;
import com.jpa.verificacion.service.SupervisorService;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {
	
	@Autowired
	private SupervisorService servicioSup;
	 
	
	@RequestMapping("/lista")
	public String inicio(Model model) {
		List<Supervisor> lista=servicioSup.listarTodos();
		
		
		model.addAttribute("Supervisores", lista);
		
		return "supervisor";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo")int cod,@RequestParam("nombre")String nom,
			@RequestParam("apellido")String ape,@RequestParam("dni")int dni,
			@RequestParam("nacionalidad")String nac,RedirectAttributes redirect) {
		
		try {
			Supervisor sup = new Supervisor();
			sup.setCodigo(cod);
			sup.setNombre(nom);
			sup.setApellido(ape);
			sup.setDni(dni);
			sup.setNacionalidad(nac);
			
			servicioSup.registrar(sup);
			
			if(cod==0)
				redirect.addFlashAttribute("MENSAJE","Supervisor registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Supervisor actualizado");
			
		}catch(Exception e){
			redirect.addFlashAttribute("MENSAJE","ERROR AL GUARDAR");
			e.printStackTrace();
		}
		return "redirect:/supervisor/lista";
   }
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Supervisor finById(@RequestParam("codigo")int cod) {
		Supervisor supe = servicioSup.buscar(cod);
		
		return supe;
	}
	
	@RequestMapping("/eliminar")
	public String deleteByID(@RequestParam("codigo") int cod,RedirectAttributes redirect) {
		try {
			servicioSup.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Supervisor eliminado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/supervisor/lista";
	}
}
