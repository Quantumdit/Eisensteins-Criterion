//A simple class for a pair of integers

public class LongPair{
	
	private long first;
	private long second;
	
	public LongPair(long newFirst, long newSecond)
	{
		first = newFirst;
		second = newSecond;
	}
	
	//Getters
	public long getFirst()
	{
		return first;
	}
	public long getSecond()
	{
		return second;
	}
	
	//Setters
	public void setFirst(long newFirst)
	{
		first = newFirst;
	}
	public void setSecond(long newSecond)
	{
		second = newSecond;
	}
}