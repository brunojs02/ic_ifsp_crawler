package org.brunojs02.crawler.util;

import org.brunojs02.crawler.entities.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.JsonException;
import org.json.JSONObject;

public class CrawlerUtil {
	
	public static void generatePerformanceStatistic(WebDriver driver, Page page){
		LogEntries logs = driver.manage().logs().get("performance");
		pageLoadTime(driver, page);
		for(LogEntry log:logs) {
			JSONObject objJson = new JSONObject(log.getMessage());
			try{
				String objectString = objJson.getJSONObject("message").get("method").toString();
				if (objectString.compareToIgnoreCase("Network.requestWillBeSent") == 0) {
					Object obj = objJson.getJSONObject("message").getJSONObject("params").get("requestId").toString();
				} else if (objectString.compareToIgnoreCase("Network.responseReceived") == 0) {
					System.out.println("Requisição recebida");
				}
			}catch(JsonException e){}
		}
	}
	
	private static void pageLoadTime(WebDriver driver, Page page){
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
	    long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
	    page.setPageLoadTime((loadEventEnd - navigationStart)/1000);
	}
	
}
