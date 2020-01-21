package com.jun.crawler.novatec.service.enums;

public enum UltimosLancamentos {
	
	LIVRO1("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(5) > td:nth-child(1) > table"),
	LIVRO2("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(5) > td:nth-child(2) > table"),
	LIVRO3("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(7) > td:nth-child(1) > table"),
	LIVRO4("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(7) > td:nth-child(2) > table"),
	LIVRO5("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(9) > td:nth-child(1) > table"),
	LIVRO6("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(9) > td:nth-child(2) > table"),
	LIVRO7("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(11) > td:nth-child(1) > table"),
	LIVRO8("body > table:nth-child(5) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(11) > td:nth-child(2) > table");
	
	
	private String selector;
	
	UltimosLancamentos(String selector) {
		this.selector = selector;
	}
	
	public String getSelector() {
		return this.selector;
	}
	
}
