package br.edu.ifsp.arq.ic.webcrawler.entidades;

import java.sql.Timestamp;

import org.jsoup.nodes.Document;

public class Page {
	private String domain;
	private String url;
	private Document doc;
	private Timestamp dateCreated;
	private Timestamp dateUpdated;
	
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
	
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Timestamp getDateUpdated() {
		return dateUpdated;
	}
	
	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		return "Page [domain=" + domain + ", url=" + url + ", doc=" + doc
				+ ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + "]";
	}
	
}
