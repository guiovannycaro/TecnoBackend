package com.tecno.dominio.modelo;

public class UsuarioPerfil {

	String perfil;
	String usuario;
	
	public UsuarioPerfil(String perfil, String usuario) {
		this.perfil = perfil;
		this.usuario = usuario;
	}
	
	public UsuarioPerfil() {

	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "UsuarioPerfil [perfil=" + perfil + ", usuario=" + usuario + "]";
	}
	
	
	
	
}
