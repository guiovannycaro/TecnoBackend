package com.tecno.dominio.modelo;


import java.io.Serializable;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Perfil", description = "Esta clase se encarga del manejo de los Perfil del sistema")
public class Perfil implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "per_id", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer per_id;
	@ApiModelProperty(value = "per_decripcion", required = true, dataType = "String", example = "0000", position = 2)
	String  per_decripcion;
	@ApiModelProperty(value = "per_estado", required = true, dataType = "Boolean", example = "0000", position = 3)
	Boolean  per_estado;
	
	public Perfil(Integer per_id, String per_decripcion, Boolean per_estado) {
		this.per_id = per_id;
		this.per_decripcion = per_decripcion;
		this.per_estado = per_estado;
	}
	
	public Perfil() {
		
	}

	public Integer getPer_id() {
		return per_id;
	}

	public void setPer_id(Integer per_id) {
		this.per_id = per_id;
	}

	public String getPer_decripcion() {
		return per_decripcion;
	}

	public void setPer_decripcion(String per_decripcion) {
		this.per_decripcion = per_decripcion;
	}

	public Boolean getPer_estado() {
		return per_estado;
	}

	public void setPer_estado(Boolean per_estado) {
		this.per_estado = per_estado;
	}

	@Override
	public String toString() {
		return "Perfil [per_id=" + per_id + ", per_decripcion=" + per_decripcion + ", per_estado=" + per_estado + "]";
	}
	
	
	
	
}
