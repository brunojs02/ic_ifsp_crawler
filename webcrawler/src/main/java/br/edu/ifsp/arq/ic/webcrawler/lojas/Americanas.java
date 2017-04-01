package br.edu.ifsp.arq.ic.webcrawler.lojas;

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

public class Americanas {
	public final static String DOMAIN = "http://www.americanas.com.br/";
	private Set<String> links;
	private List<Document> docs;
	private WebDriver driver;
	
	public Americanas(){
		links = new HashSet<String>();
		docs = new ArrayList<Document>();
		driver = new BrowserPhantomJS().getDriver();
		this.parse(DOMAIN);
	}
	
	private void parse(String url){
		this.links.add(url);
		this.driver.get(url);
		String html = this.driver.getPageSource();
		Document doc = Jsoup.parse(html);
		this.docs.add(doc);
		Elements elementos = doc.select("a");
		for(Element elemento:elementos){
			String link = elemento.attr("abs:href");
			if(link.startsWith(DOMAIN)){
				links.add(link);
			}
		}
	}
	
	public void closeBrowser(){
		driver.close();
		driver.quit();
	}
}
