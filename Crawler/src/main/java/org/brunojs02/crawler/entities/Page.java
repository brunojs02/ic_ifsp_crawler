package org.brunojs02.crawler.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private Long pageLoadTime;
	private Set<Link> linksOnThisPage;
	private List<Resource> resources;
	
	
	/**
	 * @param link
	 * @param document
	 */
	public Page(Link link, Document document) {
		this.link = link;
		this.document = document;
		this.linksOnThisPage = new HashSet<Link>();
		this.resources = new ArrayList<Resource>();
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
	public Set<Link> getLinksOnThisPage() {
		return linksOnThisPage;
	}


	/**
	 * @return the pageLoadTime
	 */
	public Long getPageLoadTime() {
		return pageLoadTime;
	}


	/**
	 * @param pageLoadTime the pageLoadTime to set
	 */
	public void setPageLoadTime(Long pageLoadTime) {
		this.pageLoadTime = pageLoadTime;
	}


	/**
	 * @param linksOnThisPage the linksOnThisPage to set
	 */
	public void setLinksOnThisPage(Set<Link> linksOnThisPage) {
		this.linksOnThisPage = linksOnThisPage;
	}


	/**
	 * @return the resources
	 */
	public List<Resource> getResources() {
		return resources;
	}


	/**
	 * @param resources the resources to set
	 */
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [id=");
		builder.append(id);
		builder.append(", link=");
		builder.append(link);
		builder.append(", document=");
		builder.append(document);
		builder.append(", qtdTagImg=");
		builder.append(qtdTagImg);
		builder.append(", qtdTagLink=");
		builder.append(qtdTagLink);
		builder.append(", qtdTagScript=");
		builder.append(qtdTagScript);
		builder.append(", qtdTagDiv=");
		builder.append(qtdTagDiv);
		builder.append(", qtdTaUl=");
		builder.append(qtdTaUl);
		builder.append(", qtdTagLi=");
		builder.append(qtdTagLi);
		builder.append(", qtdTagInput=");
		builder.append(qtdTagInput);
		builder.append(", linksOnThisPage=");
		builder.append(linksOnThisPage);
		builder.append(", resources=");
		builder.append(resources);
		builder.append("]");
		return builder.toString();
	}
	
	
}
