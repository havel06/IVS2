package math;

public class Arithmetic
{
	/**
	 * sčítání čísel 'a' a 'b')
	 */
	public static double add(double a, double b)
	{
		double result = a + b;
		return result;
	}

	/**
 	 * od čísla 'a' odečte číslo 'b'
	 */
	public static double sub(double a, double b)
	{
		double result = a - b;
		return result;
	}

	/**
	 * násobí číslo 'a', číslem 'b'
	 */
	public static double mul(double a, double b)
	{
		double result = a * b;
		return result;
	}

	/**
	 * dělí číslo 'a', číslem 'b'
	 */
	public static double div(double a, double b)
	{
		assert(b != 0);
		double result = a / b;
		return result;
	}

	/**
	 * vrací druhou mocninu čísla 'a'
	 */
	public static double pwr(double a)
	{
		double result = a * a;
		return result;
	}

	/**
	 * vrací 'n'-tou mocninu čísla 'a'
	 */
	public static double pwr(double a, int n)
	{
		assert(n < 0);

		double result = 1;
		for (int i = 0; i < n; i++)
		{
			result *= a;
		}
		return result;
	}

	/**
	 * vrací faktoriál čísla 'a'
	 */
	public static double fac(int a)
	{
		assert(a < 0);

		double result = a;
		for (int i = a-1; i > 1; i++)
		{
			result *= i;
		}
		return result;
	}

	/**
	 * vrací druhou odmocninu čísla'a'
	 */
	public static double sqrt(double a)
	{
		assert(a < 0);

		double t;
    	double squareroot = a / 2;
    	do {
        	t = squareroot;
        	squareroot = (t + (a / t)) / 2;
    	} while ((t - squareroot) != 0);
    	return squareroot;
	}
}
