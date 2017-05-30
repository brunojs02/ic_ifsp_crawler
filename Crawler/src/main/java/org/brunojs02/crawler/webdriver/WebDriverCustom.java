package org.brunojs02.crawler.webdriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
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
	
	private WebDriver Phantom(){
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/../drivers/phantomjs/bin/phantomjs");
		ArrayList<String> cliArqs = new ArrayList<String>();
		cliArqs.add("--load-images=false");
		cliArqs.add("--disk-cache=false");
		cliArqs.add("--max-disk-cache-size=10000");
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArqs);
		return new PhantomJSDriver(caps);
	}
	
	private WebDriver Chrome(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/../drivers/chrome/chromedriver");
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		HashMap<String, Object> images = new HashMap<String, Object>(); 
		images.put("images", 2);
		HashMap<String, Object> prefs = new HashMap<String, Object>(); 
		prefs.put("profile.default_content_setting_values", images);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type --no-sandbox");
		options.addArguments("--enable-strict-powerful-feature-restrictions");
		options.setExperimentalOption("prefs", prefs);
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver();
	}
}
