package org.brunojs02.crawler.entities;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

public class Page {
	private Integer id;
	private Link link;
	private Document document;
	private Integer qtdTagImg;
	private Integer qtdTagLink;
	private Integer qtdTagScript;
	private Integer qtdTagDiv;
	private Integer qtdTaUl;
	private Integer qtdTagLi;
	private Integer qtdTagInput;
	private List<Link> linksOnThisPage;
	
	
	/**
	 * @param link
	 * @param document
	 */
	public Page(Link link, Document document) {
		this.link = link;
		this.document = document;
		this.linksOnThisPage = new ArrayList<Link>();
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
	 * @return the qtdTagImg
	 */
	public Integer getQtdTagImg() {
		return qtdTagImg;
	}


	/**
	 * @param qtdTagImg the qtdTagImg to set
	 */
	public void setQtdTagImg(Integer qtdTagImg) {
		this.qtdTagImg = qtdTagImg;
	}


	/**
	 * @return the qtdTagLink
	 */
	public Integer getQtdTagLink() {
		return qtdTagLink;
	}


	/**
	 * @param qtdTagLink the qtdTagLink to set
	 */
	public void setQtdTagLink(Integer qtdTagLink) {
		this.qtdTagLink = qtdTagLink;
	}


	/**
	 * @return the qtdTagScript
	 */
	public Integer getQtdTagScript() {
		return qtdTagScript;
	}


	/**
	 * @param qtdTagScript the qtdTagScript to set
	 */
	public void setQtdTagScript(Integer qtdTagScript) {
		this.qtdTagScript = qtdTagScript;
	}


	/**
	 * @return the qtdTagDiv
	 */
	public Integer getQtdTagDiv() {
		return qtdTagDiv;
	}


	/**
	 * @param qtdTagDiv the qtdTagDiv to set
	 */
	public void setQtdTagDiv(Integer qtdTagDiv) {
		this.qtdTagDiv = qtdTagDiv;
	}


	/**
	 * @return the qtdTaUl
	 */
	public Integer getQtdTaUl() {
		return qtdTaUl;
	}


	/**
	 * @param qtdTaUl the qtdTaUl to set
	 */
	public void setQtdTaUl(Integer qtdTaUl) {
		this.qtdTaUl = qtdTaUl;
	}


	/**
	 * @return the qtdTagLi
	 */
	public Integer getQtdTagLi() {
		return qtdTagLi;
	}


	/**
	 * @param qtdTagLi the qtdTagLi to set
	 */
	public void setQtdTagLi(Integer qtdTagLi) {
		this.qtdTagLi = qtdTagLi;
	}


	/**
	 * @return the qtdTagInput
	 */
	public Integer getQtdTagInput() {
		return qtdTagInput;
	}


	/**
	 * @param qtdTagInput the qtdTagInput to set
	 */
	public void setQtdTagInput(Integer qtdTagInput) {
		this.qtdTagInput = qtdTagInput;
	}


	/**
	 * @return the linksOnThisPage
	 */
	public List<Link> getLinksOnThisPage() {
		return linksOnThisPage;
	}


	/**
	 * @param linksOnThisPage the linksOnThisPage to set
	 */
	public void setLinksOnThisPage(List<Link> linksOnThisPage) {
		this.linksOnThisPage = linksOnThisPage;
	}
	
	
}
