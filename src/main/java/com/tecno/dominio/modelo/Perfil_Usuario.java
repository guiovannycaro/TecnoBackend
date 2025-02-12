package com.tecno.dominio.modelo;




import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Perfil_Usuario", description = "Esta clase se encarga del manejo de los Perfil_Usuario del sistema")
public class Perfil_Usuario  implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "perusu_idpu", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer perusu_idpu;
	@ApiModelProperty(value = "perusu_idperfil", required = true, dataType = "Integer", example = "0000", position = 2)
	Integer perusu_idperfil;
	@ApiModelProperty(value = "perusu_idusuario", required = true, dataType = "Integer", example = "0000", position = 3)
	Integer perusu_idusuario;
	
	public Perfil_Usuario(Integer perusu_idpu, Integer perusu_idperfil, Integer perusu_idusuario) {
		this.perusu_idpu = perusu_idpu;
		this.perusu_idperfil = perusu_idperfil;
		this.perusu_idusuario = perusu_idusuario;
	}
	
	public Perfil_Usuario() {
		
	}

	public Integer getPerusu_idpu() {
		return perusu_idpu;
	}

	public void setPerusu_idpu(Integer perusu_idpu) {
		this.perusu_idpu = perusu_idpu;
	}

	public Integer getUsu_idperfil() {
		return perusu_idperfil;
	}

	public void setUsu_idperfil(Integer perusu_idperfil) {
		this.perusu_idperfil = perusu_idperfil;
	}

	public Integer getUsu_idusuario() {
		return perusu_idusuario;
	}

	public void setUsu_idusuario(Integer perusu_idusuario) {
		this.perusu_idusuario = perusu_idusuario;
	}

	@Override
	public String toString() {
		return "Perfil_Usuario [perusu_idpu=" + perusu_idpu + ", usu_idperfil=" + perusu_idperfil + ", usu_idusuario="
				+ perusu_idusuario + "]";
	}
	
	
	
}
