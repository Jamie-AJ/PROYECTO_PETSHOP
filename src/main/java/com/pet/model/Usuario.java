package com.pet.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
	
	@Id
	private String cod_usu;
	private String cod_tipo;
    private String nom_usu;
    private String apel_usu;
    private String usuario;
    private String contraseña;
    private String telefono;
    private String dni_usu;
    
}
