package br.edu.ifsp.arq.ic.webcrawler.utils;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Links {

	public List<String> getLinksFromADocument(Document doc, String lojaUrl){
		List<String> urls = new ArrayList<String>();
		Elements links = doc.select("a");
		for(Element link:links){
			urls.add(link.attr("abs:href"));
		}
		return urls;
	}
	
}
