package org.brunojs02.crawler;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.brunojs02.crawler.dao.CrawlerDAO;
import org.brunojs02.crawler.entities.Link;
import org.brunojs02.crawler.entities.Page;
import org.brunojs02.crawler.util.CrawlerUtil;
import org.brunojs02.crawler.webdriver.WebDriverCustom;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

public class Crawler {
	private WebDriverCustom driver;
	private Frontier frontier;
	private CrawlerDAO crawlerDAO;
	private Logger log = Logger.getLogger("CrawlerLog");
	
	/**
	 * @param Default Domain to start the Crawler
	 */
	public Crawler(String domain) {
		this.frontier = new Frontier(domain);
		Link link = new Link(domain, Integer.valueOf(0));
		frontier.addLink(link);
		crawlerDAO = new CrawlerDAO();
		driver = new WebDriverCustom(WebDriverCustom.CHROME_DRIVER);
	}
	
	public void start() {
		Link link;
		while ((link = frontier.getLinkToCrawl()) != null) {
			this.init(link);
		}
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
		frontier.addLinkCrawled(link);
		parse(driver.getDriver(), link);
		log.info("Finished Crawler the link: " + link.getLink());
		log.info("Amount of links to crawl: " + frontier.getQtdLinksToCrawl());
		log.info("Amount of links crawled: " + frontier.getQtdLinksToCrawled());
	}
	
	private void parse(WebDriver driver, Link link){
		Document doc = Jsoup.parse(driver.getPageSource());
		Page page = generatePage(link, doc);
		CrawlerUtil.generatePerformanceStatistic(driver, page);
		Elements elements = doc.select("a[href]");
		Set<Link> links = new HashSet<Link>();
		for(Element element:elements){
			if (!(element.attr("abs:href").trim().isEmpty())) {
				Link newLink = new Link(element.attr("abs:href"), (link.getDepth() + 1));
				frontier.addLink(newLink);
				links.add(newLink);
			}
		}
		page.setLinksOnThisPage(links);
		crawlerDAO.save(page);
	}
	
	private Page generatePage(Link link, Document doc){
		Page page = new Page(link, doc);
		page.setQtdTagLink(doc.select("link[href]").size());
		page.setQtdTagDiv(doc.select("div").size());
		page.setQtdTagImg(doc.select("img[src]").size());
		page.setQtdTagInput(doc.select("input").size());
		page.setQtdTagScript(doc.select("script[src]").size());
		page.setQtdTaUl(doc.select("ul").size());
		page.setQtdTagLi(doc.select("li").size());
		return page;
	}
	
	
}
