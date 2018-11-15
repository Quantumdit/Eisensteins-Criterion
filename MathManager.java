//Handles taking in input from the user
//Made by Yehonatan (Jonathan) Shabash

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ListIterator;

public class MathManager{
	
	private long[] polynomial;
	private int n;				//length of all the polynomial arrays
	private long[][] pascalTriangle;
	private ArrayList<Long> primes;
	private long alpha_min;
	private long alpha_max;
	
	public MathManager(long[] new_polynomial, long new_alpha_min, long new_alpha_max){
		setPolynomial(new_polynomial);
		n = new_polynomial.length;
		primes = new ArrayList<Long>();
		primes.add((long)2);
		setAlphaMin(new_alpha_min);
		setAlphaMax(new_alpha_max);
	}
	
	public void setPolynomial(long[] new_polynomial)
	{
		polynomial = new_polynomial;
	}
	
	// public void setPMax(long new_p_max)
	// {
		// p_max = new_p_max;
	// }
	
	public void setAlphaMin(long new_alpha_min)
	{
		alpha_min = new_alpha_min;
	}
	
	public void setAlphaMax(long new_alpha_max)
	{
		alpha_max = new_alpha_max;
	}
	
	//Returns 0 in the first element of the pair if failure
	//Returns the working prime and alpha in that order if success
	public LongPair multiEisensteinCriterion()
	{
		for (long alpha = alpha_min; alpha <= alpha_max; alpha++)
		{
			System.out.println("Testing alpha = " + alpha + ".");
			//Build the shifted_polynomial
			long[] shifted_polynomial = new long[n];
			for (int i = 0; i < n; i++)
			{
				shifted_polynomial = addPolynomials(shifted_polynomial, binomialExpansion(alpha, polynomial[i], (n-i-1)));
			}
			
			//Make sure primes has enough elements
			long biggest_coefficient = shifted_polynomial[0];
			for (int i = 0; i < n; i++)
			{
				if (shifted_polynomial[i] > biggest_coefficient)
				{
					biggest_coefficient = shifted_polynomial[i];
				}
			}
			generatePrimes(biggest_coefficient);
			
			//Now see if any of the primes fulfill Eisenstein's Criterion
			ListIterator prime_iterator = primes.listIterator();
			while (prime_iterator.hasNext())
			{
				long candidate_prime = (long)prime_iterator.next();
				if (singleEisensteinCriterion(shifted_polynomial, candidate_prime))
				{
					return new LongPair(candidate_prime, alpha);		//Indicates a success
				}
			}
		}
		
		return new LongPair(0, alpha_max);					//Indicates failure
	}
	
	//Returns true if EisensteinsCriterion applies to f(x+alpha) mod p (so the polynomial is irreducible)
	//Otherwise returns false
	//Remember that false does not necessarily mean reducible
	private boolean singleEisensteinCriterion(long[] shifted_polynomial, long p)
	{
		if (shifted_polynomial[0] % p == 0)
		{
			return false;
		}
		if (shifted_polynomial[n-1] % longPower(p,2) == 0)
		{
			return false;
		}
		for (int i = 1; i < n; i++)
		{
			if (shifted_polynomial[i] % p != 0)
			{
				return false;
			}
		}
		return true;
	}
	
	private long[] addPolynomials(long[] polynomial_1, long[] polynomial_2)
	{
		long[] new_polynomial = new long[n];
		for (int i = 0; i < n; i++)
		{
			new_polynomial[i] = polynomial_1[i] + polynomial_2[i];
		}
		return new_polynomial;
	}
	
	//Expand the polynomial b(x+alpha)^c
	private long[] binomialExpansion(long alpha, long b, int c)
	{
		long[] new_polynomial = new long[n];
		long[] PascalRow = generatePascalRow(c);
		
		for (int i = 0; i <= c; i++)
		{
			new_polynomial[n-i-1] = PascalRow[i] * longPower(alpha, (c-i)) * b;
		}
		return new_polynomial;	
	}
	
	
	//Generate the row_number'th row of Pascal's triangle
	//Used in binomialExpansion
	//Uses method from http://csharphelper.com/blog/2016/02/calculate-a-row-of-pascals-triangle-in-c/
	private long[] generatePascalRow(int row_number)
	{
		long value = 1;
		long[] row = new long[row_number+1];
		row[0] = 1;
		
		for (int k = 1; k <= row_number; k++)
		{
			value = (value * (row_number + 1 - k)) / k;
			row[k] = value;
		}
		
		return row;
	}
	
	//Make sure that primes is at least as long as the input
	private void generatePrimes(long number)
	{
		long current_largest_prime = primes.get(primes.size()-1);
		long possiblePrime = current_largest_prime+1;
		while (possiblePrime < number)
		{
			ListIterator iterator = primes.listIterator();
			boolean isPrime = true;									//Start by assuming that possiblePrime is prime, but we'll see if that's really the case
			while(iterator.hasNext())
			{
				if (possiblePrime % ((Long)iterator.next()).longValue() == 0)		//If possible prime is divisible by a number we know is prime, then possiblePrime is not a prime
				{
					isPrime = false;
				}
			}
			if (isPrime)
			{
				primes.add(possiblePrime);
			}
			possiblePrime++;
		}
	}
	
	//Adapted from https://stackoverflow.com/a/20984477/10322945
	private long longPower(long a, long b)
	{
    if ( b == 0)		return 1;
    if ( b == 1)		return a;
    if (b%2 == 0)		return     longPower ( a * a, b/2); //even a=(a^2)^b/2
    else				return a * longPower ( a * a, b/2); //odd  a=a*(a^2)^b/2
	}
	
}