package org.brunojs02.crawler.entities;

import org.jsoup.nodes.Document;

public class Page {
	private Integer id;
	private Link link;
	private Document document;
	private Integer qtdImgs;
	private Integer qtdLinks;
	private Integer qtdCssFiles;
	private Integer qtdJsFiles;
	private Integer qtdDivs;
	private Integer qtdUl;
	private Integer qtdLi;
	private Integer qtdInputs;


	/**
	 * @param link
	 * @param document
	 */
	public Page(Link link, Document document) {
		this.link = link;
		this.document = document;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the link
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * @return the document
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(Document document) {
		this.document = document;
	}
	
	/**
	 * @return the qtdImgs
	 */
	public Integer getQtdImgs() {
		return qtdImgs;
	}

	/**
	 * @param qtdImgs the qtdImgs to set
	 */
	public void setQtdImgs(Integer qtdImgs) {
		this.qtdImgs = qtdImgs;
	}

	/**
	 * @return the qtdLinks
	 */
	public Integer getQtdLinks() {
		return qtdLinks;
	}

	/**
	 * @param qtdLinks the qtdLinks to set
	 */
	public void setQtdLinks(Integer qtdLinks) {
		this.qtdLinks = qtdLinks;
	}

	/**
	 * @return the qtdCssFiles
	 */
	public Integer getQtdCssFiles() {
		return qtdCssFiles;
	}

	/**
	 * @param qtdCssFiles the qtdCssFiles to set
	 */
	public void setQtdCssFiles(Integer qtdCssFiles) {
		this.qtdCssFiles = qtdCssFiles;
	}

	/**
	 * @return the qtdJsFiles
	 */
	public Integer getQtdJsFiles() {
		return qtdJsFiles;
	}

	/**
	 * @param qtdJsFiles the qtdJsFiles to set
	 */
	public void setQtdJsFiles(Integer qtdJsFiles) {
		this.qtdJsFiles = qtdJsFiles;
	}

	/**
	 * @return the qtdDivs
	 */
	public Integer getQtdDivs() {
		return qtdDivs;
	}

	/**
	 * @param qtdDivs the qtdDivs to set
	 */
	public void setQtdDivs(Integer qtdDivs) {
		this.qtdDivs = qtdDivs;
	}

	/**
	 * @return the qtdUl
	 */
	public Integer getQtdUl() {
		return qtdUl;
	}

	/**
	 * @param qtdUl the qtdUl to set
	 */
	public void setQtdUl(Integer qtdUl) {
		this.qtdUl = qtdUl;
	}

	/**
	 * @return the qtdLi
	 */
	public Integer getQtdLi() {
		return qtdLi;
	}

	/**
	 * @param qtdLi the qtdLi to set
	 */
	public void setQtdLi(Integer qtdLi) {
		this.qtdLi = qtdLi;
	}

	/**
	 * @return the qtdInputs
	 */
	public Integer getQtdInputs() {
		return qtdInputs;
	}

	/**
	 * @param qtdInputs the qtdInputs to set
	 */
	public void setQtdInputs(Integer qtdInputs) {
		this.qtdInputs = qtdInputs;
	}

	
	@Override
	public String toString() {
		return "Page [id=" + id + ", link=" + link + ", document=" + document + ", qtdImgs=" + qtdImgs + ", qtdLinks="
				+ qtdLinks + ", qtdCssFiles=" + qtdCssFiles + ", qtdJsFiles=" + qtdJsFiles + ", qtdDivs=" + qtdDivs
				+ ", qtdUl=" + qtdUl + ", qtdLi=" + qtdLi + ", qtdInputs=" + qtdInputs + "]";
	}
	
	
}
