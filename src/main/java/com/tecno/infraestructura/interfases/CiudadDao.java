package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Ciudad;

public interface CiudadDao {
	 List<Ciudad> devolverTodos()  throws Exception;
	 public Ciudad  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Ciudad datos)  throws Exception;
	 public String actualizarRegistros(Ciudad datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Ciudad buscarRegistroNombre(Ciudad datos) throws Exception;
}
