package com.tecno.infraestructura.seguridad.controllers;

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

import com.tecno.aplicacion.dao.impl.ServicioSeguridadImpl;
import com.tecno.dominio.modelo.Generos;
import com.tecno.dominio.modelo.Perfil;
import com.tecno.dominio.modelo.Persona;
import com.tecno.dominio.modelo.Usuarios;
import com.tecno.infraestructura.util.ExceptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tecno/AppAdmin/Seguridad")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Administracion de la Seguridad")
public class SrevicioSeguridadController {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	protected final ServicioSeguridadImpl servicio =new ServicioSeguridadImpl();


	@PostMapping(value = "/Autenticacion", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "autenticacion de usuarios ", response = Usuarios.class, notes = "Autenticacion")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se lista de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El  registro Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Usuarios.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Objeto") })
	public boolean autenticacion(
			@ApiParam(name = "Usuarios", value = "Recibe el parametro", required = true) @RequestBody Usuarios u) {
		try {

			return  servicio.autenticacion(u);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return false;
		}
	}
	
	@CrossOrigin(origins = {"http://localhost:4200/"} )
	@GetMapping(value = "/ObtenerPerfil", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "obtener Perfil ", response = Perfil.class, notes = "Perfil")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se lista de manera correcta", response = Perfil.class),
			@ApiResponse(code = 400, message = "Bad Request.El  registro Esta Mal Digitado(String)", response = Perfil.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Perfil.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Perfil.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Perfil.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Perfil.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Perfil", required = true, paramType = "query", dataType = "Object", value = "Objeto") })
	public List<Perfil> getPerfil(
			@ApiParam(name = "Perfil", value = "Recibe el parametro", required = true) @RequestParam String d) {
		try {

			return  servicio.getRoles(d);
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	@CrossOrigin(origins = {"http://localhost:4200/"} )
	@GetMapping(value = "/ObtNombreUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Obtener Nombre Usuario ", response = Persona.class, notes = "Nombre Usuario")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se lista de manera correcta", response = Persona.class),
			@ApiResponse(code = 400, message = "Bad Request.El  registro Esta Mal Digitado(String)", response = Persona.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Persona.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Persona.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Persona.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Persona.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Persona", required = true, paramType = "query", dataType = "Object", value = "Objeto") })
	public Persona obtenerNombreUsuario(
			
			@ApiParam(name = "Persona", value = "Recibe el parametro", required = true) @RequestBody Usuarios u) {
		Persona p = new Persona();
		try {
			
			p = servicio.getUserName(u);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			
		}
		return p;
	}
	@CrossOrigin(origins = {"http://localhost:4200/"} )
	@PostMapping(value = "/CambiarContrasena", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cambiar Contrasena ", response = Usuarios.class, notes = "Autenticacion")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se lista de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El  registro Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese registro", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese registro", response = Usuarios.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Objeto") })
	public String cambiarContrasena(
			@ApiParam(name = "Usuarios", value = "Recibe el parametro", required = true) @RequestBody Usuarios u) {
		String mensaje = "";
		try {

			mensaje = servicio.cambiarPassword(u);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			mensaje = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"La contrasena no fue actualizada De Manera Correcta\"}";
		}
		
		return mensaje;
	}
}
