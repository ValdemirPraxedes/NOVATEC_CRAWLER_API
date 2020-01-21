package com.jun.crawler.novatec.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jun.crawler.novatec.domain.Livro;
import com.jun.crawler.novatec.service.LivrosCategoriaService;
import com.jun.crawler.novatec.service.UltimosLivrosService;

@RestController
public class LivrosController {
	
	@GetMapping("/ultimoslancamentos")
	public List<Livro> ultimosLancamentos() {
		try {
			return new UltimosLivrosService("https://novatec.com.br/").ultimosLancamentos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/livros/categoria")
	public List<Livro> livrosCategoria(@RequestParam(value="categoria", defaultValue = "2")int categoria,@RequestParam(value="pagina", defaultValue = "1")int pagina) {
		try {
			return new LivrosCategoriaService("https://novatec.com.br/lista.php?id="+categoria+"&pag="+pagina).livrosPorCategoria();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
