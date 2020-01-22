package com.jun.crawler.novatec.service;

import java.net.MalformedURLException;
import java.util.List;

import org.jsoup.nodes.Document;

import com.jun.crawler.novatec.domain.Livro;
import com.jun.crawler.novatec.repositorio.SiteRepositorio;

public abstract class LivrosService {
	
	protected SiteRepositorio siteRepositorio;
	
	public LivrosService(String url) throws MalformedURLException {
		this.siteRepositorio = new SiteRepositorio(url);
	}
	
	protected abstract List<Livro> DocumentToLivro(Document doc);
}
