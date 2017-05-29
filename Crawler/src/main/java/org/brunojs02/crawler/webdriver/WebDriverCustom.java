package org.brunojs02.crawler.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverCustom {
	private WebDriver driver;
	
	public WebDriverCustom(){
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/../drivers/phantomjs/bin/phantomjs");
		driver = new PhantomJSDriver(caps);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void destroyDriver(){
		driver.quit();
	}
}
