package com.tecno.aplicacion.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tecno.dominio.modelo.Commic;
import com.tecno.dominio.modelo.Commic_Genero;
import com.tecno.dominio.modelo.Generos;
import com.tecno.dominio.modelo.Respuesta;
import com.tecno.infraestructura.interfases.CommicDao;
import com.tecno.infraestructura.interfases.Commic_generoDao;
import com.tecno.infraestructura.util.executeQueryBD;

public class CommicgeneroDaoImpl implements Commic_generoDao{

	

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	
	@Override
	public List<Commic_Genero> devolverTodos() throws Exception {
		ArrayList<Commic_Genero> list = new ArrayList<>();
		String sql = "select * from genero_commic";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Commic_Genero dato = new Commic_Genero();
			dato.setComgen_idcomgen(resulSelect.getInt("idgc"));
			dato.setComgen_commic(resulSelect.getInt("idcommic"));
			dato.setComgen_genero(resulSelect.getInt("idgenero"));
		
			list.add(dato);
		}
		return list;
	}

	@Override
	public List<Commic>  buscarRegistroPorId(int id) throws Exception {
		ArrayList<Commic> list = new ArrayList<>();
		String sql = " select "
				+" commic.idcommic,commic.nombre,commic.fechapublic,commic.escritor,commic.dibujante,"
				+" commic.artportada,commic.descripcion,commic.imagen,commic.is_activo"
				+" from genero_commic "
				+" join genero on genero_commic.idgenero = genero.idgenero"
				+" join commic on genero_commic.idcommic = commic.idcommic"
				+" where genero.idgenero = " + id + " ";
		
		
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
	
	
	public List<Generos>  obtRegistroPorNombreById(int id)  throws Exception{
		ArrayList<Generos> list = new ArrayList<>();

		String sql = " select "
				+" * "
				+" from genero "
				+" where idgenero = " + id + " ";
System.out.println(sql);
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
	public String agregarRegistro(Commic_Genero datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();
		boolean rpt;
		String sql = "insert into  genero_commic (idcommic,idgenero ) "
				+ "values(" + datos.getComgen_commic()+ ",'" + datos.getComgen_genero() + "'"
			
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
	public String actualizarRegistros(Commic_Genero datos) throws Exception {
		Gson gson = new Gson();
		Respuesta respuesta = new Respuesta();

		String sql = "Update   genero_commic SET " + "idcommic = '" + datos.getComgen_commic() + "'," + "idgenero = '"
				+ datos.getComgen_genero() + "'" 
				+ " WHERE idperfil = " + datos.getComgen_idcomgen() + " ";
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
		String sql = "Delete from  genero_commic " + " WHERE idgc = " + id + " ";
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			respuesta = new Respuesta("200", "Mensaje Informativo", "El registro fue eliminado De Manera Correcta");
		} else {
			respuesta = new Respuesta("500", "Mensaje Informativo", "El registro no fue eliminado De Manera Correcta");
		}
		return gson.toJson(respuesta);
	}

	@Override
	public Commic_Genero buscarRegistroNombre(Commic_Genero datos) throws Exception {
		String sql = "select * from genero_commic where idgenero = " + datos.getComgen_genero() + " ";
		System.err.println(sql);
		resulSelect = query.executeSelectBd(sql);

		Commic_Genero dato = new Commic_Genero();
		while (resulSelect.next()) {

			dato.setComgen_idcomgen(resulSelect.getInt("idgc"));
			dato.setComgen_commic(resulSelect.getInt("idcommic"));
			dato.setComgen_genero(resulSelect.getInt("idgenero"));
		

		}

		return dato;
	}

}
