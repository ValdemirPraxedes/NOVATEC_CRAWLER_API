package com.jun.crawler.novatec.service;

import java.net.MalformedURLException;
import java.util.List;

import org.jsoup.nodes.Document;

import com.jun.crawler.novatec.domain.Livro;
import com.jun.crawler.novatec.repositorio.SiteRepositorio;

public abstract class LivroService {
	protected SiteRepositorio siteRepositorio;
	
	public LivroService(String url) throws MalformedURLException {
		this.siteRepositorio = new SiteRepositorio(url);
	}
	
	protected abstract Livro DocumentToLivro(Document doc);
}
