package com.tecno.dominio.modelo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Ciudad", description = "Esta clase se encarga de manejar los mensajes de Ciudad del sistema")
public class Ciudad    implements Serializable{
	
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "ciu_idciudad", required = true, dataType = "String", example = "0000", position = 1)
	Integer ciu_idciudad;
	@ApiModelProperty(value = "ciu_nombre", required = true, dataType = "String", example = "0000", position = 2)
	String  ciu_nombre;
	@ApiModelProperty(value = "ciu_codoficial", required = true, dataType = "String", example = "0000", position = 3)
	String  ciu_codoficial;
	@ApiModelProperty(value = "ciu_latitud", required = true, dataType = "String", example = "0000", position = 4)
	String  ciu_latitud;
	@ApiModelProperty(value = "ciu_longitud", required = true, dataType = "String", example = "0000", position = 5)
	String  ciu_longitud;
	@ApiModelProperty(value = "ciu_iddepartamento", required = true, dataType = "String", example = "0000", position = 6)
	Integer ciu_iddepartamento;

	@ApiModelProperty(value = "ciu_epestado", required = true, dataType = "Boolean", example = "0000", position = 7)
	Boolean ciu_epestado;
	
	@ApiModelProperty(value = "ciu_codpostal", required = true, dataType = "String", example = "0000", position = 8)
	String  ciu_codpostal;
	@ApiModelProperty(value = "updated_at", required = true, dataType = "Date", example = "0000", position = 9)
	Date updated_at;
	@ApiModelProperty(value = "created_at", required = true, dataType = "Date", example = "0000", position = 10)
	Date created_at;
	
	public Ciudad(Integer ciu_idciudad, String ciu_nombre, String ciu_codoficial, String ciu_latitud,
			String ciu_longitud, Integer ciu_iddepartamento, Boolean ciu_epestado, String ciu_codpostal,
			Date updated_at, Date created_at) {
		this.ciu_idciudad = ciu_idciudad;
		this.ciu_nombre = ciu_nombre;
		this.ciu_codoficial = ciu_codoficial;
		this.ciu_latitud = ciu_latitud;
		this.ciu_longitud = ciu_longitud;
		this.ciu_iddepartamento = ciu_iddepartamento;
		this.ciu_epestado = ciu_epestado;
		this.ciu_codpostal = ciu_codpostal;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	
	public Ciudad() {

	}


	public Integer getCiu_idciudad() {
		return ciu_idciudad;
	}


	public void setCiu_idciudad(Integer ciu_idciudad) {
		this.ciu_idciudad = ciu_idciudad;
	}


	public String getCiu_nombre() {
		return ciu_nombre;
	}


	public void setCiu_nombre(String ciu_nombre) {
		this.ciu_nombre = ciu_nombre;
	}


	public String getCiu_codoficial() {
		return ciu_codoficial;
	}


	public void setCiu_codoficial(String ciu_codoficial) {
		this.ciu_codoficial = ciu_codoficial;
	}


	public String getCiu_latitud() {
		return ciu_latitud;
	}


	public void setCiu_latitud(String ciu_latitud) {
		this.ciu_latitud = ciu_latitud;
	}


	public String getCiu_longitud() {
		return ciu_longitud;
	}


	public void setCiu_longitud(String ciu_longitud) {
		this.ciu_longitud = ciu_longitud;
	}


	public Integer getCiu_iddepartamento() {
		return ciu_iddepartamento;
	}


	public void setCiu_iddepartamento(Integer ciu_iddepartamento) {
		this.ciu_iddepartamento = ciu_iddepartamento;
	}


	public Boolean getCiu_epestado() {
		return ciu_epestado;
	}


	public void setCiu_epestado(Boolean ciu_epestado) {
		this.ciu_epestado = ciu_epestado;
	}


	public String getCiu_codpostal() {
		return ciu_codpostal;
	}


	public void setCiu_codpostal(String ciu_codpostal) {
		this.ciu_codpostal = ciu_codpostal;
	}


	public Date getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}


	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


	@Override
	public String toString() {
		return "Ciudad [ciu_idciudad=" + ciu_idciudad + ", ciu_nombre=" + ciu_nombre + ", ciu_codoficial="
				+ ciu_codoficial + ", ciu_latitud=" + ciu_latitud + ", ciu_longitud=" + ciu_longitud
				+ ", ciu_iddepartamento=" + ciu_iddepartamento + ", ciu_epestado=" + ciu_epestado + ", ciu_codpostal="
				+ ciu_codpostal + ", updated_at=" + updated_at + ", created_at=" + created_at + "]";
	}
	
	
	
	
	
}
