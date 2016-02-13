package br.com.rd;

import org.junit.Test;

public class Teste {
	
	private String email = "ericocamposlira@gmail.com";
	private String senha = "220390";
	private String nomeSegmentacao = "Erico Teste RD";
	private String termoSegmentacao = "Erico Termo RD";
		
	@Test
	public void criarSegmentacao() {
		Pages pagina = new Pages();
		pagina.acessarHomePage();
		pagina.login(email, senha);
		pagina.acessarSegmentacao();
		pagina.criarSegmentacao(nomeSegmentacao, termoSegmentacao);
	}

}
