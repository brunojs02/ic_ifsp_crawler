package br.edu.ifsp.arq.ic.webcrawler.browsers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class BrowserPhantomJS {
	private WebDriver driver;
	
	public WebDriver getDriver(){
		File filePathToPhantom = new File("/home/bruno/workspace-ic/phantomjs/bin/phantomjs");
		System.setProperty("phantomjs.binary.path", filePathToPhantom.getAbsolutePath());
		driver = new PhantomJSDriver(); 
		return driver;
	}
	
}
