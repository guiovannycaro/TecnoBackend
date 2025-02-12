package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Departamentoestado;

import com.tecno.dominio.modelo.Respuesta;
import com.tecno.infraestructura.interfases.DepartamentoestadoDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class DepartamentoEstadoDaoImpl implements DepartamentoestadoDao{

	
	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	 
	@Override
	public List<Departamentoestado> devolverTodos() throws Exception {
		ArrayList<Departamentoestado> list = new ArrayList<>();
		String sql = "select * from departamentoestado";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Departamentoestado dato = new Departamentoestado();
			dato.setDep_iddepartamento(resulSelect.getInt("iddepartamento"));
			dato.setDep_pais(resulSelect.getInt("idpais"));
			dato.setDep_codoficial(resulSelect.getString("codoficial"));
			dato.setDep_nombre(resulSelect.getString("nombre"));
			dato.setDep_latitud(resulSelect.getString("latitud"));
			dato.setDep_longitud(resulSelect.getString("longitud"));
			list.add(dato);
		}
		return list;
	}

	@Override
	public Departamentoestado buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from departamentoestado where iddepartamento = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Departamentoestado dato = new Departamentoestado();
		while (resulSelect.next()) {

			dato.setDep_iddepartamento(resulSelect.getInt("iddepartamento"));
			dato.setDep_pais(resulSelect.getInt("idpais"));
			dato.setDep_codoficial(resulSelect.getString("codoficial"));
			dato.setDep_nombre(resulSelect.getString("nombre"));
			dato.setDep_latitud(resulSelect.getString("latitud"));
			dato.setDep_longitud(resulSelect.getString("longitud"));

		}

		return dato;
	}

	@Override
	public String agregarRegistro(Departamentoestado datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  departamentoestado (idpais,codoficial,nombre,latitud,longitud" + ") "
				+ "values(" + datos.getDep_pais() + ",'" + datos.getDep_codoficial() + "','"
				+ datos.getDep_nombre() + "'," + "'" + datos.getDep_latitud() + "',"
				+ "'" + datos.getDep_longitud() + "'"
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
	public String actualizarRegistros(Departamentoestado datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   departamentoestado SET " + "idpais = '" + datos.getDep_pais() + "'," 
		        + "codoficial = '" + datos.getDep_codoficial() + "'," + "nombre = '" + datos.getDep_nombre() + "'," 
		        + "latitud = '" + datos.getDep_latitud() + "'," + "longitud = '" + datos.getDep_longitud() + "'" 
				+ " WHERE iddepartamento = " + datos.getDep_iddepartamento() + " ";
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
		String sql = "Delete from  departamentoestado " + " WHERE iddepartamento = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Departamentoestado buscarRegistroNombre(Departamentoestado datos) throws Exception {
		String sql = "select * from departamentoestado where nombre = " + datos.getDep_nombre() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Departamentoestado dato = new Departamentoestado();
		while (resulSelect.next()) {

			dato.setDep_iddepartamento(resulSelect.getInt("iddepartamento"));
			dato.setDep_pais(resulSelect.getInt("idpais"));
			dato.setDep_codoficial(resulSelect.getString("codoficial"));
			dato.setDep_nombre(resulSelect.getString("nombre"));
			dato.setDep_latitud(resulSelect.getString("latitud"));
			dato.setDep_longitud(resulSelect.getString("longitud"));


		}

		return dato;
	}




}
