package profiling;

import java.util.ArrayList;
import java.util.Scanner;

class Profiling
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			numbers.add(scanner.nextInt());
		}
		scanner.close();
		System.out.println(calculate(numbers));
	}

	public static double calculate(ArrayList<Integer> numbers)
	{
		//TODO
		return 0;
	}
}
