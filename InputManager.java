//Handles taking in input from the user
//Made by Yehonatan (Jonathan) Shabash

import java.util.Scanner;
import java.util.LinkedList;

public class InputManager{
	
	private Scanner reader;
	private long[] polynomial;
	private long alpha_min;
	private long alpha_max;
	
	public void getInput(){
		openReader();
		userSetPolynomial();
		userSetAlphaMin();
		userSetAlphaMax();
		closeReader();
	}
	
	public long[] getPolynomial()
	{
		return polynomial;
	}
	
	public long getAlphaMin()
	{
		return alpha_min;
	}
	
	public long getAlphaMax()
	{
		return alpha_max;
	}
	
	public void openReader()
	{
		reader = new Scanner(System.in);
	}
	
	public void closeReader()
	{
		reader.close();
	}
	
	public void userSetPolynomial()
	{
		printInstructionsPolynomial();
		
		//Take in input
		LinkedList<Long> polynomial_list = new LinkedList<Long>();
		boolean polynomial_confirmed = false;
		while(polynomial_confirmed == false)
		{
			long counter = 0;
			while(true)
			{
				if (counter == 0)
				{
					System.out.print("Please enter the coefficient on x^n: ");
				}
				else
				{
					System.out.print("Please enter the coefficient on x^(n-" + counter + "): ");
				}

				String input_string = reader.nextLine();			

				//Check if instruction was entered and if so, process it
				if (input_string.equals("b") || input_string.equals("B") || input_string.equals("back") || input_string.equals("Back"))
				{
					if (polynomial_list.size() > 0)
					{
						polynomial_list.removeFirst();
						counter--;
					}
				}
				else if (input_string.equals("r") || input_string.equals("R") || input_string.equals("restart") || input_string.equals("Restart") || input_string.equals("reset") || input_string.equals("Reset"))
				{
					counter = 0;
				}
				else if (input_string.equals("q") || input_string.equals("Q") || input_string.equals("quit") || input_string.equals("Quit"))
				{
					System.exit(0);
				}
				else if (input_string.equals(""))
				{
					//Check that the user didn't enter an empty polynomial
					if (polynomial_list.size() > 0)
					{
						break;
					}
					else
					{
						System.out.println("I'm sorry, you did not enter a polynomial. Please try again.");
					}
				}
				
				//Otherwise, check if it's a integer. If it is an integer, add it to the polynomial and increment the counter.
				else
				{
					try
					{
						long input_long = Long.parseLong(input_string);
						polynomial_list.addLast(input_long);
						counter++;
					}
					catch (NumberFormatException e)
					{
						System.out.println("I'm sorry, I did not understand your input. Please try again.");
					}
				}
			}
			
			//Insert linked list elements into array
			int n = polynomial_list.size();
			polynomial = new long[(int)n];
			for (int i = 0; i < n; i++)
			{
				polynomial[i] = polynomial_list.poll();
			}
			
			//Show input to user
			System.out.println();
			System.out.print("You have entered: ");
			for (int i = 0; i < n; i++)
			{
				
				if (n-i-1 > 0)
				{
					System.out.print(polynomial[i] + "x^(" + (n-i-1) + ") + ");
				}
				else
				{
					System.out.print(polynomial[i]);
				}
			}
			System.out.println(", is this correct?");
			System.out.println();
			
			//Confirm input is correct
			boolean polynomial_response_given = false;
			while (polynomial_response_given == false)
			{
				System.out.print("(Type \"Yes\" or \"No\"): ");
				String input_string = reader.nextLine();			
				if (input_string.equals("Yes") || input_string.equals("yes") || input_string.equals("Y") || input_string.equals("y"))
				{
					polynomial_response_given = true;
					polynomial_confirmed = true;
				}
				else if (input_string.equals("No") || input_string.equals("no") || input_string.equals("N") || input_string.equals("n"))
				{
					polynomial_response_given = true;
				}
				else if (input_string.equals("b") || input_string.equals("B") || input_string.equals("back") || input_string.equals("Back"))
				{
					polynomial_response_given = true;
				}
				else if (input_string.equals("r") || input_string.equals("R") || input_string.equals("restart") || input_string.equals("Restart") || input_string.equals("reset") || input_string.equals("Reset"))
				{
					polynomial_response_given = true;
				}
				else if (input_string.equals("q") || input_string.equals("Q") || input_string.equals("quit") || input_string.equals("Quit"))
				{
					System.exit(0);
				}
				else
				{
					System.out.println("I'm sorry, I did not understand your input. Please try again.");
				}
			}
		}
	}
	
	public void userSetAlphaMin()
	{
		printInstructionsAlphaMin();
		
		//Take in input
		boolean alpha_min_confirmed = false;
		while(alpha_min_confirmed == false)
		{
			System.out.print("alpha_min = ");
			String input_string = reader.nextLine();			

			//Check if instruction was entered and if so, process it
			if (input_string.equals("b") || input_string.equals("B") || input_string.equals("back") || input_string.equals("Back"))
			{
				userSetPolynomial();
				printInstructionsAlphaMin();
			}
			else if (input_string.equals("r") || input_string.equals("R") || input_string.equals("restart") || input_string.equals("Restart") || input_string.equals("reset") || input_string.equals("Reset"))
			{
				userSetPolynomial();
				printInstructionsAlphaMin();
			}
			else if (input_string.equals("q") || input_string.equals("Q") || input_string.equals("quit") || input_string.equals("Quit"))
			{
				System.exit(0);
			}
			else if (input_string.equals(""))
			{
				System.out.println("You did not enter anything. Please try again.");
			}
			
			//Otherwise, check if it's an integer
			else
			{
				try
				{
					alpha_min = Long.parseLong(input_string);
					alpha_min_confirmed = true;
				}
				catch (NumberFormatException e)
				{
					System.out.println("I'm sorry, I did not understand your input. Please try again.");
				}
			}
		}
	}
	
	public void userSetAlphaMax()
	{
		printInstructionsAlphaMax();
		
		//Take in input
		boolean alpha_max_confirmed = false;
		while(alpha_max_confirmed == false)
		{
			System.out.print("alpha_max = ");
			String input_string = reader.nextLine();			

			//Check if instruction was entered and if so, process it
			if (input_string.equals("b") || input_string.equals("B") || input_string.equals("back") || input_string.equals("Back"))
			{
				userSetAlphaMin();
				printInstructionsAlphaMax();
			}
			else if (input_string.equals("r") || input_string.equals("R") || input_string.equals("restart") || input_string.equals("Restart") || input_string.equals("reset") || input_string.equals("Reset"))
			{
				userSetPolynomial();
				userSetAlphaMin();
				printInstructionsAlphaMax();
			}
			else if (input_string.equals("q") || input_string.equals("Q") || input_string.equals("quit") || input_string.equals("Quit"))
			{
				System.exit(0);
			}
			else if (input_string.equals(""))
			{
				System.out.println("You did not enter anything. Please try again.");
			}
			
			//Otherwise, check if it's an integer greater than or equal to alpha_min
			else
			{
				try
				{
					long input_long = Long.parseLong(input_string);
					if (input_long >= alpha_min)
					{
						alpha_max = input_long;
						alpha_max_confirmed = true;
					}
					else
					{
						System.out.println("That is not a valid value of alpha_max. Please enter an integer that is equal to or greater than alpha_min.");
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("I'm sorry, I did not understand your input. Please try again.");
				}
			}
		}
	}
	
	
	//Instructions to user for entering alpha_max
	private void printInstructionsPolynomial()
	{
		System.out.println();
		System.out.println("Please enter your polynomial, one coefficient at a time, starting with the coefficient on the highest degree term.");
		System.out.println("After entering each coefficient, press enter.");
		System.out.println("Remember that all coefficients must be integers.");
		System.out.println("Enter \"b\" to go back one step, \"r\" to restart or \"q\" to quit.");
		System.out.println("When you are done hit enter twice in a row.");
		System.out.println();
	}
		
	//Instructions to user for entering alpha_min
	private void printInstructionsAlphaMin()
	{
		System.out.println();
		System.out.println("We will use Eisenstein's Criterion on the polynomial with all shift values \"alpha\" such that alpha is (inclusively) between \"alpha_min\" and \"alpha_max\".");
		System.out.println("Please enter the value of alpha_min you would like to use.");
		System.out.println("alpha_min must be an integer.");
		System.out.println("Enter \"b\" to go back one step, \"r\" to restart or \"q\" to quit.");
		System.out.println();
	}
	
	//Instructions to user for entering alpha_max
	private void printInstructionsAlphaMax()
	{
		System.out.println();
		System.out.println("Please enter the value of alpha_max you would like to use.");
		System.out.println("alpha_max must be an integer greater than or equal to alpha_min.");
		System.out.println("Enter \"b\" to go back one step, \"r\" to restart or \"q\" to quit.");
		System.out.println();
	}
}