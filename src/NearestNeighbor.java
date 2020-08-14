import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NearestNeighbor {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Programming Fundamentals");
		System.out.println("Name: Jason Vargas");
		System.out.println("PROGRAMMING ASSIGNMENT 3");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the name of the training file: ");
		String file1 = scan.nextLine();
		
		System.out.print("Enter the name of the testing file: ");
		String file2 = scan.nextLine();
		
		File fTrain = new File(file1);
		File fTest = new File(file2);

		Scanner fileTrain = new Scanner(fTrain);
		Scanner fileTest = new Scanner(fTest);

		System.out.println();
		System.out.println("EX#: TRUE LABEL, PREDICTED LABEL");

	}
	
	/* QUADTRATIC FORM
	 * distance = (double) (Math.sqrt(Math.pow(w2-w1, 2))+(Math.pow(x2-x1, 2)) + 
	 * (Math.pow(y2-y1, 2)) + (Math.pow(z2-z1, 2)));
	 * 
	 */

}
