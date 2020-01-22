package com.jun.crawler.novatec.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

import com.jun.crawler.novatec.domain.Livro;

public class LivroDetalhado extends LivroService {

	public LivroDetalhado(String url) throws MalformedURLException {
		super(url);
	}

	public Livro livroDetalhado() throws IOException{
		Document doc = this.siteRepositorio.AcessarComProxy();
		return this.DocumentToLivro(doc);
	}

	@Override
	protected Livro DocumentToLivro(Document doc) {
		Livro livro = new Livro();
		
		
		return livro;
	}
	
	

	

}
