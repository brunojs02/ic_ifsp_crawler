package org.brunojs02.crawler.entities;

public class Link {
	private Integer id;
	private String link;
	private Integer depth;
	
	/**
	 * @param link
	 * @param depth
	 * @param crawled
	 */
	public Link(String link, Integer depth) {
		this.link = link;
		this.depth = depth;
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
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the depth
	 */
	public Integer getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(Integer depth) {
		this.depth = depth;
	}


	@Override
	public String toString() {
		return "Link [id=" + id + ", link=" + link + ", depth=" + depth + "]";
	}

	
}
