package math;

public class Arithmetic
{
	/**
	 * scitani cisel 'a' a 'b')
	 */
	public static double add(double a, double b)
	{
		double result = a + b;
		return result;
	}

	/**
	 * od cisla 'a' odecte cislo 'b'
	 */
	public static double sub(double a, double b)
	{
		double result = a - b;
		return result;
	}

	/**
	 * nasobi cislo 'a', cislem 'b'
	 */
	public static double mul(double a, double b)
	{
		double result = a * b;
		return result;
	}

	/**
	 * deli cislo 'a', cislem 'b'
	 */
	public static double div(double a, double b)
	{
		assert(b != 0);
		double result = a / b;
		return result;
	}

	/**
	 * druha mocnina cisla 'a'
	 */
	public static double pwr(double a)
	{
		double result = a * a;
		return result;
	}

	/**
	 * 'n'-ta mocnina cisla 'a'
	 */
	public static double pwr(double a, int n)
	{
		double result = a;
		for (int i = 0; i < n; i++)
		{
			result *= a;
		}
		return result;
	}

	/**
	 * faktorial cisla a
	 */
	public static double fak(int a){
		double result = a;
		for (int i = a-1; i > 1; i++)
		{
			result *= i;
		}
		return result;
	}

	/**
	 * druha odmocnina cisla 'a'
	 */
	public static double sqrt(double a){

		double t;
    	double squareroot = a / 2;
  
    	do {
        	t = squareroot;
        	squareroot = (t + (a / t)) / 2;
    	} while ((t - squareroot) != 0);

    	return squareroot;
	
	}
}
