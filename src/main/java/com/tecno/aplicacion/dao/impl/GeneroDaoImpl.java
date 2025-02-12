package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Generos;

import com.tecno.dominio.modelo.Respuesta;
import com.tecno.infraestructura.interfases.GenerosDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class GeneroDaoImpl implements GenerosDao{

	
	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	 
	@Override
	public List<Generos> devolverTodos() throws Exception {
		ArrayList<Generos> list = new ArrayList<>();
		String sql = "select * from genero";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Generos dato = new Generos();
			dato.setGen_Id(resulSelect.getInt("idgenero"));
			dato.setGen_nombre(resulSelect.getString("nombre"));
			dato.setGen_descripcion(resulSelect.getString("descripcion"));
			dato.setGen_imagen(resulSelect.getString("imagen"));
			dato.setGen_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
			list.add(dato);
		}
		return list;
	}

	@Override
	public Generos buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from genero where idgenero = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Generos dato = new Generos();
		while (resulSelect.next()) {

			dato.setGen_Id(resulSelect.getInt("idgenero"));
			dato.setGen_nombre(resulSelect.getString("nombre"));
			dato.setGen_descripcion(resulSelect.getString("descripcion"));
			dato.setGen_imagen(resulSelect.getString("imagen"));
			dato.setGen_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));

		}

		return dato;
	}

	@Override
	public String agregarRegistro(Generos datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  genero (nombre,descripcion,imagen,is_activo" + ") "
				+ "values(" + datos.getGen_nombre() + ",'" + datos.getGen_descripcion() + "','"
				+ datos.getGen_imagen() + "'," + "'" + datos.getGen_estado() + "'"
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
	public String actualizarRegistros(Generos datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   genero SET " + "nombre = '" + datos.getGen_nombre() + "'," + "descripcion = '"
				+ datos.getGen_descripcion() + "'," + "imagen = '" + datos.getGen_imagen() + "'," + "is_activo = '"
				+ datos.getGen_estado() + "'"
				+ " WHERE idgenero = " + datos.getGen_Id() + " ";
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
		String sql = "Delete from  genero " + " WHERE idgenero = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Generos buscarRegistroNombre(Generos datos) throws Exception {
		String sql = "select * from genero where nombre = " + datos.getGen_nombre() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Generos dato = new Generos();
		while (resulSelect.next()) {

			dato.setGen_Id(resulSelect.getInt("idgenero"));
			dato.setGen_nombre(resulSelect.getString("nombre"));
			dato.setGen_descripcion(resulSelect.getString("descripcion"));
			dato.setGen_imagen(resulSelect.getString("imagen"));
			dato.setGen_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));

		}

		return dato;
	}

}
