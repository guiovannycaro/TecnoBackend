package com.tecno.dominio.modelo;


import java.io.Serializable;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Commic_Genero", description = "Esta clase se encarga de manejar los mensajes de Commic_Genero del sistema")
public class Commic_Genero   implements Serializable{
	
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "comgen_idcomgen", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer comgen_idcomgen;
	
	@ApiModelProperty(value = "comgen_commic", required = true, dataType = "Integer", example = "0000", position = 2)
	Integer comgen_commic;
	@ApiModelProperty(value = "comgen_genero", required = true, dataType = "Integer", example = "0000", position = 3)
	Integer comgen_genero;
	
	public Commic_Genero(Integer comgen_idcomgen, Integer comgen_commic, Integer comgen_genero) {
		super();
		this.comgen_idcomgen = comgen_idcomgen;
		this.comgen_commic = comgen_commic;
		this.comgen_genero = comgen_genero;
	}
	
	public Commic_Genero() {

	}

	public Integer getComgen_idcomgen() {
		return comgen_idcomgen;
	}

	public void setComgen_idcomgen(Integer comgen_idcomgen) {
		this.comgen_idcomgen = comgen_idcomgen;
	}

	public Integer getComgen_commic() {
		return comgen_commic;
	}

	public void setComgen_commic(Integer comgen_commic) {
		this.comgen_commic = comgen_commic;
	}

	public Integer getComgen_genero() {
		return comgen_genero;
	}

	public void setComgen_genero(Integer comgen_genero) {
		this.comgen_genero = comgen_genero;
	}

	@Override
	public String toString() {
		return "Commic_Genero [comgen_idcomgen=" + comgen_idcomgen + ", comgen_commic=" + comgen_commic
				+ ", comgen_genero=" + comgen_genero + "]";
	}
	
	
	

}
