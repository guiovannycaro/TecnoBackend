package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Perfil;
import com.tecno.dominio.modelo.Respuesta;

import com.tecno.infraestructura.interfases.PerfilDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class PerfilDaoImpl implements PerfilDao{

	
	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	
	@Override
	public List<Perfil> devolverTodos() throws Exception {
		ArrayList<Perfil> list = new ArrayList<>();
		String sql = "select * from perfil";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Perfil dato = new Perfil();
			dato.setPer_id(resulSelect.getInt("idperfil"));
			dato.setPer_decripcion(resulSelect.getString("descripcion"));
			dato.setPer_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
		
			list.add(dato);
		}
		return list;
	}

	@Override
	public Perfil buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from perfil where idtipodocumento = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Perfil dato = new Perfil();
		while (resulSelect.next()) {

			dato.setPer_id(resulSelect.getInt("idperfil"));
			dato.setPer_decripcion(resulSelect.getString("descripcion"));
			dato.setPer_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));

		}

		return dato;
	}

	@Override
	public String agregarRegistro(Perfil datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  perfil (descripcion,is_activo ) "
				+ "values(" + datos.getPer_decripcion() + ",'" + datos.getPer_estado() + "'"
			
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
	public String actualizarRegistros(Perfil datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   perfil SET " + "descripcion = '" + datos.getPer_decripcion() + "'," + "is_activo = '"
				+ datos.getPer_estado() + "'" 
				+ " WHERE idperfil = " + datos.getPer_id() + " ";
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
		String sql = "Delete from  perfil " + " WHERE idperfil = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Perfil buscarRegistroNombre(Perfil datos) throws Exception {
		String sql = "select * from perfil where descripcion = " + datos.getPer_decripcion() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Perfil dato = new Perfil();
		while (resulSelect.next()) {

			dato.setPer_id(resulSelect.getInt("idperfil"));
			dato.setPer_decripcion(resulSelect.getString("descripcion"));
			dato.setPer_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));

		}

		return dato;
	}

}
