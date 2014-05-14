package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	
	private VendaDAO dao;
	private CalculadoraComissao cc;

	public CalculadoraRoyalties(VendaDAO dao, CalculadoraComissao cc) {
		super();
		this.dao = dao;
		this.cc = cc;
	}

	public double calcula(int mes, int ano) {
		List<Venda> obterVendasPorMesEAno = dao.obterVendasPorMesEAno(ano, mes);

		double totalLiquido = 0;
		for (Venda venda : obterVendasPorMesEAno) {
			totalLiquido += venda.getValor() - cc.calcula((float)venda.getValor()); 
		}
		
		return totalLiquido * 0.2;
	}

}
