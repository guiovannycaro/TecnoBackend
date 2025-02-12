package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Perfil;
import com.tecno.dominio.modelo.Persona;
import com.tecno.dominio.modelo.Respuesta;
import com.tecno.dominio.modelo.Usuarios;
import com.tecno.infraestructura.interfases.ServicioSeguridadDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class ServicioSeguridadImpl implements ServicioSeguridadDao {

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	
	@Override
	public boolean autenticacion(Usuarios datos) throws Exception {
		Usuarios user = new Usuarios();
		String sql = "select usuario.username as nombre from usuario where username = '"+datos.getUsu_username()+"' "
				+ "and  contrasena= '"+datos.getUsu_contrasena()+"'";
		System.out.println(sql);
		 String vusuario ="";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			vusuario =  resulSelect.getString("nombre");
			}
		
		if(vusuario.equals("") ) {
			 return false;
		 }
		 return true;
	}

	
	
	
	
	@Override
	public List<Perfil> getRoles(String datos)  throws Exception{
		ArrayList<Perfil> list = new ArrayList<>();
		String sql = " select perfil.idperfil as perfil from perfil_usuario "
				+ " join perfil on perfil_usuario.idperfil  = perfil.idperfil"
				+ " join usuario on perfil_usuario.idusuario = usuario.idusuario"
				+ " where usuario.username = '"+datos+"'";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
		Perfil perfil = new Perfil();
		perfil.setPer_id(resulSelect.getInt("perfil"));;
		list.add(perfil);
		}
		return list;
	}

	@Override
	public Persona getUserName(Usuarios datos) throws Exception {
		Persona dto = new Persona();
		String sql = " select persona.nombres as nombre from usuario  "
				+ " join persona on usuario.idpersona  = persona.idpersona"
				+ " where usuario.username = '"+datos.getUsu_username()+"'";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
		
		dto.setPer_nombres(sql);

		}
		return dto;
	}

	@Override
	public boolean logOut(String datos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String cambiarPassword(Usuarios datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   usuario SET " + "contrasena = '" + datos.getUsu_idpersona() + "'"
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

}
