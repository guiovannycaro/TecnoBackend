package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Ciudad;

import com.tecno.dominio.modelo.Respuesta;
import com.tecno.infraestructura.interfases.CiudadDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class CiudadDaoImpl implements CiudadDao{

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;

	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	private String fechaActual = formatter.format(new Date());
	@Override
	public List<Ciudad> devolverTodos() throws Exception {
		  
		ArrayList<Ciudad> list = new ArrayList<>();
		String sql = "select * from ciudad";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Ciudad dato = new Ciudad();
			dato.setCiu_idciudad(resulSelect.getInt("idciudad"));
			dato.setCiu_nombre(resulSelect.getString("nombre"));
			dato.setCiu_codoficial(resulSelect.getString("codoficial"));
			dato.setCiu_latitud(resulSelect.getString("latitud"));
			dato.setCiu_longitud(resulSelect.getString("longitud"));
			dato.setCiu_epestado(Boolean.parseBoolean(resulSelect.getString("iddepartamento")));
			dato.setCiu_codpostal(resulSelect.getString("codpostal"));
			 String updatedAtStr = resulSelect.getString("updated_at");
			Date updatedAt = formatter.parse(updatedAtStr);
			
			dato.setUpdated_at(updatedAt);
			
			String createdAtStr = resulSelect.getString("created_at");
			Date createdAt = formatter.parse(createdAtStr);
			
			dato.setCreated_at(createdAt);
			
			list.add(dato);
		}
		return list;
	}

	@Override
	public Ciudad buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from ciudad where idciudad = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Ciudad dato = new Ciudad();
		while (resulSelect.next()) {


			dato.setCiu_idciudad(resulSelect.getInt("idciudad"));
			dato.setCiu_nombre(resulSelect.getString("nombre"));
			dato.setCiu_codoficial(resulSelect.getString("codoficial"));
			dato.setCiu_latitud(resulSelect.getString("latitud"));
			dato.setCiu_longitud(resulSelect.getString("longitud"));
			dato.setCiu_epestado(Boolean.parseBoolean(resulSelect.getString("iddepartamento")));
			dato.setCiu_codpostal(resulSelect.getString("codpostal"));
			 String updatedAtStr = resulSelect.getString("updated_at");
			Date updatedAt = formatter.parse(updatedAtStr);
			
			dato.setUpdated_at(updatedAt);
			
			String createdAtStr = resulSelect.getString("created_at");
			Date createdAt = formatter.parse(createdAtStr);
			
			dato.setCreated_at(createdAt);

		}

		return dato;
	}

	@Override
	public String agregarRegistro(Ciudad datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		fechaActual = formatter.format(new Date());
		String sql = "insert into  ciudad (nombre,codoficial,latitud,iddepartamento,codpostal,created_at" + ") "
				+ "values(" + datos.getCiu_nombre() + ",'" + datos.getCiu_codoficial() + "'"
				+ ",'" + datos.getCiu_latitud() + "'," + "'" + datos.getCiu_iddepartamento() + "',"
				+ ",'" + datos.getCiu_codpostal() + "'," + "'" + fechaActual+ "'"
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
	public String actualizarRegistros(Ciudad datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		 fechaActual = formatter.format(new Date());
		String sql = "Update   ciudad SET " + "nombre = '" + datos.getCiu_nombre() + "'," + "codoficial = '"
				+ datos.getCiu_codoficial() + "'," + "latitud = '" + datos.getCiu_latitud() + "'," 
				+ "longitud = '" +  datos.getCiu_longitud() + "'," + "iddepartamento = '" + datos.getCiu_iddepartamento() + "'"
			    + "codpostal = '" +  datos.getCiu_codpostal() + "'," + "updated_at = '" + fechaActual + "'"
				+ " WHERE idciudad = " + datos.getCiu_idciudad() + " ";
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
		String sql = "Delete from  ciudad " + " WHERE idciudad = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Ciudad buscarRegistroNombre(Ciudad datos) throws Exception {
		String sql = "select * from ciudad where nombre = " + datos.getCiu_nombre() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Ciudad dato = new Ciudad();
		while (resulSelect.next()) {

			dato.setCiu_idciudad(resulSelect.getInt("idciudad"));
			dato.setCiu_nombre(resulSelect.getString("nombre"));
			dato.setCiu_codoficial(resulSelect.getString("codoficial"));
			dato.setCiu_latitud(resulSelect.getString("latitud"));
			dato.setCiu_longitud(resulSelect.getString("longitud"));
			dato.setCiu_epestado(Boolean.parseBoolean(resulSelect.getString("iddepartamento")));
			dato.setCiu_codpostal(resulSelect.getString("codpostal"));
			 String updatedAtStr = resulSelect.getString("updated_at");
			Date updatedAt = formatter.parse(updatedAtStr);
			
			dato.setUpdated_at(updatedAt);
			
			String createdAtStr = resulSelect.getString("created_at");
			Date createdAt = formatter.parse(createdAtStr);
			
			dato.setCreated_at(createdAt);

		}

		return dato;
	}

}
