package com.jun.crawler.novatec.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jun.crawler.novatec.domain.Livro;
import com.jun.crawler.novatec.service.SiteService;

@RestController
public class LivrosController {
	
	@GetMapping("/ultimoslancamentos")
	public List<Livro> ultimosLancamentos() {
		try {
			return new SiteService("https://novatec.com.br/").ultimosLancamentos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
