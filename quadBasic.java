//Simple (i.e. disgustingly basic) Quadratic Equation Solver
//Code by Ethan MacDonald on 9/20/16.
//No GUI, and don't get me started on i. (It doesn't work yet)

package quad;
import java.util.*;
public class quadBasic {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("(pressing enter after each varible)");
		System.out.println(("(Ax^2 + Bx + C = 0 form)")); System.out.println();
		System.out.println("Enter A, B, and C: ");
		
		double a = input.nextDouble(); //System.out.println(a + " " + b + " " + c);
		double b = input.nextDouble();
		double c = input.nextDouble();
		double discriminate = (b * b) - 4*(a)*(c); //System.out.println(discriminate);
		
		if(discriminate > 0){
			//two roots
			double positiveRoot = ((b * -1) + Math.sqrt(discriminate))/(2 * a);
			double negativeRoot = ((b * -1) - Math.sqrt(discriminate))/(2 * a);
			System.out.println("Roots: " + positiveRoot + " , " + negativeRoot);
		}
		else if(discriminate == 0){
			//one root
			double root = (Math.sqrt(c)) * -1;
			System.out.println(root + " (double root)");
		}
		else if(discriminate < 0){
			//imaginary roots
			System.out.println("Your roots are imaginary and are yet to be implemented");
		}
		else{
			System.out.println("Root: 23(infinite root)");
		}
	}
}
