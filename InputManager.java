//Handles taking in input from the user
//Made by Yehonatan (Jonathan) Shabash

import java.util.Scanner;
import java.util.LinkedList;

public class InputManager{
	
	private Scanner reader;
	private int[] polynomial;
	private int p_max;
	private int alpha_max;
	
	public void getInput(){
		openReader();
		userSetPolynomial();
		userSetPMax();
		userSetAlphaMax();
		closeReader();
	}
	
	public int[] getPolynomial()
	{
		return polynomial;
	}
	
	public int getPMax()
	{
		return p_max;
	}
	
	public int getAlphaMax()
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
		LinkedList<Integer> polynomial_list = new LinkedList<Integer>();
		boolean polynomial_confirmed = false;
		while(polynomial_confirmed == false)
		{
			int counter = 0;
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
						int input_int = Integer.parseInt(input_string);
						polynomial_list.addFirst(input_int);
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
			polynomial = new int[n*n];		//We make the polynomial array extra long so we can easily do math on it later
			for (int i = 0; i < n; i++)
			{
				polynomial[(n*n) - 1 - i] = polynomial_list.poll();
			}
			
			//Show input to user
			System.out.println();
			System.out.print("You have entered: ");
			for (int i = 0; i < n; i++)
			{
				
				if (n-i-1 > 0)
				{
					System.out.print(polynomial[(n*n)-n+i] + "x^(" + (n-i-1) + ") + ");
				}
				else
				{
					System.out.print(polynomial[(n*n)-n+i]);
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
			//TODO set p_min and p_max, both integers strictly greater than 1 where p_min =< p_max
			
	public void userSetPMax()
	{
		printInstructionsPMax();
	
		//Take in input
		boolean p_max_confirmed = false;
		while(p_max_confirmed == false)
		{
			System.out.print("p_max = ");		
			String input_string = reader.nextLine();			

			//Check if instruction was entered and if so, process it
			if (input_string.equals("b") || input_string.equals("B") || input_string.equals("back") || input_string.equals("Back"))
			{
				userSetPolynomial();
				printInstructionsPMax();
			}
			else if (input_string.equals("r") || input_string.equals("R") || input_string.equals("restart") || input_string.equals("Restart") || input_string.equals("reset") || input_string.equals("Reset"))
			{
				userSetPolynomial();
				printInstructionsPMax();
			}
			else if (input_string.equals("q") || input_string.equals("Q") || input_string.equals("quit") || input_string.equals("Quit"))
			{
				System.exit(0);
			}
			else if (input_string.equals(""))
			{
				System.out.println("You did not enter anything. Please try again.");
			}
			
			//Otherwise, check if it's an integer greater than one
			else
			{
				try
				{
					int input_int = Integer.parseInt(input_string);
					if (input_int > 1)
					{
						p_max = input_int;
						p_max_confirmed = true;
					}
					else
					{
						System.out.println("That is not a valid value of p_max. Please enter an integer greater than one.");
					}
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
				userSetPMax();
				printInstructionsAlphaMax();
			}
			else if (input_string.equals("r") || input_string.equals("R") || input_string.equals("restart") || input_string.equals("Restart") || input_string.equals("reset") || input_string.equals("Reset"))
			{
				userSetPolynomial();
				userSetPMax();
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
			
			//Otherwise, check if it's an integer greater than one
			else
			{
				try
				{
					int input_int = Integer.parseInt(input_string);
					if (input_int >= 0)
					{
						alpha_max = input_int;
						alpha_max_confirmed = true;
					}
					else
					{
						System.out.println("That is not a valid value of alpha_max. Please enter a non-negative integer.");
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
	
	//Instructions to user for entering alpha_max
	private void printInstructionsPMax()
	{
		System.out.println();
		System.out.println("We will use Eisenstein's Criterion on the polynomial with all primes \"p\" such that p is less than or equal to \"p_max\".");
		System.out.println("Please enter the value of p_max you would like to use.");
		System.out.println("p_max must be an integer that is greater than one, but does not have to be prime.");
		System.out.println("Enter \"b\" to go back one step, \"r\" to restart or \"q\" to quit.");
		System.out.println();
	}
	
	//Instructions to user for entering alpha_max
	private void printInstructionsAlphaMax()
	{
		System.out.println();
		System.out.println("We will use Eisenstein's Criterion on the polynomial with all shift values \"alpha\" such that alpha is less than or equal to \"alpha_max\".");
		System.out.println("Please enter the value of alpha_max you would like to use.");
		System.out.println("p_max must be a non-negative integer.");
		System.out.println("Enter \"b\" to go back one step, \"r\" to restart or \"q\" to quit.");
		System.out.println();
	}
}