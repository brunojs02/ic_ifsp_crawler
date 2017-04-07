import br.edu.ifsp.arq.ic.webcrawler.crawler.WebCrawler;

public class Teste {

	public static void main(String[] args) {
		try{
			//String domain = args[0];
			//Integer qtdThreads = Integer.parseInt(args[1]);
			new WebCrawler("");
		}catch(Exception e){
			System.out.println("Necessário informar o dominio de start e a quantidade de workers");
		}
	}
	
}
