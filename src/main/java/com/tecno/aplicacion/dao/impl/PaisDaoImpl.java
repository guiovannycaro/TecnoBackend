package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Pais;

import com.tecno.dominio.modelo.Respuesta;
import com.tecno.infraestructura.interfases.PaisDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class PaisDaoImpl implements PaisDao{

	
	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;

	@Override
	public List<Pais> devolverTodos() throws Exception {
		ArrayList<Pais> list = new ArrayList<>();
		String sql = "select * from pais";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Pais dato = new Pais();
			dato.setPai_idpais(resulSelect.getInt("idpais"));
			dato.setPai_nombre(resulSelect.getString("nombre"));
			dato.setPai_cod_oficial_iso(resulSelect.getString("cod_oficial_iso"));
			dato.setPai_iso2(resulSelect.getString("iso2"));
			dato.setPai_iso3(resulSelect.getString("iso3"));
			dato.setPai_latitud(resulSelect.getString("latitud"));
			dato.setPai_longitud(resulSelect.getString("longitud"));
			dato.setPai_codpostal(resulSelect.getString("codpostal"));

			
			list.add(dato);
		}
		return list;
	}

	@Override
	public Pais buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from pais where idpais = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Pais dato = new Pais();
		while (resulSelect.next()) {


			dato.setPai_idpais(resulSelect.getInt("idpais"));
			dato.setPai_nombre(resulSelect.getString("nombre"));
			dato.setPai_cod_oficial_iso(resulSelect.getString("cod_oficial_iso"));
			dato.setPai_iso2(resulSelect.getString("iso2"));
			dato.setPai_iso3(resulSelect.getString("iso3"));
			dato.setPai_latitud(resulSelect.getString("latitud"));
			dato.setPai_longitud(resulSelect.getString("longitud"));
			dato.setPai_codpostal(resulSelect.getString("codpostal"));

		}

		return dato;
	}

	@Override
	public String agregarRegistro(Pais datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  pais (nombre,cod_oficial_iso,iso2,iso3,latitud,longitud,codpostal" + ") "
				+ "values(" + datos.getPai_nombre() + ",'" + datos.getPai_cod_oficial_iso() + "'"
				+ ",'" + datos.getPai_iso2() + "'," + "'" + datos.getPai_iso3() + "',"
				+ ",'" + datos.getPai_latitud() + "'," + "'" + datos.getPai_longitud() + "',"
				+ ",'" + datos.getPai_codpostal() + "'"
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
	public String actualizarRegistros(Pais datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   pais SET " + "nombre = '" + datos.getPai_nombre() + "'," + "cod_oficial_iso = '"
				+ datos.getPai_cod_oficial_iso() + "'," + "iso2 = '" + datos.getPai_iso2() + "'," 
				+ "iso3 = '" +  datos.getPai_iso3() + "'," + "latitud = '" + datos.getPai_latitud() + "'"
			    + "longitud = '" +  datos.getPai_longitud() + "'," + "codpostal = '" + datos.getPai_codpostal() + "'"
				+ " WHERE idpais = " + datos.getPai_idpais() + " ";
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
		String sql = "Delete from  pais " + " WHERE idpais = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Pais buscarRegistroNombre(Pais datos) throws Exception {
		String sql = "select * from pais where nombre = " + datos.getPai_nombre() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Pais dato = new Pais();
		while (resulSelect.next()) {

			dato.setPai_idpais(resulSelect.getInt("idpais"));
			dato.setPai_nombre(resulSelect.getString("nombre"));
			dato.setPai_cod_oficial_iso(resulSelect.getString("cod_oficial_iso"));
			dato.setPai_iso2(resulSelect.getString("iso2"));
			dato.setPai_iso3(resulSelect.getString("iso3"));
			dato.setPai_latitud(resulSelect.getString("latitud"));
			dato.setPai_longitud(resulSelect.getString("longitud"));
			dato.setPai_codpostal(resulSelect.getString("codpostal"));

		}

		return dato;
	}

}
