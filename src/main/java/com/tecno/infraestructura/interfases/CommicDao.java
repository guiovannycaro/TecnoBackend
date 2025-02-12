package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Commic;



public interface CommicDao {

	 List<Commic> devolverTodos()  throws Exception;
	 public List<Commic> buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Commic datos)  throws Exception;
	 public String actualizarRegistros(Commic datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Commic buscarRegistroNombre(Commic datos) throws Exception;
}
