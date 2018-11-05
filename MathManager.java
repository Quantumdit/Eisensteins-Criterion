//Handles taking in input from the user
//Made by Yehonatan (Jonathan) Shabash

import java.util.Scanner;
import java.util.LinkedList;

public class MathManager{
	
	private int[] polynomial;
	private int n;				//length of all the polynomial arrays
	private int p_max;
	private int alpha_max;
	
	public MathManager(int[] new_polynomial, int new_p_max, int new_alpha_max){
		setPolynomial(new_polynomial);
		setPMax(new_p_max);
		setAlphaMax(new_alpha_max);
	}
	
	public void setPolynomial(int[] new_polynomial)
	{
		polynomial = new_polynomial;
		n = polynomial.length;
	}
	
	public void setPMax(int new_p_max)
	{
		p_max = new_p_max;
	}
	
	public void setAlphaMax(int new_alpha_max)
	{
		alpha_max = new_alpha_max;
	}
	
	private int[] addPolynomials(int[] polynomial_1, int[] polynomial_2)
	{
		int[] new_polynomial = new int[n];
		for (int i = 1; i < n; i++)
		{
			new_polynomial[i] = polynomial_1[i] + polynomial_2[i];
		}
		return new_polynomial;
	}
	
	//Expand the polynomial b(x+alpha)^c
	private int[] binomialExpansion(alpha, b, c)
	{
		int[] new_polynomial = new int[n];
		
	}
}