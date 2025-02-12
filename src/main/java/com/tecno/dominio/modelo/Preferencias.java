package com.tecno.dominio.modelo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Preferencias", description = "Esta clase se encarga del manejo de los Preferencias del sistema")
public class Preferencias implements Serializable {

	private static final long serialVersionUID = -5577579081118070434L;

	@ApiModelProperty(value = "pre_idpreferencia", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer pre_idpreferencia;

	@ApiModelProperty(value = "pre_persona", required = true, dataType = "Integer", example = "0000", position = 2)
	Integer pre_persona;

	@ApiModelProperty(value = "pre_genero", required = true, dataType = "Integer", example = "0000", position = 3)
	Integer pre_genero;

	@ApiModelProperty(value = "pre_idcommic", required = true, dataType = "Integer", example = "0000", position = 4)
	Integer pre_idcommic;

	@ApiModelProperty(value = "pre_estado", required = true, dataType = "String", example = "0000", position = 5)
	Boolean pre_estado;
	
	
	

	public Preferencias(Integer pre_idpreferencia, Integer pre_persona, Integer pre_genero, Integer pre_idcommic,
			Boolean pre_estado) {
		this.pre_idpreferencia = pre_idpreferencia;
		this.pre_persona = pre_persona;
		this.pre_genero = pre_genero;
		this.pre_idcommic = pre_idcommic;
		this.pre_estado = pre_estado;
	}
	
	
	

	public Preferencias() {
	
	}




	public Integer getPre_idpreferencia() {
		return pre_idpreferencia;
	}

	public void setPre_idpreferencia(Integer pre_idpreferencia) {
		this.pre_idpreferencia = pre_idpreferencia;
	}

	public Integer getPre_persona() {
		return pre_persona;
	}

	public void setPre_persona(Integer pre_persona) {
		this.pre_persona = pre_persona;
	}

	public Integer getPre_genero() {
		return pre_genero;
	}

	public void setPre_genero(Integer pre_genero) {
		this.pre_genero = pre_genero;
	}

	public Integer getPre_idcommic() {
		return pre_idcommic;
	}

	public void setPre_idcommic(Integer pre_idcommic) {
		this.pre_idcommic = pre_idcommic;
	}

	public Boolean getPre_estado() {
		return pre_estado;
	}

	public void setPre_estado(Boolean pre_estado) {
		this.pre_estado = pre_estado;
	}

	@Override
	public String toString() {
		return "Preferencias [pre_idpreferencia=" + pre_idpreferencia + ", pre_persona=" + pre_persona + ", pre_genero="
				+ pre_genero + ", pre_idcommic=" + pre_idcommic + ", pre_estado=" + pre_estado + "]";
	}

	
}
