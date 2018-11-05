//Applies Eisenstein's Criterion using different values of p
//Also allows applying different shift values
//Made by Yehonatan (Jonathan) Shabash


public class main{
	public static void main(String arg[]){
		InputManager im = new InputManager();
		im.getInput();
		MathManager math = new MathManager(im.getPolynomial(), im.getPMax(), im.getAlphaMax());
		//TODO use http://csharphelper.com/blog/2016/02/calculate-a-row-of-pascals-triangle-in-c/
	}
}