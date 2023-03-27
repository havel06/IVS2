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
		double result = 0;
		int count = 0;
		for (int num : numbers)
		{
			result += num*num;
			count++;
		}
		double a = average(numbers);
		a = a*a;
		result -= count * a;
		count--;
		result = result / count; 
		result = Math.sqrt(result);
		return result;
	}

	public static double average(ArrayList<Integer> numbers)
	{
		int sum = 0;
		int count = 0;
		for (int num : numbers)
		{
			sum += num;
			count ++;
		}
		double result = sum/count;
		return result;
	}
}
