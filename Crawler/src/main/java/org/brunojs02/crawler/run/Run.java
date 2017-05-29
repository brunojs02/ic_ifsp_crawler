package org.brunojs02.crawler.run;

import org.brunojs02.crawler.Crawler;

public class Run {
	public static final Integer DEPTH = 1;
	
	public static void main(String[] args) {
		Crawler crawler = new Crawler("http://www.magazineluiza.com.br/");
		crawler.start();
	}

}
