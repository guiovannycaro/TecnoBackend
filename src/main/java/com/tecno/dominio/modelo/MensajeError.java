package com.tecno.dominio.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Mensaje Error", description = "Esta clase se encarga de manejar los mensajes de error del sistema")
public class MensajeError {
	@ApiModelProperty(value = "codigo", required = true, dataType = "String", example = "0000", position = 1)
	String codigo;
	@ApiModelProperty(value = "mensaje", required = true, dataType = "String", example = "0000", position = 2)
	String mensaje;
	@ApiModelProperty(value = "descripcion", required = true, dataType = "String", example = "0000", position = 3)
	String descripcion;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

