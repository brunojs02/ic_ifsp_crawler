import org.openqa.selenium.WebDriver;

import br.edu.ifsp.arq.ic.webcrawler.browsers.BrowserPhantomJS;
import br.edu.ifsp.arq.ic.webcrawler.lojas.Americanas;


public class Teste {

	public static void main(String[] args) {
		WebDriver driver = new BrowserPhantomJS().getDriver();
		
		driver.get(Americanas.DOMAIN);
		
		driver.quit();
	}
	
}
