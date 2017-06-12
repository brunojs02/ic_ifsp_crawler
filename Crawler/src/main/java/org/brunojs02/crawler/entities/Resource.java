package org.brunojs02.crawler.entities;

public class Resource {
	
	public static final Integer DOCUMENT = Integer.valueOf(1);
	public static final Integer CSS      = Integer.valueOf(2);
	public static final Integer JS       = Integer.valueOf(3);
	public static final Integer OTHER    = Integer.valueOf(4);
	
	private String url;
	private String type;
	private String dataLength;
	private Double timeToLoad;
	private String requestId;
	
	
	public Resource(){}
	
	/**
	 * @param url
	 * @param type
	 * @param dataLength
	 * @param timeToLoad
	 */
	public Resource(String url, String type, String dataLength, Double timeToLoad) {
		this.url = url;
		this.type = type;
		this.dataLength = dataLength;
		this.timeToLoad = timeToLoad;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the dataLength
	 */
	public String getDataLength() {
		return dataLength;
	}

	/**
	 * @param dataLength the dataLength to set
	 */
	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}

	/**
	 * @return the timeToLoad
	 */
	public Double getTimeToLoad() {
		return timeToLoad;
	}
	
	/**
	 * @return the timeToLoad in Milisegundos
	 */
	public Double getTimeToLoadInMs() {
		return timeToLoad / 1000;
	}

	/**
	 * @param timeToLoad the timeToLoad to set
	 */
	public void setTimeToLoad(Double timeToLoad) {
		this.timeToLoad = timeToLoad;
	}
	
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	
	@Override
	public String toString() {
		return "Resource [url=" + url + ", type=" + type + ", dataLength=" + dataLength + ", timeToLoad=" + timeToLoad
				+ ", requestId=" + requestId + "]";
	}
	
}
