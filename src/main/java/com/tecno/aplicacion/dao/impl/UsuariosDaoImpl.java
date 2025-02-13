package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;


import com.google.gson.Gson;
import com.tecno.dominio.modelo.Respuesta;
import com.tecno.dominio.modelo.UsuarioPerfil;
import com.tecno.dominio.modelo.Usuarios;
import com.tecno.infraestructura.interfases.UsuariosDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class UsuariosDaoImpl implements UsuariosDao {

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;

	@Override
	public List<Usuarios> devolverTodos() throws Exception {
		ArrayList<Usuarios> list = new ArrayList<>();
		String sql = "select * from usuario";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Usuarios usu = new Usuarios();
			usu.setUsu_idusuario(resulSelect.getInt("idusuario"));
			usu.setUsu_idpersona(resulSelect.getInt("idpersona"));
			usu.setUsu_username(resulSelect.getString("username"));
			usu.setUsu_contrasena(resulSelect.getString("contrasena"));
			usu.setUsu_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
			usu.setUsu_cambiocontrasena(Boolean.parseBoolean(resulSelect.getString("is_cambiarcontrasena")));
			list.add(usu);
		}
		return list;
	}

	@Override
	public Usuarios buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from usuario where idusuario = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Usuarios usu = new Usuarios();
		while (resulSelect.next()) {

			usu.setUsu_idusuario(resulSelect.getInt("idusuario"));
			usu.setUsu_username(resulSelect.getString("username"));
			usu.setUsu_contrasena(resulSelect.getString("contrasena"));
			usu.setUsu_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
			usu.setUsu_cambiocontrasena(Boolean.parseBoolean(resulSelect.getString("is_cambiarcontrasena")));

		}

		return usu;
	}
	
	@Override
	public List<UsuarioPerfil> obtUsuarioPerfil(String datos)  throws Exception
	{
		ArrayList<UsuarioPerfil> list = new ArrayList<>();
		String sql =" select perfil.descripcion as perfil,usuario.username as usuario"
		+" from perfil_usuario"
		+" join usuario on perfil_usuario.idusuario = usuario.idusuario"
		+" join perfil on perfil_usuario.idperfil = perfil.idperfil"
		+" where usuario.username = '" + datos + "' and perfil.is_activo = true";
		
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		UsuarioPerfil usu = new UsuarioPerfil();
		while (resulSelect.next()) {

			usu.setUsuario(resulSelect.getString("usuario"));
			usu.setPerfil(resulSelect.getString("perfil"));
			list.add(usu);
		}

		return list;
		
		
	}

	@Override
	public String agregarRegistro(Usuarios datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  usuario (idpersona,username,contrasena,is_activo,is_cambiarcontrasena" + ") "
				+ "values(" + datos.getUsu_idpersona() + ",'" + datos.getUsu_username() + "','"
				+ datos.getUsu_contrasena() + "'," + "'" + datos.getUsu_estado() + "',"
				+ datos.getUsu_cambiocontrasena() + "" + ")  ";
		 rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue ingresado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue ingresado De Manera Correcta");
		}

		return gson.toJson(respuesta);
	}
	

	@Override
	public String actualizarRegistros(Usuarios datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   usuario SET " + "idpersona = '" + datos.getUsu_idpersona() + "'," + "username = '"
				+ datos.getUsu_username() + "'," + "contrasena = '" + datos.getUsu_contrasena() + "'," + "is_activo = '"
				+ datos.getUsu_estado() + "'," + "is_cambiarcontrasena = '" + datos.getUsu_cambiocontrasena() + "'"
				+ " WHERE idusuario = " + datos.getUsu_idusuario() + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue actualizado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo",
					"El registro no fue actualizado De Manera Correcta");
		}

		return gson.toJson(respuesta);
	}

	@Override
	public String eliminarRegistro(int id) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta;
		String sql = "Delete from  usuario " + " WHERE idusuario = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Usuarios buscarRegistroNombre(Usuarios datos) throws Exception {
		String sql = "select * from usuario where username = " + datos.getUsu_username() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Usuarios usu = new Usuarios();
		while (resulSelect.next()) {

			usu.setUsu_idusuario(resulSelect.getInt("idusuario"));
			usu.setUsu_username(resulSelect.getString("username"));
			usu.setUsu_contrasena(resulSelect.getString("contrasena"));
			usu.setUsu_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
			usu.setUsu_cambiocontrasena(Boolean.parseBoolean(resulSelect.getString("is_cambiarcontrasena")));

		}

		return usu;
	}

}
