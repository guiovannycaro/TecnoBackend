package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Commic;
import com.tecno.dominio.modelo.Commic_Genero;

public interface Commic_generoDao {
	
	 List<Commic_Genero> devolverTodos()  throws Exception;
	 public List<Commic>  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Commic_Genero datos)  throws Exception;
	 public String actualizarRegistros(Commic_Genero datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Commic_Genero buscarRegistroNombre(Commic_Genero datos) throws Exception;
}


