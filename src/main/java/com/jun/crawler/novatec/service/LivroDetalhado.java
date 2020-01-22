package com.jun.crawler.novatec.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.jun.crawler.novatec.domain.Livro;
import com.jun.crawler.novatec.util.Regex;

public class LivroDetalhado extends LivroService {

	private static String regexAno = "\\d{4}\\ ";
	private static String regexISBN = "\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d";
	private static String regexPreco = "\\d{1,},\\d{1,}";
	private static String regexAutor = "\\D{1,}ISBN";
	private static String regexPaginas = "Páginas: \\d{1,}";
	
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
		
		Element table = doc.select("table").get(6);
		
		livro.setCapa_url(table.select("img").attr("src"));
		livro.setTitulo(table.select("img").attr("title"));
		
		String texto = table.select("span").text();
		
		livro.setAno(Regex.Cut(texto, regexAno));
		livro.setIsbn(Regex.Cut(texto, regexISBN));
		livro.setPreco(Regex.Cut(texto, regexPreco));
		livro.setAutor(Regex.Cut(texto, regexAutor));
		livro.setPaginas(Regex.Cut(texto, regexPaginas));
		livro.setDescricao(table.select("#mais").text());
		
		
		return livro;
	}
	
	

	

}
