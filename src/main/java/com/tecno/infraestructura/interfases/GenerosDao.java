package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Generos;

public interface GenerosDao {

	 List<Generos> devolverTodos()  throws Exception;
	 public Generos  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Generos datos)  throws Exception;
	 public String actualizarRegistros(Generos datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Generos buscarRegistroNombre(Generos datos) throws Exception;
}
