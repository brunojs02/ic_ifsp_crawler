package org.brunojs02.crawler.webdriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverCustom {
	private WebDriver driver;
	private Logger log = Logger.getLogger("WebDriverCustom");
	
	public WebDriverCustom(){
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/../drivers/phantomjs/bin/phantomjs");
		ArrayList<String> cliArqs = new ArrayList<String>();
		cliArqs.add("--load-images=false");
		cliArqs.add("--disk-cache=false");
		cliArqs.add("--max-disk-cache-size=10000");
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArqs);
		driver = new PhantomJSDriver(caps);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1900, 1200));
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void cleanCookies(){
		log.info("Cache before clean size: " + driver.manage().getCookies().size() + " content: " 
				+ driver.manage().getCookies().toString());
		driver.manage().deleteAllCookies();
		log.info("Cache after clean size: " + driver.manage().getCookies().size() + " content: " 
				+ driver.manage().getCookies().toString());
	}
	
	public void destroyDriver(){
		driver.quit();
	}
}
