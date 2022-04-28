package com.spring.codeblog.dto;

import javax.validation.constraints.NotBlank;

public class PostDto {
	
	@NotBlank
	private String autor;
	@NotBlank
	private String titulo;
	@NotBlank
	private String texto;
	
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
