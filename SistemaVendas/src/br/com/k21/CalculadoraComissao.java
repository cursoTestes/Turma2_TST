package br.com.k21;

public class CalculadoraComissao {

	public float calcula(float valorVenda) {
		
		if (valorVenda <= 10000)
		{
			return (float) (valorVenda*0.05);
		}
		
		return  (float) (valorVenda*0.06);
	}

}
