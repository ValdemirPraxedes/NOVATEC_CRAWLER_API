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

public class SiteService {
	
	private SiteRepositorio siteRepositorio;
	
	public SiteService(String url) throws MalformedURLException {
		this.siteRepositorio = new SiteRepositorio(url);
	}
	
	
	public List<Livro> ultimosLancamentos() throws IOException {
		Document document = this.siteRepositorio.AcessarComProxy();
		
		return this.DocumentToLivro(document);
	}
	
	
	private List<Livro> DocumentToLivro(Document doc) {
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
