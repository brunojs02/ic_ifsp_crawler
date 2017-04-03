package br.edu.ifsp.arq.ic.webcrawler.crawler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import br.edu.ifsp.arq.ic.webcrawler.browsers.BrowserPhantomJS;
import br.edu.ifsp.arq.ic.webcrawler.entidades.Page;

public class WebCrawler {
	public final static String DOMAIN = "http://www.americanas.com.br/";
	private Set<String> links;
	private List<Page> pages;
	private WebDriver driver;
	
	public WebCrawler(){
		links = new HashSet<String>();
		pages = new ArrayList<Page>();
		driver = new BrowserPhantomJS().getDriver();
		this.parse(DOMAIN);
	}
	
	private void parse(String url){
		this.links.add(url);
		//browser abre a página
		this.driver.get(url);
		String html = this.driver.getPageSource();
		//jsoup faz o parse da String que representa o html interpretado pelo browser
		Document doc = Jsoup.parse(html);
		Elements elementos = doc.select("a");
		//é percorrido todos links existentes no site
		for(Element elemento:elementos){
			String link = elemento.attr("abs:href");
			if(link.startsWith(DOMAIN)){
				links.add(link);
			}
		}
		Page page = new Page();
		page.setUrl(url);
		page.setDomain(DOMAIN);
		page.setDoc(doc);
		pages.add(page);
	}
	
	public void closeBrowser(){
		driver.close();
		driver.quit();
	}
}
