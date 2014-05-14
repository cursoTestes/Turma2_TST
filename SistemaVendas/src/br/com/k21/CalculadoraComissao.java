package br.com.k21;

public class CalculadoraComissao {

	public float calcula(double d) {
		
		if (d <= 10000)
		{
			return (float) (d*0.05);
		}
		
		return  (float) (d*0.06);
	}

}
