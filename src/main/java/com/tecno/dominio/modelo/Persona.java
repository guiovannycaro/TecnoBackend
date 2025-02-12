package com.tecno.dominio.modelo;


import java.io.Serializable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Persona", description = "Esta clase se encarga del manejo de los Persona del sistema")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "per_idpersona", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer per_idpersona;
	@ApiModelProperty(value = "per_nombres", required = true, dataType = "String", example = "0000", position = 2)
	String  per_nombres;
	@ApiModelProperty(value = "per_apellidos", required = true, dataType = "String", example = "0000", position = 3)
	String  per_apellidos;
	@ApiModelProperty(value = "per_idtipodocumento", required = true, dataType = "Integer", example = "0000", position = 4)
	Integer per_idtipodocumento;
	@ApiModelProperty(value = "per_numdocumento", required = true, dataType = "String", example = "0000", position = 5)
	String  per_numdocumento;
	@ApiModelProperty(value = "per_numtelefono", required = true, dataType = "String", example = "0000", position = 6)
	String  per_numtelefono;
	@ApiModelProperty(value = "per_email", required = true, dataType = "String", example = "0000", position = 7)
	String  per_email;
	@ApiModelProperty(value = "per_direccion", required = true, dataType = "String", example = "0000", position = 8)
	String  per_direccion;
	@ApiModelProperty(value = "per_idciudad", required = true, dataType = "Integer", example = "0000", position = 9)
	Integer per_idciudad;
	
	@ApiModelProperty(value = "per_tipodocumento", required = true, dataType = "Integer", example = "0000", position = 10)
	Integer per_tipodocumento;

	public Persona(Integer per_idpersona, String per_nombres, String per_apellidos,Integer per_idtipodocumento, String per_numdocumento,
			String per_numtelefono, String per_email, String per_direccion, Integer per_idciudad,
			Integer per_tipodocumento) {
		this.per_idpersona = per_idpersona;
		this.per_nombres = per_nombres;
		this.per_apellidos = per_apellidos;
		this.per_idtipodocumento = per_idtipodocumento;
		this.per_numdocumento = per_numdocumento;
		this.per_numtelefono = per_numtelefono;
		this.per_email = per_email;
		this.per_direccion = per_direccion;
		this.per_idciudad = per_idciudad;
		this.per_tipodocumento = per_tipodocumento;
	}
	
	public Persona() {
	}

	public Integer getPer_idpersona() {
		return per_idpersona;
	}

	public void setPer_idpersona(Integer per_idpersona) {
		this.per_idpersona = per_idpersona;
	}

	public String getPer_nombres() {
		return per_nombres;
	}

	public void setPer_nombres(String per_nombres) {
		this.per_nombres = per_nombres;
	}

	public String getPer_apellidos() {
		return per_apellidos;
	}

	public void setPer_apellidos(String per_apellidos) {
		this.per_apellidos = per_apellidos;
	}

	
	public Integer getPer_idtipodocumento() {
		return per_idtipodocumento;
	}

	public void setPer_idtipodocumento(Integer per_idtipodocumento) {
		this.per_idtipodocumento = per_idtipodocumento;
	}
	
	public String getPer_numdocumento() {
		return per_numdocumento;
	}

	public void setPer_numdocumento(String per_numdocumento) {
		this.per_numdocumento = per_numdocumento;
	}

	public String getPer_numtelefono() {
		return per_numtelefono;
	}

	public void setPer_numtelefono(String per_numtelefono) {
		this.per_numtelefono = per_numtelefono;
	}

	public String getPer_email() {
		return per_email;
	}

	public void setPer_email(String per_email) {
		this.per_email = per_email;
	}

	public String getPer_direccion() {
		return per_direccion;
	}

	public void setPer_direccion(String per_direccion) {
		this.per_direccion = per_direccion;
	}

	public Integer getPer_idciudad() {
		return per_idciudad;
	}

	public void setPer_idciudad(Integer per_idciudad) {
		this.per_idciudad = per_idciudad;
	}

	public Integer getPer_tipodocumento() {
		return per_tipodocumento;
	}

	public void setPer_tipodocumento(Integer per_tipodocumento) {
		this.per_tipodocumento = per_tipodocumento;
	}

	@Override
	public String toString() {
		return "Persona [per_idpersona=" + per_idpersona + ", per_nombres=" + per_nombres + ", per_apellidos="
				+ per_apellidos + ", per_numdocumento=" + per_numdocumento + ", per_numtelefono=" + per_numtelefono
				+ ", per_email=" + per_email + ", per_direccion=" + per_direccion + ", per_idciudad=" + per_idciudad
				+ ", per_tipodocumento=" + per_tipodocumento + "]";
	}


}
