package com.pet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pet.model.Usuario;
import com.pet.repository.IUsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository repoU;
	
	@GetMapping("/login/cargar")
	public String abrirLogin( Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "login";
	}
	
	@PostMapping("/login/validar")
	public String validarLogin(@ModelAttribute Usuario usuario, Model model ) {	
		System.out.println("Enviado " + usuario);
		
		Usuario u = repoU.findByUsuarioAndContraseña(usuario.getUsuario(), usuario.getContraseña());
		System.out.println(u);
		
		if(u==null) {
			model.addAttribute("mensaje", "Usuario o Clave Incorrecto");
			return "login";
		}
			
		model.addAttribute("usuario", u);
		return "principal";
	}
	
	@GetMapping("/usuario/cargar")
	public String abrirRegistro( Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "registro";
	}
	
	@PostMapping("/usuario/grabar")
	public String grabarRegistro(@ModelAttribute Usuario usuario, Model model ) {	
		System.out.println("Enviado " + usuario);
		
		try {
			usuario.setCod_usu(usuario.getNom_usu().substring(0,2)+usuario.getApel_usu().substring(0, 2)+usuario.getDni_usu());
			usuario.setCod_tipo("cli");
			repoU.save(usuario);			
			model.addAttribute("mensaje", "Usuario Registrado");
			
			
		} catch (Exception e) {
			
			model.addAttribute("mensaje","Error al Registrar");				
			
		}		
		
		return "login";
	}

}
