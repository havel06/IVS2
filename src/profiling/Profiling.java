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

	/* výpočet směrodatné odchylky */
	public static double calculate(ArrayList<Integer> numbers)
	{
		double result = 0;
		int count = 0;
		for (int num : numbers)
		{
			result += num*num;
			count++;
		}
		double avg = average(numbers);
		avg = avg*avg;
		result -= count * avg;
		count--;
		if ( count == 0 ){
			throw new ArithmeticException("Neplatné dělení nulou.");
		}
		result = result / count; 
		result = Math.sqrt(result);
		return result;
	}

	/* výpočet aritmetického průměru */
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
