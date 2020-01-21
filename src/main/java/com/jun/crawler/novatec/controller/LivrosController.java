package com.jun.crawler.novatec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosController {
	
	@GetMapping("/ultimoslancamentos")
	public String ultimosLancamentos() {
		return "funcionou";
	}
}
