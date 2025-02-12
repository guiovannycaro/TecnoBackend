package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Perfil;

public interface PerfilDao {

	 List<Perfil> devolverTodos()  throws Exception;
	 public Perfil  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Perfil datos)  throws Exception;
	 public String actualizarRegistros(Perfil datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Perfil buscarRegistroNombre(Perfil datos) throws Exception;
}
