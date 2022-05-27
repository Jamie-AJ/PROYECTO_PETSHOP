package com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, String> {
	
	Usuario findByUsuarioAndContraseña(String usuario, String contraseña);

}
