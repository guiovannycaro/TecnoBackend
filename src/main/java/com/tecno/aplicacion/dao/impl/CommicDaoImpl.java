package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Commic;

import com.tecno.dominio.modelo.Respuesta;
import com.tecno.infraestructura.interfases.CommicDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class CommicDaoImpl implements CommicDao{


	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;

	@Override
	public List<Commic> devolverTodos() throws Exception {
		ArrayList<Commic> list = new ArrayList<>();
		String sql = "select * from commic";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Commic dato = new Commic();
			dato.setCom_id(resulSelect.getInt("idcommic"));
			dato.setCom_nombre(resulSelect.getString("nombre"));
			dato.setCom_fechaPublicacion(resulSelect.getString("fechapublic"));
			dato.setCom_escritor(resulSelect.getString("escritor"));
			dato.setCom_dibujante(resulSelect.getString("dibujante"));
			dato.setCom_artportada(resulSelect.getString("artportada"));
			dato.setCom_descripcion(resulSelect.getString("descripcion"));
			dato.setCom_imagen(resulSelect.getString("imagen"));
			dato.setCom_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
			
			list.add(dato);
		}
		return list;
	}

	@Override
	public List<Commic> buscarRegistroPorId(int id) throws Exception {
		ArrayList<Commic> list = new ArrayList<>();
		String sql = "select * from commic where idcommic = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		
		while (resulSelect.next()) {

			Commic dato = new Commic();
			dato.setCom_id(resulSelect.getInt("idcommic"));
			dato.setCom_nombre(resulSelect.getString("nombre"));
			dato.setCom_fechaPublicacion(resulSelect.getString("fechapublic"));
			dato.setCom_escritor(resulSelect.getString("escritor"));
			dato.setCom_dibujante(resulSelect.getString("dibujante"));
			dato.setCom_artportada(resulSelect.getString("artportada"));
			dato.setCom_descripcion(resulSelect.getString("descripcion"));
			dato.setCom_imagen(resulSelect.getString("imagen"));
			dato.setCom_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
			list.add(dato);

		}

		return list;
	}

	@Override
	public String agregarRegistro(Commic datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  commic (nombre,fechapublic,escritor,dibujante,artportada,descripcion,imagen,is_activo" + ") "
				+ "values(" + datos.getCom_nombre() + ",'" + datos.getCom_fechaPublicacion() + "'"
				+ ",'" + datos.getCom_escritor() + "'," + "'" + datos.getCom_dibujante() + "'"
				+ ",'" + datos.getCom_artportada() + "'" + ",'"+ datos.getCom_descripcion() +"'"
				+ ",'" + datos.getCom_imagen() + "'" + ",'"+ datos.getCom_estado() +"'"
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
	public String actualizarRegistros(Commic datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   commic SET " + "nombre = '" + datos.getCom_nombre() + "'," + "fechapublic = '"
				+ datos.getCom_fechaPublicacion() + "'," + "escritor = '" + datos.getCom_escritor() + "'," 
				+ "dibujante = '" +  datos.getCom_dibujante()+ "'," + "artportada = '" + datos.getCom_artportada() + "',"
			    + "descripcion = '" +  datos.getCom_descripcion() + "'," + "imagen = '" + datos.getCom_imagen() + "',"
			     + "is_activo = '" +  datos.getCom_estado() + "'" + ""
				+ " WHERE idcommic = " + datos.getCom_id() + " ";
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
		String sql = "Delete from  commic " + " WHERE idcommic = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Commic buscarRegistroNombre(Commic datos) throws Exception {
		String sql = "select * from commic where nombre = " + datos.getCom_nombre() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Commic dato = new Commic();
		while (resulSelect.next()) {

			dato.setCom_id(resulSelect.getInt("idcommic"));
			dato.setCom_nombre(resulSelect.getString("nombre"));
			dato.setCom_fechaPublicacion(resulSelect.getString("fechapublic"));
			dato.setCom_escritor(resulSelect.getString("escritor"));
			dato.setCom_dibujante(resulSelect.getString("dibujante"));
			dato.setCom_artportada(resulSelect.getString("artportada"));
			dato.setCom_descripcion(resulSelect.getString("descripcion"));
			dato.setCom_imagen(resulSelect.getString("imagen"));
			dato.setCom_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
			

		}

		return dato;
	}

}
