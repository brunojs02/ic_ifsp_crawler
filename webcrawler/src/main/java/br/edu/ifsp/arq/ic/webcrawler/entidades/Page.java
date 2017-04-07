package br.edu.ifsp.arq.ic.webcrawler.entidades;

import java.util.Calendar;

import org.jsoup.nodes.Document;

public class Page {
	private String domain;
	private String url;
	private Document doc;
	private Long timeToLoadPage;

	private Calendar dateCreated;
	private Calendar dateUpdated;
	
	public Page(String domain, String url, Document doc, Long timeLoad){
		this.domain = domain;
		this.url = url;
		this.doc = doc;
		this.timeToLoadPage = timeLoad;
		this.dateCreated = Calendar.getInstance();
		this.dateUpdated = Calendar.getInstance();
	}
	
	public String getDomain() {
		return domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Document getDoc() {
		return doc;
	}
	
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	public Calendar getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Calendar getDateUpdated() {
		return dateUpdated;
	}
	
	public void setDateUpdated(Calendar dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public Long getTimeToLoadPage() {
		return timeToLoadPage;
	}

	public void setTimeToLoadPage(Long timeToLoadPage) {
		this.timeToLoadPage = timeToLoadPage;
	}

	@Override
	public String toString() {
		return "Page [domain=" + domain + ", url=" + url + ", doc=" + doc
				+ ", timeToLoadPage=" + timeToLoadPage + ", dateCreated="
				+ dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	
}
