package com.tecno.dominio.modelo;


import java.io.Serializable;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Generos", description = "Esta clase se encarga de manejar los mensajes de Generos del sistema")
public class Commic   implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "com_id", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer com_id;
	@ApiModelProperty(value = "com_nombre", required = true, dataType = "String", example = "0000", position = 2)
	String  com_nombre;
	@ApiModelProperty(value = "com_fechaPublicacion", required = true, dataType = "String", example = "0000", position = 3)
	String  com_fechaPublicacion;
	@ApiModelProperty(value = "com_escritor", required = true, dataType = "String", example = "0000", position = 4)
	String  com_escritor;
	@ApiModelProperty(value = "com_dibujante", required = true, dataType = "String", example = "0000", position = 5)
	String  com_dibujante;
	@ApiModelProperty(value = "com_artportada", required = true, dataType = "String", example = "0000", position = 6)
	String  com_artportada;
	@ApiModelProperty(value = "com_descripcion", required = true, dataType = "String", example = "0000", position = 7)
	String  com_descripcion;
	@ApiModelProperty(value = "com_imagen", required = true, dataType = "String", example = "0000", position = 8)
	String  com_imagen;
	@ApiModelProperty(value = "com_estado", required = true, dataType = "String", example = "0000", position = 9)
	Boolean  com_estado;
	
	public Commic(Integer com_id, String com_nombre, String com_fechaPublicacion, String com_escritor,
			String com_dibujante, String com_artportada, String com_descripcion, String com_imagen, Boolean com_estado) {
		this.com_id = com_id;
		this.com_nombre = com_nombre;
		this.com_fechaPublicacion = com_fechaPublicacion;
		this.com_escritor = com_escritor;
		this.com_dibujante = com_dibujante;
		this.com_artportada = com_artportada;
		this.com_descripcion = com_descripcion;
		this.com_imagen = com_imagen;
		this.com_estado = com_estado;
	}
	
	public Commic() {

	}

	public Integer getCom_id() {
		return com_id;
	}

	public void setCom_id(Integer com_id) {
		this.com_id = com_id;
	}

	public String getCom_nombre() {
		return com_nombre;
	}

	public void setCom_nombre(String com_nombre) {
		this.com_nombre = com_nombre;
	}

	public String getCom_fechaPublicacion() {
		return com_fechaPublicacion;
	}

	public void setCom_fechaPublicacion(String com_fechaPublicacion) {
		this.com_fechaPublicacion = com_fechaPublicacion;
	}

	public String getCom_escritor() {
		return com_escritor;
	}

	public void setCom_escritor(String com_escritor) {
		this.com_escritor = com_escritor;
	}

	public String getCom_dibujante() {
		return com_dibujante;
	}

	public void setCom_dibujante(String com_dibujante) {
		this.com_dibujante = com_dibujante;
	}

	public String getCom_artportada() {
		return com_artportada;
	}

	public void setCom_artportada(String com_artportada) {
		this.com_artportada = com_artportada;
	}

	public String getCom_descripcion() {
		return com_descripcion;
	}

	public void setCom_descripcion(String com_descripcion) {
		this.com_descripcion = com_descripcion;
	}

	public String getCom_imagen() {
		return com_imagen;
	}

	public void setCom_imagen(String com_imagen) {
		this.com_imagen = com_imagen;
	}

	public Boolean getCom_estado() {
		return com_estado;
	}

	public void setCom_estado(Boolean com_estado) {
		this.com_estado = com_estado;
	}

	@Override
	public String toString() {
		return "Commic [com_id=" + com_id + ", com_nombre=" + com_nombre + ", com_fechaPublicacion="
				+ com_fechaPublicacion + ", com_escritor=" + com_escritor + ", com_dibujante=" + com_dibujante
				+ ", com_artportada=" + com_artportada + ", com_descripcion=" + com_descripcion + ", com_imagen="
				+ com_imagen + ", com_estado=" + com_estado + "]";
	}
	
	
	

}
