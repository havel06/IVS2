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
		if (b == 0){
			throw new ArithmeticException("tried to divide by zero");
		}
		else {
			double result = a / b;
			return result;
		}
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
		if ( n < 0 )
		{
			double result;
			double b = neg(n);
			result = div(1, pwr(a,b));
			return result;
		}
		else
		{
			double result = 1;
			for (int i = 0; i < n; i++)
			{
				result *= a;
			}
			return result;
		}
		
	}

	/*
	 * vrací 'n'-tou mocninu čísla 'a'
	 * pro čísla s dessetinnou čárkou
	 */
	public static double pwr(double a, double b)
	{
		double result = Math.pow(a,b);
		return result;
	}


	/**
	 * vrací faktoriál čísla 'a'
	 */
	public static double fac(int a)
	{
		if ( a < 0)
		{
			throw new ArithmeticException("tried to fac non natural number");
		}
		else if ( a == 0 )
		{
			return 0;
		}
		else if ( a == 1 )
		{
			return 1;
		}

		double result = a;
		for (int i = a-1; i > 1; i--)
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
		if ( a < 0 )
		{
			throw new ArithmeticException("tried to sqrt negative number");
		}
		double result = Math.sqrt(a);
    	return result;
	}

	/*
	 * vrací n-tou odmocninu čísla 'a'
	 * k tomu využívá stávající funkci sqrt() pro druhou odmocninu
	 */
	public static double sqrt(double a, int b)
	{
		if ( a < 0 )
		{
			throw new ArithmeticException("tried to sqrt negative number");
		}
		if ( b < 2 )
		{
			throw new ArithmeticException("tried to sqrt with negative number");
		}
		double result = a;
		for (int i = 0; i < b-1; i++)
		{
			result = sqrt(result);
		}
		return result;
	}
	
	/*
	 * vrací negovanou hodnotu čísla 'a'
	 */
	public static double neg(double a)
	{
		double result = 0 - a;
		return result;
	}
}
