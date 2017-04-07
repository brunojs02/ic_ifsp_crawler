package br.edu.ifsp.arq.ic.webcrawler.crawler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import br.edu.ifsp.arq.ic.webcrawler.browsers.BrowserPhantomJS;
import br.edu.ifsp.arq.ic.webcrawler.entidades.Page;

public class WebCrawler {
	private List<Page> pages;
	private WebDriver driver;
	private WebCrawlerLinks webCrawlerLinks;
	private Logger log = Logger.getLogger("WebCrawler");
	
	public WebCrawler(String domain){
		webCrawlerLinks = new WebCrawlerLinks(domain);
		pages = new ArrayList<Page>();
		driver = new BrowserPhantomJS().getDriver();
		this.start();
		log.info(String.valueOf(webCrawlerLinks.getLinksCrawled().size()) + " links");
		this.closeBrowser();
	}
	
	private void start(){
		String url = null;
		int limite = 4;
		while((url = webCrawlerLinks.getLinkToCrawler()) != null && limite > 0){
			log.info("Iniciando o crawling na URL: " + url);
			log.info("Quantidade de links restantes: " + webCrawlerLinks.getQtdLinksToCrawler());
			this.parse(url);
			log.info("Finalizado o crawling da URL: " + url);
			log.info("Quantidade de links crawleados: " + webCrawlerLinks.getQtdLinksCrawled());
			limite--;
		}
	}
	
	private void parse(String url){
		Long t1 = Calendar.getInstance().getTimeInMillis();
		this.driver.get(url);
		Long t2 = Calendar.getInstance().getTimeInMillis();
		String html = this.driver.getPageSource();
		Document doc = Jsoup.parse(html);
		webCrawlerLinks.addLinkCrawled(url);
		pages.add(new Page(webCrawlerLinks.getDomain(), url, doc, (t2-t1)));
		Elements elementos = doc.select("a");
		for(Element elemento:elementos){
			String link = elemento.attr("abs:href");
			if(link.startsWith(webCrawlerLinks.getDomain())){
				if(Boolean.TRUE.equals(webCrawlerLinks.isToAddLinkToCrawler(link))){
					webCrawlerLinks.addLinkToCrawler(link);
				}
			}
		}
	}
	
	public void closeBrowser(){
		log.info("Browser fechado");
		driver.quit();
	}
}
