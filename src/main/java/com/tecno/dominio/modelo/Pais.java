package com.tecno.dominio.modelo;



import java.io.Serializable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Pais", description = "Esta clase se encarga del manejo de los Pais del sistema")
public class Pais  implements Serializable{
	
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "pai_idpais", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer pai_idpais;
	@ApiModelProperty(value = "pai_nombre", required = true, dataType = "String", example = "0000", position = 2)
	String  pai_nombre;
	@ApiModelProperty(value = "pai_cod_oficial_iso", required = true, dataType = "String", example = "0000", position = 3)
	String  pai_cod_oficial_iso;
	@ApiModelProperty(value = "pai_iso2", required = true, dataType = "String", example = "0000", position = 4)
	String  pai_iso2;
	@ApiModelProperty(value = "pai_iso3", required = true, dataType = "String", example = "0000", position = 5)
	String  pai_iso3;
	@ApiModelProperty(value = "pai_latitud", required = true, dataType = "String", example = "0000", position = 6)
	String  pai_latitud;
	@ApiModelProperty(value = "pai_longitud", required = true, dataType = "String", example = "0000", position = 7)
	String  pai_longitud;
	@ApiModelProperty(value = "pai_codpostal", required = true, dataType = "String", example = "0000", position = 8)
	String  pai_codpostal;
	
	public Pais(Integer pai_idpais, String pai_nombre, String pai_cod_oficial_iso, String pai_iso2, String pai_iso3,
			String pai_latitud, String pai_longitud, String pai_codpostal) {
		this.pai_idpais = pai_idpais;
		this.pai_nombre = pai_nombre;
		this.pai_cod_oficial_iso = pai_cod_oficial_iso;
		this.pai_iso2 = pai_iso2;
		this.pai_iso3 = pai_iso3;
		this.pai_latitud = pai_latitud;
		this.pai_longitud = pai_longitud;
		this.pai_codpostal = pai_codpostal;
	}
	
	public Pais() {
	
	}

	public Integer getPai_idpais() {
		return pai_idpais;
	}

	public void setPai_idpais(Integer pai_idpais) {
		this.pai_idpais = pai_idpais;
	}

	public String getPai_nombre() {
		return pai_nombre;
	}

	public void setPai_nombre(String pai_nombre) {
		this.pai_nombre = pai_nombre;
	}

	public String getPai_cod_oficial_iso() {
		return pai_cod_oficial_iso;
	}

	public void setPai_cod_oficial_iso(String pai_cod_oficial_iso) {
		this.pai_cod_oficial_iso = pai_cod_oficial_iso;
	}

	public String getPai_iso2() {
		return pai_iso2;
	}

	public void setPai_iso2(String pai_iso2) {
		this.pai_iso2 = pai_iso2;
	}

	public String getPai_iso3() {
		return pai_iso3;
	}

	public void setPai_iso3(String pai_iso3) {
		this.pai_iso3 = pai_iso3;
	}

	public String getPai_latitud() {
		return pai_latitud;
	}

	public void setPai_latitud(String pai_latitud) {
		this.pai_latitud = pai_latitud;
	}

	public String getPai_longitud() {
		return pai_longitud;
	}

	public void setPai_longitud(String pai_longitud) {
		this.pai_longitud = pai_longitud;
	}

	public String getPai_codpostal() {
		return pai_codpostal;
	}

	public void setPai_codpostal(String pai_codpostal) {
		this.pai_codpostal = pai_codpostal;
	}

	@Override
	public String toString() {
		return "Pais [pai_idpais=" + pai_idpais + ", pai_nombre=" + pai_nombre + ", pai_cod_oficial_iso="
				+ pai_cod_oficial_iso + ", pai_iso2=" + pai_iso2 + ", pai_iso3=" + pai_iso3 + ", pai_latitud="
				+ pai_latitud + ", pai_longitud=" + pai_longitud + ", pai_codpostal=" + pai_codpostal + "]";
	}
	
	
	
	
	
	
}
