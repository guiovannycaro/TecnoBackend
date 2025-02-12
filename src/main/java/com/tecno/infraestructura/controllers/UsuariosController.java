package com.tecno.infraestructura.controllers;

import java.util.List;
import com.tecno.aplicacion.dao.impl.UsuariosDaoImpl;
import com.tecno.dominio.modelo.Usuarios;
import java.util.Collections;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import com.tecno.infraestructura.util.ExceptionUtil;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tecno/AppAdmin/Usuarios")
@Api(value = "Administracion de Usuarios")
public class UsuariosController {

	protected final Log log = LogFactory.getLog(this.getClass());
	protected final UsuariosDaoImpl servicio = new UsuariosDaoImpl();

	@GetMapping(value = "/ListarUsuarios")
	public List<Usuarios> listaDependencias() {
		try {
			return servicio.devolverTodos();
		} catch (Exception er) {

			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/ListarUsuariosById", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista de Usuarios por Id ", response = Usuarios.class, notes = "Crea un nuevo telefono")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = Usuarios.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = "{\r\n"
					+ "\"\"id\":xxx\r\n" + "}"), })
	public Usuarios ListarUsuariosById(
			@ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true) @RequestParam Integer id) {
		Usuarios u = new Usuarios();
		try {

			return u = servicio.buscarRegistroPorId(id);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return u;
		}
	}

	@PostMapping(value = "/CrearUsuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Creacion de Usuarios", response = Usuarios.class, notes = "Crea un nuevo telefono")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = Usuarios.class), })

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = "{\r\n"
					+ "\"\"USU_ID\":xxx,\r\n" + "\"USU_NOMBRES\": \"xxx\",\r\n" + "\"USU_DIRECCION\": \"xxx\",\r\n"
					+ "\"USU_TELEFONO\":\"xxx\",\r\n" + "\"USU_CORREO\":\"xxxx\",\r\n"
					+ "\"USU_NUMDOCUMENTO\":\"xxxx\",\r\n" + "\"USU_PASSWORD\":\"xxxx\",\r\n"
					+ "\"USU_TDOC_ID\":\"xxxx\",\r\n" + "\"USU_ROL_ID\":\"xxxx\",\r\n" + "\"USU_ESTADO\": xxx \r\n"
					+ "}"), })

	public String crearUsuario(
			@ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true) @RequestBody Usuarios u) {
		String mensaje = "";
		try {
			mensaje = servicio.agregarRegistro(u);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			System.err.println("Se ha generado un error  :  " + e.getMessage());
			mensaje = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
		return mensaje;
	}
	
	
	@PostMapping(value = "/ActualizarUsuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Creacion de Usuarios", response = Usuarios.class, notes = "Crea un nuevo telefono")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = Usuarios.class), })

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = "{\r\n"
					+ "\"\"USU_ID\":xxx,\r\n" + "\"USU_NOMBRES\": \"xxx\",\r\n" + "\"USU_DIRECCION\": \"xxx\",\r\n"
					+ "\"USU_TELEFONO\":\"xxx\",\r\n" + "\"USU_CORREO\":\"xxxx\",\r\n"
					+ "\"USU_NUMDOCUMENTO\":\"xxxx\",\r\n" + "\"USU_PASSWORD\":\"xxxx\",\r\n"
					+ "\"USU_TDOC_ID\":\"xxxx\",\r\n" + "\"USU_ROL_ID\":\"xxxx\",\r\n" + "\"USU_ESTADO\": xxx \r\n"
					+ "}"), })

	public String actualizaUsuario(
			@ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true) @RequestBody Usuarios u) {
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

	@GetMapping(value = "/EliminarUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista de Usuarios por Id ", response = Usuarios.class, notes = "Crea un nuevo telefono")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = Usuarios.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = "{\r\n"
					+ "\"\"id\":xxx\r\n" + "}"), })
	public String EliminarUsuarioById(
			@ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true) @RequestParam Integer id) {
		String u = null;
		try {

			return u = servicio.eliminarRegistro(id);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return u;
		}
	}
}
