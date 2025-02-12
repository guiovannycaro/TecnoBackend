package com.tecno.infraestructura.interfases;

import java.util.List;

import com.tecno.dominio.modelo.TipoDocumento;

public interface TipoDocumentoDao {

	 List<TipoDocumento> devolverTodos()  throws Exception;
	 public TipoDocumento  buscarRegistroPorId(int id) throws Exception;
	 public String  agregarRegistro(TipoDocumento datos)  throws Exception;
	 public String actualizarRegistros(TipoDocumento datos) throws Exception;;
	
	 public String eliminarRegistro(int id) throws Exception;
	 
	 public TipoDocumento buscarRegistroNombre(TipoDocumento datos) throws Exception;
}
