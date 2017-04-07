import java.util.logging.Logger;

import br.edu.ifsp.arq.ic.webcrawler.crawler.WebCrawler;

public class Teste {
	private static Logger log = Logger.getLogger("Run");
	
	public static void main(String[] args) {
		try{
			//String domain = args[0];
			//Integer qtdThreads = Integer.parseInt(args[1]);
			new WebCrawler("http://arq.ifsp.edu.br/portal/");
		}catch(Exception e){
			log.info(e.toString());
		}
	}
	
}
