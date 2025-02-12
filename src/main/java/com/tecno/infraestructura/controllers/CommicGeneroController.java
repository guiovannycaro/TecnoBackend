package com.tecno.infraestructura.controllers;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecno.aplicacion.dao.impl.CommicgeneroDaoImpl;
import com.tecno.dominio.modelo.Commic;
import com.tecno.dominio.modelo.Commic_Genero;
import com.tecno.dominio.modelo.Generos;
import com.tecno.infraestructura.util.ExceptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tecno/AppAdmin/CommicGenero")
@Api(value = "Administracion de Commic  Genero")
public class CommicGeneroController {


	protected final Log log = LogFactory.getLog(this.getClass());
	protected final CommicgeneroDaoImpl servicio = new CommicgeneroDaoImpl();

	@GetMapping(value = "/ListarCommicGenero")
	public List<Commic_Genero> listaCommic() {
		try {
			return servicio.devolverTodos();
		} catch (Exception er) {

			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/ListarCommicGeneroById", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista de registros por Id ", response = Commic_Genero.class, notes = "listar")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se lista de manera correcta", response = Commic_Genero.class),
			@ApiResponse(code = 400, message = "Bad Request.El  registro Esta Mal Digitado(String)", response = Commic_Genero.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Commic_Genero.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Commic_Genero.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Commic_Genero", required = true, paramType = "query", dataType = "Object", value = "Objeto") })
	public List<Commic> ListarCommicGeneroById(
			@ApiParam(name = "Commic_Genero", value = "Recibe el parametro", required = true) @RequestParam String id) {
	
		try {
System.out.println("viene del front " + id);
			return  servicio.buscarRegistroPorId(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}
	
	
	@GetMapping(value = "/obtenerNombreGeneroById", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista de registros por Id ", response = Commic_Genero.class, notes = "listar")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se lista de manera correcta", response = Commic_Genero.class),
			@ApiResponse(code = 400, message = "Bad Request.El  registro Esta Mal Digitado(String)", response = Commic_Genero.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Commic_Genero.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Commic_Genero.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Commic_Genero", required = true, paramType = "query", dataType = "Object", value = "Objeto") })
	public List<Generos> obtenerNombreGeneroById(
			@ApiParam(name = "Commic_Genero", value = "Recibe el parametro", required = true) @RequestParam String id) {
		
		try {
		
System.out.println("viene del front " + id);
			return  servicio.obtRegistroPorNombreById(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/CrearCommicGenero", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Creacion de registros", response = Commic_Genero.class, notes = "Creacion")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Commic_Genero.class),
			@ApiResponse(code = 400, message = "Bad Request.El registro Ingresado Esta Mal Digitado(String)", response = Commic_Genero.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Commic_Genero.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Commic_Genero.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class), })

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Commic_Genero", required = true, paramType = "query", dataType = "Object", value = "Objeto"), })

	public String crearDepartamentoestado(
			@ApiParam(name = "Commic_Genero", value = "Recibe el objeto", required = true) @RequestBody Commic_Genero u) {
		String mensaje = "";
		try {
			mensaje = servicio.agregarRegistro(u);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			System.err.println("Se ha generado un error  :  " + e.getMessage());
			mensaje = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return mensaje;
	}
	
	@PostMapping(value = "/ActualizarCommicGenero", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Editar de registros", response = Commic_Genero.class, notes = "Creacion")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se edito  de manera correcta", response = Commic_Genero.class),
			@ApiResponse(code = 400, message = "Bad Request.El registro Ingresado Esta Mal Digitado(String)", response = Commic_Genero.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Commic_Genero.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Commic_Genero.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class), })

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Commic_Genero", required = true, paramType = "query", dataType = "Object", value = "Objeto"), })

	public String editarCommicGenero(
			@ApiParam(name = "Commic_Genero", value = "Recibe el objeto", required = true) @RequestBody Commic_Genero u) {
		String mensaje = "";
		try {
			mensaje = servicio.actualizarRegistros(u);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			System.err.println("Se ha generado un error  :  " + e.getMessage());
			mensaje = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
		return mensaje;
	}

	@GetMapping(value = "/EliminarCommicGenero", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminacio de registros por Id ", response = Commic_Genero.class, notes = "Elimina")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se elimina  de manera correcta", response = Commic_Genero.class),
			@ApiResponse(code = 400, message = "Bad Request.El registro Ingresado Esta Mal Digitado(String)", response = Commic_Genero.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Commic_Genero.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Commic_Genero.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Commic_Genero.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Commic_Genero", required = true, paramType = "query", dataType = "Integer", value = "parametro" ) })
	public String EliminarCommicGeneroById(
			@ApiParam(name = "Commic_Genero", value = "Recibe el parametro", required = true) @RequestParam Integer id) {
		String u = null;
		try {

			return u = servicio.eliminarRegistro(id);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return u;
		}
	}
}
