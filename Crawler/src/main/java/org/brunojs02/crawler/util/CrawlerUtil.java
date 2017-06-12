package org.brunojs02.crawler.util;

import java.util.List;

import org.brunojs02.crawler.entities.Page;
import org.brunojs02.crawler.entities.Resource;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

public class CrawlerUtil {
	
	public static void generatePerformanceStatistic(WebDriver driver, Page page){
		LogEntries logs = driver.manage().logs().get("performance");
		for(LogEntry log:logs) {
			JSONObject objJson = new JSONObject(log.getMessage());
			try{
				Resource res = new Resource();
				String objectString = objJson.getJSONObject("message").get("method").toString();
				JSONObject jsonObj = objJson.getJSONObject("message").getJSONObject("params");
				if (objectString.compareToIgnoreCase("Network.responseReceived") == 0) {
					res.setRequestId(jsonObj.getString("requestId").toString());
					String type = jsonObj.getJSONObject("response").getString("mimeType").toString();
					if (type.startsWith("image")) {
						res.setType("image");
					} else {
						res.setType(type.split("/")[1]);
					}
					res.setUrl(jsonObj.getJSONObject("response").getString("url").toString());
					res.setDataLength(jsonObj.getJSONObject("response").getJSONObject("headers").getString("Content-Length").toString());
				}
				page.getResources().add(res);
			}catch(Exception e){}
		}
	}
	
	private static Resource findRequestId(List<Resource> res, Resource re){
		return null;
	}
	
	private static void pageLoadTime(WebDriver driver, Page page){
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
	    long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
	    page.setPageLoadTime((loadEventEnd - navigationStart)/1000);
	}
	
}
