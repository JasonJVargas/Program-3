import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NearestNeighbor {

	static double[][] arrayTrain = new double[75][4];
	static double[][] arrayTest = new double[75][4];

	static String[] arrayTrainClass = new String[75];
	static String[] arrayTestClass = new String[75];

	static String[] predictedLabel = new String[75];

	static String fileTrain = "";
	static String fileTest = "";

	public static void main(String[] args) throws IOException {

		System.out.println("Programming Fundamentals");
		System.out.println("Name: Jason Vargas");
		System.out.println("PROGRAMMING ASSIGNMENT 3");
		System.out.println();

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the name of the training file: ");
		fileTrain = scan.next();

		System.out.print("Enter the name of the testing file: ");
		fileTest = scan.next();

		System.out.println();
		System.out.println("EX#: TRUE LABEL, PREDICTED LABEL");

		trainingData();
		testingData();
		printSamples();
		accuracyCalc();
		
		scan.close();
	}

	static void trainingData() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fileTrain))) {
			String line;
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] value = line.split(",");
				for (int col = 0; col < value.length; col++) {
					if (col < 4) {
						arrayTrain[row][col] = Double.parseDouble(value[col]);
					} else {
						arrayTrainClass[row] = value[col];
					}
				}
				row++;
			}
		}
	}

	static void testingData() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fileTest))) {
			String line;
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] value = line.split(",");
				for (int col = 0; col < value.length; col++) {
					if (col < 4) {
						arrayTest[row][col] = Double.parseDouble(value[col]);
					} else {
						arrayTestClass[row] = value[col];
					}
				}
				row++;
			}
		}

	}

	static double distance(double[] testNum, double[] trainNum) {

		double distance = Math.sqrt(Math.pow(trainNum[0] - testNum[0], 2) + Math.pow(trainNum[1] - testNum[1], 2)
				+ Math.pow(trainNum[2] - testNum[2], 2) + Math.pow(trainNum[3] - testNum[3], 2));

		return distance;
	}

	static void printSamples() {
		for (int i = 0; i < arrayTest.length; i++) {
			double[] testNum = arrayTest[i];
			double shortestDistance = 0;
			double sampleDistance = 0;

			int smallestIndex = 0;
			for (int j = 0; j < arrayTrain.length; j++) {
				double[] trainNum = arrayTrain[j];
				sampleDistance = distance(testNum, trainNum);
				if (j == 0) {
					shortestDistance = sampleDistance;
				}
				if (sampleDistance < shortestDistance) {
					shortestDistance = sampleDistance;
					smallestIndex = j;
				}
			}
			predictedLabel[i] = arrayTrainClass[smallestIndex];

			System.out.println(i + 1 + ": " + arrayTestClass[i] + "  " + predictedLabel[i]);

		}
	}

	static void accuracyCalc() {

		int sameClass = 0;
		for (int labels = 0; labels < arrayTestClass.length; labels++) {
			if (arrayTestClass[labels].equalsIgnoreCase(predictedLabel[labels])) {
				sameClass++;
			}
		}
		double accuracy = (double) sameClass / (double) arrayTestClass.length;

		System.out.println("ACCURACY: " + accuracy);

	}
}