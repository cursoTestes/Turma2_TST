package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;

public class CadastroDeUmaVendaInterfaceTest extends FluentTest {

	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("");
		fill("#DataVenda").with("");
		fill("#Valor").with("");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor é obrigatório.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("O campo Valor é obrigatório.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("O campo Data Venda é obrigatório.", findFirst("#validacaoDataVenda").getText());
					
	}
	
	@Test
	public void teste_cadastra_uma_venda_Com_Id_Branco() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("");
		fill("#DataVenda").with("15/05/2014");
		fill("#Valor").with("100");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor é obrigatório.", findFirst("#validacaoVendedor").getText()); 
					
	}
	
	@Test
	public void teste_cadastra_uma_venda_Com_Id_Texto() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("numero 1");
		fill("#DataVenda").with("15/05/2014");
		fill("#Valor").with("100");
		
		submit("input[type=\"submit\"]");
		
		FluentWebElement findFirst = findFirst("#validacaoVendedor");
		Assert.assertNotNull("deveria encontrar elemento: ",findFirst);
		Assert.assertEquals("O campo Id Vendedor deverá ser numerico.", findFirst.getText()); 
					
	}
	@Test
	public void teste_cadastra_uma_venda_correta() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("1");
		fill("#DataVenda").with("15/05/2014");
		fill("#Valor").with("100");
		
		submit("input[type=\"submit\"]");
		
		FluentWebElement findFirst = findFirst("#mensagemSucesso");
		Assert.assertEquals("Venda Realizada.", findFirst.getText()); 
					
	}

}
