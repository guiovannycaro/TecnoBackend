package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Departamentoestado;

public interface DepartamentoestadoDao {


	 List<Departamentoestado> devolverTodos()  throws Exception;
	 public Departamentoestado  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Departamentoestado datos)  throws Exception;
	 public String actualizarRegistros(Departamentoestado datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Departamentoestado buscarRegistroNombre(Departamentoestado datos) throws Exception;
}
