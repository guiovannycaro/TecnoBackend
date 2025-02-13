package com.tecno.infraestructura.interfases;

import com.tecno.dominio.modelo.Usuarios;

import java.util.List;

import com.tecno.dominio.modelo.Perfil;
import com.tecno.dominio.modelo.Persona;
public interface ServicioSeguridadDao {

	 public boolean autenticacion(Usuarios datos) throws Exception;

	public String getRoles(String datos)  throws Exception;
	
	 public Persona getUserName(Usuarios datos) throws Exception;

	 public boolean logOut(String datos);
	 
	 public String cambiarPassword(Usuarios datos) throws Exception;
}
