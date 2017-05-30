package org.brunojs02.crawler;

import java.util.logging.Logger;

import org.brunojs02.crawler.dao.CrawlerDAO;
import org.brunojs02.crawler.entities.Link;
import org.brunojs02.crawler.entities.Page;
import org.brunojs02.crawler.webdriver.WebDriverCustom;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private WebDriverCustom driver;
	private Frontier frontier;
	private CrawlerDAO crawlerDAO;
	private Logger log = Logger.getLogger("CrawlerLog");
	
	/**
	 * @param Default Domain to start the Crawler
	 */
	public Crawler(String domain) {
		this.frontier = Frontier.getInstance(domain);
		Link link = new Link(domain, Integer.valueOf(0), Boolean.FALSE);
		frontier.addLink(link);
		crawlerDAO = new CrawlerDAO();
		driver = new WebDriverCustom(WebDriverCustom.CHROME_DRIVER);
	}
	
	public void start() {
		Link link;
		while ((link = frontier.getLinkToCrawl()) != null) {
			this.init(link);
		}
		crawlerDAO.closeConnection();
		driver.destroyDriver();
	}
	
	private void init(Link link) {
		log.info("Start Crawler the link: " + link.getLink());
		try{
			driver.cleanCookies();
			driver.getDriver().get(link.getLink());
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
		Document doc = Jsoup.parse(driver.getDriver().getPageSource());
		parse(doc, link);
		log.info("Finished Crawler the link: " + link.getLink());
	}
	
	private void parse(Document doc, Link link){
		Elements elements = doc.select("a");
		for(Element element:elements){
			Link newLink = new Link(element.attr("abs:href"), (link.getDepth() + 1), Boolean.FALSE);
			frontier.addLink(newLink);
		}
		Page page = new Page(link, doc);
		page.setQtdLinks(doc.select("a").size());
		page.setQtdCssFiles(doc.select("link").size());
		page.setQtdDivs(doc.select("div").size());
		page.setQtdImgs(doc.select("img").size());
		page.setQtdInputs(doc.select("input").size());
		page.setQtdJsFiles(doc.select("script").size());
		page.setQtdUl(doc.select("ul").size());
		page.setQtdLi(doc.select("li").size());
		crawlerDAO.save(page);
	}
	
	
}
