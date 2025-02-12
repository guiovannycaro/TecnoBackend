package com.tecno.dominio.modelo;


import java.io.Serializable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Departamentoestado", description = "Esta clase se encarga de manejar los mensajes de Departamentoestado del sistema")
public class Departamentoestado    implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;
	
	@ApiModelProperty(value = "dep_iddepartamento", required = true, dataType = "Integer", example = "0000", position = 1)
	Integer dep_iddepartamento;
	@ApiModelProperty(value = "dep_pais", required = true, dataType = "Integer", example = "0000", position = 2)
	Integer dep_pais;
	
	@ApiModelProperty(value = "dep_codoficial", required = true, dataType = "String", example = "0000", position = 3)
	String  dep_codoficial;
	@ApiModelProperty(value = "dep_nombre", required = true, dataType = "String", example = "0000", position = 4)
	String  dep_nombre;
	@ApiModelProperty(value = "dep_latitud", required = true, dataType = "String", example = "0000", position = 5)
	String  dep_latitud;
	@ApiModelProperty(value = "dep_longitud", required = true, dataType = "String", example = "0000", position = 6)
	String  dep_longitud;
	
	
	public Departamentoestado(Integer dep_iddepartamento, Integer dep_pais, String dep_codoficial, String dep_nombre,
			String dep_latitud, String dep_longitud) {
		this.dep_iddepartamento = dep_iddepartamento;
		this.dep_pais = dep_pais;
		this.dep_codoficial = dep_codoficial;
		this.dep_nombre = dep_nombre;
		this.dep_latitud = dep_latitud;
		this.dep_longitud = dep_longitud;
	}
	
	public Departamentoestado() {
		
	}
	
	public Integer getDep_iddepartamento() {
		return dep_iddepartamento;
	}
	public void setDep_iddepartamento(Integer dep_iddepartamento) {
		this.dep_iddepartamento = dep_iddepartamento;
	}
	public Integer getDep_pais() {
		return dep_pais;
	}
	public void setDep_pais(Integer dep_pais) {
		this.dep_pais = dep_pais;
	}
	public String getDep_codoficial() {
		return dep_codoficial;
	}
	public void setDep_codoficial(String dep_codoficial) {
		this.dep_codoficial = dep_codoficial;
	}
	public String getDep_nombre() {
		return dep_nombre;
	}
	public void setDep_nombre(String dep_nombre) {
		this.dep_nombre = dep_nombre;
	}
	public String getDep_latitud() {
		return dep_latitud;
	}
	public void setDep_latitud(String dep_latitud) {
		this.dep_latitud = dep_latitud;
	}
	public String getDep_longitud() {
		return dep_longitud;
	}
	public void setDep_longitud(String dep_longitud) {
		this.dep_longitud = dep_longitud;
	}
	@Override
	public String toString() {
		return "Departamentoestado [dep_iddepartamento=" + dep_iddepartamento + ", dep_pais=" + dep_pais
				+ ", dep_codoficial=" + dep_codoficial + ", dep_nombre=" + dep_nombre + ", dep_latitud=" + dep_latitud
				+ ", dep_longitud=" + dep_longitud + "]";
	}
	
	
	
	
}
