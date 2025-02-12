package com.tecno.dominio.modelo;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Usuarios", description = "Esta clase se encarga del manejo de los usuarios del sistema")
public class Usuarios implements Serializable{
	
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "usu_idusuario", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer usu_idusuario;
	@ApiModelProperty(value = "usu_idpersona", required = true, dataType = "Boolean", example = "0000", position = 2)
	Integer usu_idpersona;
	@ApiModelProperty(value = "usu_username", required = true, dataType = "String", example = "0000", position = 3)
	String usu_username;
	@ApiModelProperty(value = "usu_contrasena", required = true, dataType = "String", example = "0000", position = 4)
	String usu_contrasena;
	@ApiModelProperty(value = "usu_estado", required = true, dataType = "Boolean", example = "0000", position = 5)
	Boolean usu_estado;
	@ApiModelProperty(value = "usu_cambiocontrasena", required = true, dataType = "Boolean", example = "0000", position = 6)
	Boolean usu_cambiocontrasena;
	
	public Usuarios(Integer usu_idusuario, Integer usu_idpersona, String usu_username, String usu_contrasena,
			Boolean usu_estado, Boolean usu_cambiocontrasena) {
		this.usu_idusuario = usu_idusuario;
		this.usu_idpersona = usu_idpersona;
		this.usu_username = usu_username;
		this.usu_contrasena = usu_contrasena;
		this.usu_estado = usu_estado;
		this.usu_cambiocontrasena = usu_cambiocontrasena;
	}

	
	public Usuarios() {
		
	}


	public Integer getUsu_idusuario() {
		return usu_idusuario;
	}


	public void setUsu_idusuario(Integer usu_idusuario) {
		this.usu_idusuario = usu_idusuario;
	}


	public Integer getUsu_idpersona() {
		return usu_idpersona;
	}


	public void setUsu_idpersona(Integer usu_idpersona) {
		this.usu_idpersona = usu_idpersona;
	}


	public String getUsu_username() {
		return usu_username;
	}


	public void setUsu_username(String usu_username) {
		this.usu_username = usu_username;
	}


	public String getUsu_contrasena() {
		return usu_contrasena;
	}


	public void setUsu_contrasena(String usu_contrasena) {
		this.usu_contrasena = usu_contrasena;
	}


	public Boolean getUsu_estado() {
		return usu_estado;
	}


	public void setUsu_estado(Boolean usu_estado) {
		this.usu_estado = usu_estado;
	}


	public Boolean getUsu_cambiocontrasena() {
		return usu_cambiocontrasena;
	}


	public void setUsu_cambiocontrasena(Boolean usu_cambiocontrasena) {
		this.usu_cambiocontrasena = usu_cambiocontrasena;
	}


	@Override
	public String toString() {
		return "Usuarios [usu_idusuario=" + usu_idusuario + ", usu_idpersona=" + usu_idpersona + ", usu_username="
				+ usu_username + ", usu_contrasena=" + usu_contrasena + ", usu_estado=" + usu_estado
				+ ", usu_cambiocontrasena=" + usu_cambiocontrasena + "]";
	}
	
	
	
	
}
