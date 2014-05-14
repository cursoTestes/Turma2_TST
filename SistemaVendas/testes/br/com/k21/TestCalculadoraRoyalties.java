package br.com.k21;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private VendaDAO dao;
	private CalculadoraComissao cc;
	
	@Before
	public void preparaMocks() {
		dao = mock(VendaDAO.class);
		cc = mock(CalculadoraComissao.class);
	}

	@Test
	public void calculoParaUmMesSemVendas() {
		int mes = 3;
		int ano = 2014;
		double resultado = 0;
		
		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(Collections.<Venda> emptyList());
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties(dao, cc);
		double retorno = cr.calcula(mes, ano);
		assertEquals(resultado , retorno, 0 );
	}
	
	@Test
	public void calculoParaUmMesComVenda100() {
		int mes = 2;
		int ano = 2014;
		double resultado = (100-5)/5;
		List<Venda> list = new ArrayList<Venda>();
		
		list.add(new Venda(1, 1, mes, ano, 100));
		
		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(list);
		when(cc.calcula(100)).thenReturn(5f);
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties(dao, cc);
		double retorno = cr.calcula(mes, ano);
		assertEquals(resultado , retorno, 0 );
	}

	@Test
	public void calculoParaUmMesComDuasVendasDe100CadaUma() {
		int mes = 2;
		int ano = 2014;
		double resultado = 38.0;
		
		List<Venda> list = new ArrayList<Venda>();
		
		list.add(new Venda(1, 1, mes, ano, 100));
		list.add(new Venda(1, 1, mes, ano, 100));
		
		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(list);
		when(cc.calcula(100)).thenReturn(5f);
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties(dao, cc);
		double retorno = cr.calcula(mes, ano);
		assertEquals(resultado , retorno, 0 );
	}


	@Test
	public void calculoParaUmMesComVenda1000() {
		int mes = 9;
		int ano = 2000;
		double resultado = 200;
		List<Venda> list = new ArrayList<Venda>();
		int valorVenda = 1000;
	
		list.add(new Venda(1, 1, mes, ano, valorVenda));
		
		when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(list);
		when(cc.calcula(Mockito.anyDouble())).thenReturn(0f);
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties(dao, cc);
		double retorno = cr.calcula(mes, ano);
		assertEquals(resultado , retorno, 0 );
		
		Mockito.verify(cc, Mockito.atLeastOnce()).calcula(valorVenda);
	}

	
}
