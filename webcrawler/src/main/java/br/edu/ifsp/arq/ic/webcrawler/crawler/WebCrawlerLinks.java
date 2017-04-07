package br.edu.ifsp.arq.ic.webcrawler.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WebCrawlerLinks {

	private List<String> linksToCrawler;
	private List<String> linksCrawled;
	private final String DOMAIN;
	private Logger log = Logger.getLogger("WebCrawlerLinks");
	
	public WebCrawlerLinks(final String domain){
		DOMAIN = domain;
		linksToCrawler = new ArrayList<String>();
		linksToCrawler.add(DOMAIN);
		linksCrawled = new ArrayList<String>();
	}
	
	public synchronized String getLinkToCrawler(){
		try{
			String link = linksToCrawler.get(0);
			linksToCrawler.remove(0);
			return link;
		}catch(IndexOutOfBoundsException e){
			return null;
		}
	}
	
	public synchronized List<String> getLinksToCrawler(){
		return linksToCrawler;
	}
	
	public synchronized List<String> getLinksCrawled(){
		return linksCrawled;
	}
	
	public Boolean contains(String link){
		if(linksToCrawler.contains(link) || linksCrawled.contains(link)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public synchronized void addLinkToCrawler(String link){
		linksToCrawler.add(link);
		log.info("Adicionado link na lista para crawlear: " + link);
	}
	
	public synchronized void addLinkCrawled(String link){
		linksCrawled.add(link);
		log.info("Adicionado link na lista de links crawleados: " + link);
	}
	
	public String getDomain(){
		return this.DOMAIN;
	}
	
}
