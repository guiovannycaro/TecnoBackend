package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Persona;

public interface PersonasDao {

	 List<Persona> devolverTodos()  throws Exception;
	 public Persona  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Persona datos)  throws Exception;
	 public String actualizarRegistros(Persona datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Persona buscarRegistroNombre(Persona datos) throws Exception;
}
