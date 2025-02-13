package com.tecno.infraestructura.interfases;


import java.util.List;
import java.util.Optional;

import com.tecno.dominio.modelo.UsuarioPerfil;
import com.tecno.dominio.modelo.Usuarios;

public interface UsuariosDao {

	 List<Usuarios> devolverTodos()  throws Exception;
	 public Usuarios buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(Usuarios datos)  throws Exception;
	 public String actualizarRegistros(Usuarios datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public Usuarios buscarRegistroNombre(Usuarios datos) throws Exception;
	 public List<UsuarioPerfil> obtUsuarioPerfil(String datos)  throws Exception;
	 

}
