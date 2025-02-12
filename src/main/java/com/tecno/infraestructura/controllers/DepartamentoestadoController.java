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

import com.tecno.aplicacion.dao.impl.DepartamentoEstadoDaoImpl;
import com.tecno.dominio.modelo.Departamentoestado;
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
@RequestMapping("/tecno/AppAdmin/Departamentos")
@Api(value = "Administracion de Departamentos")
public class DepartamentoestadoController {

	protected final Log log = LogFactory.getLog(this.getClass());
	protected final DepartamentoEstadoDaoImpl servicio = new DepartamentoEstadoDaoImpl();

	@GetMapping(value = "/ListarDepartamentos")
	public List<Departamentoestado> listaDepartamentoestado() {
		try {
			return servicio.devolverTodos();
		} catch (Exception er) {

			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/ListarDepartamentosById", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista de registros por Id ", response = Departamentoestado.class, notes = "listar")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se lista de manera correcta", response = Departamentoestado.class),
			@ApiResponse(code = 400, message = "Bad Request.El  registro Esta Mal Digitado(String)", response = Departamentoestado.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Departamentoestado.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Departamentoestado.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Departamentoestado.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Departamentoestado.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Departamentoestado", required = true, paramType = "query", dataType = "Object", value = "Objeto") })
	public Departamentoestado ListarDepartamentoestadoById(
			@ApiParam(name = "Departamentoestado", value = "Recibe el parametro", required = true) @RequestParam Integer id) {
		Departamentoestado u = new Departamentoestado();
		try {

			return u = servicio.buscarRegistroPorId(id);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return u;
		}
	}

	@PostMapping(value = "/CrearDepartamento", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Creacion de registros", response = Departamentoestado.class, notes = "Creacion")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Departamentoestado.class),
			@ApiResponse(code = 400, message = "Bad Request.El registro Ingresado Esta Mal Digitado(String)", response = Departamentoestado.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Departamentoestado.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Departamentoestado.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Departamentoestado.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Departamentoestado.class), })

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Departamentoestado", required = true, paramType = "query", dataType = "Object", value = "Objeto"), })

	public String crearDepartamentoestado(
			@ApiParam(name = "Departamentoestado", value = "Recibe el objeto", required = true) @RequestBody Departamentoestado u) {
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
	
	@PostMapping(value = "/ActualizarDepartamentos", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Editar de registros", response = Departamentoestado.class, notes = "Creacion")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se edito  de manera correcta", response = Departamentoestado.class),
			@ApiResponse(code = 400, message = "Bad Request.El registro Ingresado Esta Mal Digitado(String)", response = Departamentoestado.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Departamentoestado.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Departamentoestado.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Departamentoestado.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Departamentoestado.class), })

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Departamentoestado", required = true, paramType = "query", dataType = "Object", value = "Objeto"), })

	public String editarDepartamentoestado(
			@ApiParam(name = "Departamentoestado", value = "Recibe el objeto", required = true) @RequestBody Departamentoestado u) {
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

	@GetMapping(value = "/EliminarDepartamento", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminacio de registros por Id ", response = Departamentoestado.class, notes = "Elimina")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se elimina  de manera correcta", response = Departamentoestado.class),
			@ApiResponse(code = 400, message = "Bad Request.El registro Ingresado Esta Mal Digitado(String)", response = Departamentoestado.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Departamentoestado.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Departamentoestado.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Departamentoestado.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Departamentoestado.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Departamentoestado", required = true, paramType = "query", dataType = "Integer", value = "parametro" ) })
	public String EliminarDepartamentoestadoById(
			@ApiParam(name = "Departamentoestado", value = "Recibe el parametro", required = true) @RequestParam Integer id) {
		String u = null;
		try {

			return u = servicio.eliminarRegistro(id);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return u;
		}
	}
}
