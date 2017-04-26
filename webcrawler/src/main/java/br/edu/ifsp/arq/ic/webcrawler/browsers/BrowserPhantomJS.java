package br.edu.ifsp.arq.ic.webcrawler.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserPhantomJS {
	private WebDriver driver;
	
	public WebDriver getDriver(){
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/../drivers/phantomjs/bin/phantomjs");
		driver = new PhantomJSDriver(caps);
		return driver;
	}
	
}
