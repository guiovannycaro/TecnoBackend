package com.tecno.dominio.modelo;



import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "TipoDocumento", description = "Esta clase se encarga del manejo de los tipos de documentos del sistema")
public class TipoDocumento implements Serializable{
	
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "tip_idtipodocumento", required = true, dataType = "Integer", example = "0000", position = 1)
   Integer tip_idtipodocumento;
	@ApiModelProperty(value = "tip_descripcion", required = true, dataType = "String", example = "0000", position = 2)
   String  tip_descripcion;
	@ApiModelProperty(value = "tip_estado", required = true, dataType = "Boolean", example = "0000", position = 3)
   Boolean tip_estado;
	
	public TipoDocumento(Integer tip_idtipodocumento, String tip_descripcion, Boolean tip_estado) {
		this.tip_idtipodocumento = tip_idtipodocumento;
		this.tip_descripcion = tip_descripcion;
		this.tip_estado = tip_estado;
	}
	
	
	public TipoDocumento() {
		
	}


	public Integer getTip_idtipodocumento() {
		return tip_idtipodocumento;
	}


	public void setTip_idtipodocumento(Integer tip_idtipodocumento) {
		this.tip_idtipodocumento = tip_idtipodocumento;
	}


	public String getTip_descripcion() {
		return tip_descripcion;
	}


	public void setTip_descripcion(String tip_descripcion) {
		this.tip_descripcion = tip_descripcion;
	}


	public Boolean getTip_estado() {
		return tip_estado;
	}


	public void setTip_estado(Boolean tip_estado) {
		this.tip_estado = tip_estado;
	}


	@Override
	public String toString() {
		return "TipoDocumento [tip_idtipodocumento=" + tip_idtipodocumento + ", tip_descripcion=" + tip_descripcion
				+ ", tip_estado=" + tip_estado + "]";
	}
	
	
	
	
}
