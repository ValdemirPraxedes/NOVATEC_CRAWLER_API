package com.jun.crawler.novatec.domain;

public class Livro {
	
	private String titulo;
	private String descricao;
	private String capa_url;

	private String url;
	private String autor;
	private String isbn;
	private int paginas;
	private double preco;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCapa_url() {
		return capa_url;
	}
	public void setCapa_url(String capa_url) {
		this.capa_url = capa_url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = Integer.parseInt(paginas.trim());
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void setPreco(String preco) {
		this.preco = Double.parseDouble(preco.replace("R$", "").replace(",", ".").trim());
	}
}
