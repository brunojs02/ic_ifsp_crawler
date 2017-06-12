package org.brunojs02.crawler.webdriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverCustom {
	private WebDriver driver;
	public static final Integer CHROME_DRIVER = 1;
	public static final Integer PHANTOM_DRIVER = 2;
	private Logger log = Logger.getLogger("WebDriverCustom");
	
	public WebDriverCustom(Integer webdriver){
		if(WebDriverCustom.CHROME_DRIVER.equals(webdriver)){
			driver = Chrome();
		}else if(WebDriverCustom.PHANTOM_DRIVER.equals(webdriver)) {
			driver = Phantom();
		}else{
			driver = Phantom();
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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
	
	private WebDriver Phantom(){
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/../drivers/phantomjs/bin/phantomjs");
		ArrayList<String> cliArqs = new ArrayList<String>();
		cliArqs.add("--load-images=false");
		cliArqs.add("--max-disk-cache-size=10000");
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArqs);
		LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		return new PhantomJSDriver(caps);
	}
	
	private WebDriver Chrome(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/../drivers/chrome/chromedriver");
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		HashMap<String, Object> preferences = new HashMap<String, Object>(); 
		//preferences.put("profile.managed_default_content_settings.images", 2);
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("prefs", preferences);
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		return new ChromeDriver(caps);
	}
}
