package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Persona;
import com.tecno.dominio.modelo.Respuesta;

import com.tecno.infraestructura.interfases.PersonasDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class PersonasDaoImpl implements PersonasDao{

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;

	@Override
	public List<Persona> devolverTodos() throws Exception {
		ArrayList<Persona> list = new ArrayList<>();
		String sql = "select * from persona";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Persona dato = new Persona();
			dato.setPer_idpersona(resulSelect.getInt("idpersona"));
			dato.setPer_nombres(resulSelect.getString("nombres"));
			dato.setPer_apellidos(resulSelect.getString("apellidos"));
			dato.setPer_idtipodocumento(resulSelect.getInt("idtipodocumento"));
			dato.setPer_numdocumento(resulSelect.getString("numdocumento"));
			dato.setPer_numtelefono(resulSelect.getString("num_telefono"));
			dato.setPer_email(resulSelect.getString("email"));
			dato.setPer_direccion(resulSelect.getString("direccion"));
			dato.setPer_idciudad(resulSelect.getInt("idciudad"));
			
			list.add(dato);
		}
		return list;
	}

	@Override
	public Persona buscarRegistroPorId(int id) throws Exception {
		String sql = "select * from persona where idpersona = " + id + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Persona dato = new Persona();
		while (resulSelect.next()) {


			dato.setPer_idpersona(resulSelect.getInt("idpersona"));
			dato.setPer_nombres(resulSelect.getString("nombres"));
			dato.setPer_apellidos(resulSelect.getString("apellidos"));
			dato.setPer_idtipodocumento(resulSelect.getInt("idtipodocumento"));
			dato.setPer_numdocumento(resulSelect.getString("numdocumento"));
			dato.setPer_numtelefono(resulSelect.getString("num_telefono"));
			dato.setPer_email(resulSelect.getString("email"));
			dato.setPer_direccion(resulSelect.getString("direccion"));
			dato.setPer_idciudad(resulSelect.getInt("idciudad"));

		}

		return dato;
	}

	@Override
	public String agregarRegistro(Persona datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  persona (nombres,apellidos,idtipodocumento,num_telefono,email,direccion,idciudad" + ") "
				+ "values(" + datos.getPer_nombres() + ",'" + datos.getPer_apellidos() + "'"
				+ ",'" + datos.getPer_idtipodocumento() + "'," + "'" + datos.getPer_numtelefono() + "',"
				+ ",'" + datos.getPer_email() + "'," + "'" + datos.getPer_direccion() + "'"
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
	public String actualizarRegistros(Persona datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   persona SET " + "nombres = '" + datos.getPer_nombres() + "'," + "apellidos = '"
				+ datos.getPer_apellidos() + "'," + "idtipodocumento = '" + datos.getPer_idtipodocumento() + "'," 
				+ "numdocumento = '" +  datos.getPer_numdocumento() + "'," + "num_telefono = '" + datos.getPer_numtelefono() + "'"
			    + "email = '" +  datos.getPer_email() + "'," + "direccion = '" + datos.getPer_direccion() + "'"
			     + "idciudad = '" +  datos.getPer_idciudad() + "'"
				+ " WHERE idpersona = " + datos.getPer_idpersona() + " ";
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
		String sql = "Delete from  persona " + " WHERE idpersona = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Persona buscarRegistroNombre(Persona datos) throws Exception {
		String sql = "select * from persona where nombres = " + datos.getPer_nombres() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Persona dato = new Persona();
		while (resulSelect.next()) {

			dato.setPer_idpersona(resulSelect.getInt("idpersona"));
			dato.setPer_nombres(resulSelect.getString("nombres"));
			dato.setPer_apellidos(resulSelect.getString("apellidos"));
			dato.setPer_idtipodocumento(resulSelect.getInt("idtipodocumento"));
			dato.setPer_numdocumento(resulSelect.getString("numdocumento"));
			dato.setPer_numtelefono(resulSelect.getString("num_telefono"));
			dato.setPer_email(resulSelect.getString("email"));
			dato.setPer_direccion(resulSelect.getString("direccion"));
			dato.setPer_idciudad(resulSelect.getInt("idciudad"));

		}

		return dato;
	}

}
