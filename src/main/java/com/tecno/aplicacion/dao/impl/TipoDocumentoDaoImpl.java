package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Respuesta;
import com.tecno.dominio.modelo.TipoDocumento;

import com.tecno.infraestructura.interfases.TipoDocumentoDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class TipoDocumentoDaoImpl implements TipoDocumentoDao{


	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	
	@Override
	public List<TipoDocumento> devolverTodos() throws Exception {
		ArrayList<TipoDocumento> list = new ArrayList<>();
		String sql = "select * from tipodocumento";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			TipoDocumento dato = new TipoDocumento();
			dato.setTip_idtipodocumento(resulSelect.getInt("idtipodocumento"));
			dato.setTip_descripcion(resulSelect.getString("descripcion"));
			dato.setTip_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));
		
			list.add(dato);
		}
		return list;
	}

	@Override
	public TipoDocumento buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from tipodocumento where idtipodocumento = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		TipoDocumento dato = new TipoDocumento();
		while (resulSelect.next()) {

			dato.setTip_idtipodocumento(resulSelect.getInt("idtipodocumento"));
			dato.setTip_descripcion(resulSelect.getString("descripcion"));
			dato.setTip_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));

		}

		return dato;
	}

	@Override
	public String agregarRegistro(TipoDocumento datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  tipodocumento (descripcion,is_activo ) "
				+ "values(" + datos.getTip_descripcion() + ",'" + datos.getTip_estado() + "'"
			
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
	public String actualizarRegistros(TipoDocumento datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   tipodocumento SET " + "descripcion = '" + datos.getTip_descripcion() + "'," + "is_activo = '"
				+ datos.getTip_estado() + "'" 
				+ " WHERE idtipodocumento = " + datos.getTip_idtipodocumento() + " ";
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
		String sql = "Delete from  tipodocumento " + " WHERE idtipodocumento = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public TipoDocumento buscarRegistroNombre(TipoDocumento datos) throws Exception {
		String sql = "select * from tipodocumento where username = " + datos.getTip_idtipodocumento() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		TipoDocumento dato = new TipoDocumento();
		while (resulSelect.next()) {

			dato.setTip_idtipodocumento(resulSelect.getInt("idtipodocumento"));
			dato.setTip_descripcion(resulSelect.getString("descripcion"));
			dato.setTip_estado(Boolean.parseBoolean(resulSelect.getString("is_activo")));

		}

		return dato;
	}

}
