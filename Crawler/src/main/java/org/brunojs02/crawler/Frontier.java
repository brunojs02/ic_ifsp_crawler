package org.brunojs02.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

import org.brunojs02.crawler.entities.Link;
import org.brunojs02.crawler.run.Run;

public class Frontier {
	private Queue<Link> links;
	private List<Link> linksCrawled;
	private final String domain;
	private Logger log = Logger.getLogger("FrontierLog");
	private static Frontier frontier;

	private Frontier(String domain) {
		this.domain = domain;
		links = new ConcurrentLinkedQueue<Link>();
		linksCrawled = new ArrayList<Link>();
	}
	
	/**
	 * @return the instance of this class
	 */
	public static Frontier getInstance(String domain) {
		if (frontier != null) {
			return frontier;
		}
		return new Frontier(domain);
	}

	/**
	 * @param Link link
	 */
	public Boolean addLink(Link link){
		if (link.getLink().startsWith(domain) && Run.DEPTH >= link.getDepth()) {
			for (Link linkCrawled:linksCrawled) {
				if (linkCrawled.getLink().equals(link.getLink())) {
					return Boolean.FALSE;
				}
			}
			if (Boolean.TRUE.equals(links.offer(link))) {
				log.info("New Link to Frontier: " + link.getLink() + " Depth from the Link: " + link.getDepth());
				return Boolean.TRUE;
			}else{
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * @return Link from the Queue
	 */
	public Link getLinkToCrawl(){
		return links.poll();
	}
	
	/**
	 * @param Link crawled
	 */
	public Boolean addLinkCrawled(Link link){
		return linksCrawled.add(link);
	}
	
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	
}
