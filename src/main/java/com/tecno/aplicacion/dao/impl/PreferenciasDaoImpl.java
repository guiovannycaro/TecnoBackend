package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Generos;
import com.tecno.dominio.modelo.Preferencias;
import com.tecno.dominio.modelo.Respuesta;
import com.tecno.dominio.modelo.TipoDocumento;
import com.tecno.infraestructura.interfases.PreferenciasDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class PreferenciasDaoImpl implements PreferenciasDao{

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	 
	@Override
	public List<Generos> devolverTodos() throws Exception {
		ArrayList<Generos> list = new ArrayList<>();
		
		String sql = " select genero.idgenero,genero.nombre,"
		+ " genero.descripcion,genero.imagen,genero.is_activo" 
		+ " from preferencias"
		+" join genero on preferencias.idgenero = genero.idgenero"
		+" join genero_commic on genero.idgenero = genero_commic.idgenero"
		+ " group by preferencias.idgenero,genero.idgenero,genero.nombre,"
		+ " genero.descripcion,genero.imagen,genero.is_activo"; 
		
		
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
	public Preferencias buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from preferencias where idpreferencia = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Preferencias dato = new Preferencias();
		while (resulSelect.next()) {

			dato.setPre_idpreferencia(resulSelect.getInt("idpreferencia"));
			dato.setPre_persona(resulSelect.getInt("idpersona"));
			dato.setPre_genero(resulSelect.getInt("idgenero"));
			dato.setPre_idcommic(resulSelect.getInt("idcommic"));
			dato.setPre_estado(Boolean.parseBoolean(resulSelect.getString("estado")));

		}

		return dato;
	}

	@Override
	public String agregarRegistro(Preferencias datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  preferencias (idpersona,idgenero,idcommic,estado" + ") "
				+ "values(" + datos.getPre_persona() + ",'" + datos.getPre_genero() + "','"
				+ datos.getPre_idcommic() + "'," + "'" + datos.getPre_estado() + "'"
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
	public String actualizarRegistros(Preferencias datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   preferencias SET " + "idpersona = '" + datos.getPre_persona() + "'," + "idgenero = '"
				+ datos.getPre_genero() + "'," + "idcommic = '" + datos.getPre_idcommic() + "'," + "estado = '"
				+ datos.getPre_estado() + "'"
				+ " WHERE idpreferencia = " + datos.getPre_idpreferencia() + " ";
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
		String sql = "Delete from  preferencias " + " WHERE idpreferencia = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Preferencias buscarRegistroNombre(Preferencias datos) throws Exception {
		String sql = "select * from preferencias where username = " + datos.getPre_idpreferencia() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Preferencias dato = new Preferencias();
		while (resulSelect.next()) {

			dato.setPre_idpreferencia(resulSelect.getInt("idpreferencia"));
			dato.setPre_persona(resulSelect.getInt("idpersona"));
			dato.setPre_genero(resulSelect.getInt("idgenero"));
			dato.setPre_idcommic(resulSelect.getInt("idcommic"));
			dato.setPre_estado(Boolean.parseBoolean(resulSelect.getString("estado")));

		}

		return dato;
	}

}
