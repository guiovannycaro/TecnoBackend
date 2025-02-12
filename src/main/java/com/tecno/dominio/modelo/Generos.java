package com.tecno.dominio.modelo;


import java.io.Serializable;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Generos", description = "Esta clase se encarga de manejar los mensajes de Generos del sistema")
public class Generos   implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "gen_Id", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer gen_Id;
	@ApiModelProperty(value = "gen_nombre", required = true, dataType = "String", example = "0000", position = 2)
	String  gen_nombre;
	@ApiModelProperty(value = "gen_descripcion", required = true, dataType = "String", example = "0000", position = 3)
	String  gen_descripcion;
	@ApiModelProperty(value = "gen_imagen", required = true, dataType = "String", example = "0000", position = 4)
	String  gen_imagen;
	@ApiModelProperty(value = "gen_estado", required = true, dataType = "String", example = "0000", position = 5)
	Boolean  gen_estado;
	
	public Generos(Integer gen_Id, String gen_nombre, String gen_descripcion, String gen_imagen, Boolean gen_estado) {
		this.gen_Id = gen_Id;
		this.gen_nombre = gen_nombre;
		this.gen_descripcion = gen_descripcion;
		this.gen_imagen = gen_imagen;
		this.gen_estado = gen_estado;
	}	
	
	public Generos() {
	
	}

	public Integer getGen_Id() {
		return gen_Id;
	}

	public void setGen_Id(Integer gen_Id) {
		this.gen_Id = gen_Id;
	}

	public String getGen_nombre() {
		return gen_nombre;
	}

	public void setGen_nombre(String gen_nombre) {
		this.gen_nombre = gen_nombre;
	}

	public String getGen_descripcion() {
		return gen_descripcion;
	}

	public void setGen_descripcion(String gen_descripcion) {
		this.gen_descripcion = gen_descripcion;
	}

	public String getGen_imagen() {
		return gen_imagen;
	}

	public void setGen_imagen(String gen_imagen) {
		this.gen_imagen = gen_imagen;
	}

	public Boolean getGen_estado() {
		return gen_estado;
	}

	public void setGen_estado(Boolean gen_estado) {
		this.gen_estado = gen_estado;
	}

	@Override
	public String toString() {
		return "Generos [gen_Id=" + gen_Id + ", gen_nombre=" + gen_nombre + ", gen_descripcion=" + gen_descripcion
				+ ", gen_imagen=" + gen_imagen + ", gen_estado=" + gen_estado + "]";
	}
	
	
	
	
}
