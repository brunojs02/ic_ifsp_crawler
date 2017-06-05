package org.brunojs02.crawler.util;

import org.brunojs02.crawler.entities.Page;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

public class CrawlerUtil {
	
	public static void generatePerformanceStatistic(LogEntries logs, Page page){
		for(LogEntry log:logs) {
			System.out.println(log.getMessage());
		}
	}
	
}
