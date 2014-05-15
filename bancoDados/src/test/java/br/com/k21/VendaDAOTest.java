package br.com.k21;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.com.k21.Vendedor;
import br.com.k21.dao.VendaDAO;
import br.com.k21.dao.VendedorDAO;
import br.com.k21.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {
	
	@Test
	public void testTotal_Vendas_Para_Um_Vendedor_Sem_Vendas() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2010;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}
	
	@Test
	public void testTotal_Vendas_Para_Um_Vendedor_Com_Uma_Venda() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 1;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}
	
	@Test
	public void testTotal_Vendas_Para_Um_Vendedor_Com_Duas_Vendas() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2012;
		double resultado;
		double esperado = 300.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}

	@Test
	public void testTotal_Vendas_Para_Um_Vendedor_Com_Duas_Vendas_De_Anos_Diferentes() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 5;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2013;
		double resultado;
		double esperado = 300.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}

	@Test
	public void testTotal_Vendas_Para_Um_Vendedor_Com_Uma_Venda_Compartilhada() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 6;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2013;
		double resultado;
		double esperado = 100.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}
	
	@Test
	public void testTotal_Vendas_Para_Um_Vendedor_Com_Uma_Venda_Compartilhada_E_Venda_Unitaria() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 7;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2013;
		double resultado;
		double esperado = 500.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);	
	}

	
}
