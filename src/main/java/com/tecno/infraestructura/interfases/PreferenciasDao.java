package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Commic;
import com.tecno.dominio.modelo.Generos;
import com.tecno.dominio.modelo.Preferencias;

public interface PreferenciasDao {
	 List<Generos> devolverTodos()  throws Exception;
	 public Preferencias  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Preferencias datos)  throws Exception;
	 public String actualizarRegistros(Preferencias datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Preferencias buscarRegistroNombre(Preferencias datos) throws Exception;
	 
	 public List<Generos> devolverGenPrefUsuario(int id) throws Exception ;
	 public List<Commic> devolverComicPrefUsuario(int id) throws Exception;
}
