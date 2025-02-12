package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Perfil_Usuario;
import com.tecno.dominio.modelo.Respuesta;
import com.tecno.dominio.modelo.TipoDocumento;
import com.tecno.infraestructura.interfases.Perfil_UsuarioDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class PerfilUsuarioDaoImpl implements Perfil_UsuarioDao{

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	
	@Override
	public List<Perfil_Usuario> devolverTodos() throws Exception {
		ArrayList<Perfil_Usuario> list = new ArrayList<>();
		String sql = "select * from perfil_usuario";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Perfil_Usuario dato = new Perfil_Usuario();
			dato.setPerusu_idpu(resulSelect.getInt("idpu"));
			dato.setUsu_idperfil(resulSelect.getInt("idperfil"));
			dato.setUsu_idusuario(resulSelect.getInt("idusuario"));
		
			list.add(dato);
		}
		return list;
	}

	@Override
	public Perfil_Usuario buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from perfil_usuario where idpu = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Perfil_Usuario dato = new Perfil_Usuario();
		while (resulSelect.next()) {

			dato.setPerusu_idpu(resulSelect.getInt("idpu"));
			dato.setUsu_idperfil(resulSelect.getInt("idperfil"));
			dato.setUsu_idusuario(resulSelect.getInt("idusuario"));

		}

		return dato;
	}

	@Override
	public String agregarRegistro(Perfil_Usuario datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  perfil_usuario (idperfil,idusuario ) "
				+ "values(" + datos.getUsu_idperfil() + ",'" + datos.getUsu_idusuario() + "'"
			
				+ ")  ";
		 rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue ingresado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue ingresado De Manera Correcta");
		}

		return gson.toJson(respuesta);
	}

	@Override
	public String actualizarRegistros(Perfil_Usuario datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   perfil_usuario SET " + "idperfil = '" + datos.getUsu_idperfil() + "'," + "idusuario = '"
				+ datos.getUsu_idperfil() + "'" 
				+ " WHERE idpu = " + datos.getPerusu_idpu() + " ";
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
		String sql = "Delete from  perfil_usuario " + " WHERE idpu = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Perfil_Usuario buscarRegistroNombre(Perfil_Usuario datos) throws Exception {
		String sql = "select * from perfil_usuario where idperfil = " + datos.getUsu_idperfil() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Perfil_Usuario dato = new Perfil_Usuario();
		while (resulSelect.next()) {

			dato.setPerusu_idpu(resulSelect.getInt("idpu"));
			dato.setUsu_idperfil(resulSelect.getInt("idperfil"));
			dato.setUsu_idusuario(resulSelect.getInt("idusuario"));
		}

		return dato;
	}

}
