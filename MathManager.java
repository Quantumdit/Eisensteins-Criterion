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
	
	public int[] addPolynomials(int[] polynomial_1, int[] polynomial_2)
	{
		int[] new_polynomial = new int[n];
		for (int i = 0; i < n; i++)
		{
			new_polynomial[i] = polynomial_1[i] + polynomial_2[i];
		}
		return new_polynomial;
	}
	
	//Expand the polynomial b(x+alpha)^c
	private int[] binomialExpansion(int alpha, int b, int c)
	{
		int[] new_polynomial = new int[n];
		int[] PascalRow = generatePascalRow(c);
		for (int i = 0; i < c; i++)
		{
			new_polynomial[n-i-1] = PascalRow[i] * intPower(alpha, (c-i));
		}
		return new_polynomial;	
	}
	
	//Generate the row_number'th row of Pascal's triangle
	//Used in binomialExpansion
	//Uses method from http://csharphelper.com/blog/2016/02/calculate-a-row-of-pascals-triangle-in-c/
	private int[] generatePascalRow(int row_number)
	{
		int value = 1;
		int[] row = new int[row_number];
		
		for (int k = 1; k <= row_number; k++)
		{
			value = (value * (row_number + 1 - k)) / row_number;
			row[k-1] = value;
		}
		
		return row;
	}
	
	//Adapted from https://stackoverflow.com/a/20984477/10322945
	private int intPower(int a, int b)
	{
    if ( b == 0)		return 1;
    if ( b == 1)		return a;
    if (b%2 == 0)		return     intPower ( a * a, b/2); //even a=(a^2)^b/2
    else				return a * intPower ( a * a, b/2); //odd  a=a*(a^2)^b/2
	}
	
}