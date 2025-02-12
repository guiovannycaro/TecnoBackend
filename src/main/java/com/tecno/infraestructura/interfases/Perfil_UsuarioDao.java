package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.Perfil_Usuario;

public interface Perfil_UsuarioDao {

	 List<Perfil_Usuario> devolverTodos()  throws Exception;
	 public Perfil_Usuario  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Perfil_Usuario datos)  throws Exception;
	 public String actualizarRegistros(Perfil_Usuario datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Perfil_Usuario buscarRegistroNombre(Perfil_Usuario datos) throws Exception;
}
