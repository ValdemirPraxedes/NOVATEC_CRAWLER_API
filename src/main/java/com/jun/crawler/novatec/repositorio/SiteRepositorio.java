package com.jun.crawler.novatec.repositorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SiteRepositorio {
	
	private URL url;
	
	
	public String getUrl() {
		return url.toString();
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public SiteRepositorio(String url) throws MalformedURLException {
		this.url = new URL(url);
	}
	
	public Document Acessar() throws IOException {
		return this.Acessar(false);
	}
	
	public Document AcessarComProxy() throws IOException {
		return this.Acessar(true);
	}
	
	
	
	private Document Acessar(boolean withProxy) throws IOException {
		
	
    	HttpURLConnection uc = (HttpURLConnection) ( (withProxy) ? url.openConnection(getProxy()): url.openConnection());
        uc.connect();
       
        String line = null;
       StringBuffer tmp = new StringBuffer();
       
       BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
       
       while((line = in.readLine()) != null) {
    	   tmp.append(line);
       }
       
      return Jsoup.parse(String.valueOf(tmp));
      
	}
	
  private Proxy getProxy() {
	  return new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxywcg.bbmapfre.corp",8080));
  }
}
