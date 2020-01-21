package com.jun.crawler.novatec.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jun.crawler.novatec.domain.Livro;
import com.jun.crawler.novatec.repositorio.SiteRepositorio;
import com.jun.crawler.novatec.service.enums.UltimosLancamentos;

public class UltimosLivrosService extends Service {
	
	public UltimosLivrosService(String url) throws MalformedURLException {
		super(url);
	}

	public List<Livro> ultimosLancamentos() throws IOException {
		Document document = this.siteRepositorio.AcessarComProxy();
		
		return this.DocumentToLivro(document);
	}
	
	public List<Livro> livrosPorCategoria() throws IOException{
		Document document = this.siteRepositorio.AcessarComProxy();
		return DocumentToLivro2(document);
		
	}
	
	private List<Livro> DocumentToLivro2(Document doc) {
		List<Livro> livros = new ArrayList<Livro>();
		Elements tabela = doc.select("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div > table > tbody > tr:nth-child(2) > td > table");
		for(int posChild = 3; posChild < 23; posChild+=2) {
			Livro livro = new Livro();
			Elements elementLivro = tabela.select("tbody > tr:nth-child("+posChild+")");
	    	String[] campos =  elementLivro.select("font").text().replace("ISBN:", ";").replace("Ano:", ";").replace("Páginas:", ";").replace("Preço:", ";").replace("Esgotado", "").split(";");
	    	String ISBN = campos[1];
	    	String ano = campos[2];
	    	String paginas = campos[3];
	    	String preco = campos[4];
	    	
			livro.setAutor(elementLivro.select("font > a:nth-child(4)").text());
			livro.setCapa_url(elementLivro.select("img").attr("src"));
			livro.setIsbn(ISBN);
			livro.setPaginas(paginas);
			livro.setPreco(preco);
			livro.setTitulo(elementLivro.select("font > a:nth-child(2)").text());
			livro.setAutor(elementLivro.select("font > a:nth-child(4)").text());
			
			livros.add(livro);
		}
		return livros;
	}
	
	protected List<Livro> DocumentToLivro(Document doc) {
		List<Livro> livros = new ArrayList<Livro>();
		for(UltimosLancamentos ul : UltimosLancamentos.values()) {
			Elements e = doc.select(ul.getSelector());
			
			Livro livro = new Livro();
			livro.setUrl(e.select("a").attr("href"));
	    	livro.setTitulo(e.select("img").attr("title"));
	    	livro.setCapa_url(e.select("img").attr("src"));
	    	livro.setDescricao(e.select("h2").text());
	    	
	    	livros.add(livro);
		}
		
		return livros;
	}
}
