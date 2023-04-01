package profiling;

import java.util.ArrayList;
import java.util.Scanner;
import math.Arithmetic;

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
		while (count < numbers.size())
		{
			result = Arithmetic.add(result, Arithmetic.pwr(numbers.get(count)));
			count++;
		}
		double avg = average(numbers);
		avg = Arithmetic.mul(avg, avg);
		result = Arithmetic.sub(result, Arithmetic.mul(count, avg));
		count--;
		if ( count == 0 ){
			throw new ArithmeticException("Neplatné dělení nulou.");
		}
		result = Arithmetic.div(result, count);
		result = Arithmetic.sqrt(result);
		return result;
	}

	/* výpočet aritmetického průměru */
	public static double average(ArrayList<Integer> numbers)
	{
		double sum = 0;
		int count = 0;
		while (count < numbers.size())
		{
			sum = Arithmetic.add(sum, numbers.get(count));
			count++;
		}
		return Arithmetic.div(sum, count);
	}
}
