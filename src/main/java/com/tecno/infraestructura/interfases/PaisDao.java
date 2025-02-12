package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Pais;

public interface PaisDao {
	
	 List<Pais> devolverTodos()  throws Exception;
	 public Pais  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Pais datos)  throws Exception;
	 public String actualizarRegistros(Pais datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Pais buscarRegistroNombre(Pais datos) throws Exception;

}
