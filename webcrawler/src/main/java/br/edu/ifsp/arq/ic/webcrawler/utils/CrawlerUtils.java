package br.edu.ifsp.arq.ic.webcrawler.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerUtils {
	
	public static Document changeAllImagesFromDocument(Document doc){
		Elements elementos = doc.select("img");
		for(Element elemento:elementos){
			String imgUrl = elemento.attr("abs:src");
			Image imagem;
			try {
				imagem = Toolkit.getDefaultToolkit().getImage(new URL(imgUrl));
				System.out.println(imagem.getHeight(null));
				System.out.println(imagem.getWidth(null));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return doc;
	}
	
}
