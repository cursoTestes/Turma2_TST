package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	

	@Test
	public void testeComissao100retorna5() {
		float valorVenda = 100.0f;
		float valorEsperado = 5.0f;
		float retorno = new CalculadoraComissao().calcula( valorVenda );
		assertEquals(valorEsperado, retorno, 0 );
		
	}
	
	@Test
	public void testeComissao10000retorna500() {
		float valorVenda = 10000.0f;
		float valorEsperado = 500.0f;
		float retorno = new CalculadoraComissao().calcula( valorVenda );
		assertEquals(valorEsperado, retorno, 0 );
		
	}
	@Test
	
	public void testeComissao1retorna0_05() {
		float valorVenda = 1.0f;
		float valorEsperado = 0.05f;
		float retorno = new CalculadoraComissao().calcula( valorVenda );
		assertEquals(valorEsperado, retorno, 0 );
		
	}
	
	@Test
	public void testeComissao110000retorna6600() {
		float valorVenda = 110000.0f;
		float valorEsperado = 6600.0f;
		float retorno = new CalculadoraComissao().calcula( valorVenda );
		assertEquals(valorEsperado, retorno, 0 );
		
	}
	
}
