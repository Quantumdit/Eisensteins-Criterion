//Applies Eisenstein's Criterion using different values of p
//Also allows applying different shift values
//Made by Yehonatan (Jonathan) Shabash


public class main{
	public static void main(String arg[]){
		InputManager im = new InputManager();
		im.getInput();
		MathManager math = new MathManager(im.getPolynomial(), im.getPMax(), im.getAlphaMax());
		
		//debug start
//		int[] polynomial_1 = {1,2,3,4,5};
//		int[] polynomial_2 = {6,7,8,9,10};
//		int[] polynomial_3 = math.addPolynomials(polynomial_1,polynomial_2);
//		for (int i = 0; i < polynomial_3.length; i++)
//		{
//			System.out.println(polynomial_3[i]);
//		}
		//debug end
	}
}