package br.com.fiap.random;

public class Random {	
	public static void main(String[] args) {
		double v1 = 7000;
		double taxa = 0.06;
		
		System.out.println("Valor inicial: " + v1);
		for(int i = 0; i<6; i++){
			double juros = v1*taxa;
			v1 += juros;
			System.out.println("Juros: " + juros);
			System.out.println("Valor ano "+ (i+1) +": " + v1);
		}
		
		
	}
}
