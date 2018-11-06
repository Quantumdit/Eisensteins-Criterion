//Applies Eisenstein's Criterion using different values of p
//Also allows applying different shift values
//Made by Yehonatan (Jonathan) Shabash


public class main{
	public static void main(String arg[]){
		InputManager im = new InputManager();
		//debug start
//		im.getInput();
//		MathManager math = new MathManager(im.getPolynomial(), im.getPMax(), im.getAlphaMax());
		int[] test_polynomial = {5,4,3,2,1};
		MathManager math = new MathManager(test_polynomial, 20, 20);
		//debug end
		
		//debug start
//		int[] polynomial_1 = {1,2,3,4,5};
//		int[] polynomial_2 = {6,7,8,9,10};
//		int[] polynomial_3 = math.addPolynomials(polynomial_1,polynomial_2);
//		for (int i = 0; i < polynomial_3.length; i++)
//		{
//			System.out.println(polynomial_3[i]);
//		}
		//debug end
		
		//debug start
		//int[] polynomial_4 = math.binomialExpansion(3,4,5);
		//for (int i = 0; i < polynomial_4.length; i++)
		//{
		//	System.out.println(polynomial_4[i]);
		//}
		//debug end
		
		//debug start
		// int[] row = math.generatePascalRow(5);
		// for (int i = 0; i < row.length; i++)
		// {
			// System.out.println(row[i]);
		// }
		//debug end
		
		//debug start
		int[] polynomial_5 = {0,0,1,0,-3};
		System.out.println(math.singleEisensteinCriterion(polynomial_5, 2));
		System.out.println(math.singleEisensteinCriterion(polynomial_5, 3));
		System.out.println(math.singleEisensteinCriterion(polynomial_5, 5));
		System.out.println(math.singleEisensteinCriterion(polynomial_5, 7));
		System.out.println(math.singleEisensteinCriterion(polynomial_5, 11));
		//debug end
	}
}