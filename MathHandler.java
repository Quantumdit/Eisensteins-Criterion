import java.util.ArrayList;
import java.util.ListIterator;

public class MathHandler{
	
	public static LongPair[] PrimeFactorization(long number)
	{
		ArrayList<Long> primes = new ArrayList<Long>();				//List of primes already discovered
		ArrayList<LongPair> factorizationList = new ArrayList<LongPair>();	//List of prime factors with their exponents already discovered
		long possiblePrime = 2;												//We'll start with two, the first prime number
		while (number != 1)
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
				LongPair timesDivisiblePair = findTimesDivisible(number, possiblePrime);		//How many times does nextPrime divide the number?
				long timesDivisible = timesDivisiblePair.getFirst();
				if (timesDivisible > 0)
				{
					//System.out.prlongln(possiblePrime);		//DEBUG
					//System.out.prlongln(timesDivisible);		//DEBUG
					factorizationList.add(new LongPair(possiblePrime, timesDivisible));
					number = timesDivisiblePair.getSecond();								//Set number to be the remainder after the division
				}
			}
			possiblePrime++;
		}
		return (LongPair[])factorizationList.toArray(new LongPair[1]);				//return factorization as an array (rather than an ArrayList)
	}
	
	//Returns the number of times that divisor divides number, along with the remainder
	public static LongPair findTimesDivisible(long number, long divisor)
	{
		long counter = 0;
		while(number % divisor == 0)
		{
			counter++;
			number = number / divisor;
		}
		return new LongPair(counter,number);
	}
	
	//Computes powers of long values
	public static long longPow(long base, long exponent)
	{
		if (exponent == 0)
		{
			return 1;
		}
		if (exponent == 0)
		{
			return base;
		}
		if ((exponent % 2) == 0)
		{
			return longPow(base*base,exponent/2);
		}
		else
		{
			return base * longPow(base*base, exponent/2);
		}
	}
}