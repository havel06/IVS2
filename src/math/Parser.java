package math;
import java.util.ArrayList;

public class Parser
{
	private String m_expression;
	private int m_position;

	public double parse(String expression) throws ParserException
	{
		m_expression = expression;
		m_position = 0;
		return parseExpression();
	}

	static private int ExpectWholeNumber(double num) throws ParserException
	{
		if (num % 1 == 0) {
			return (int)num;
		} else {
			throw new ParserException("Očekáváno celé číslo");
		}
	}

	private void skipWhitespace()
	{
		if (m_position >= m_expression.length()) {
			return;
		}
		while (Character.isWhitespace(m_expression.charAt(m_position))) {
			m_position += 1;
			if (m_position >= m_expression.length()) {
				return;
			}
		}
	}

	private boolean endOfExpression()
	{
		skipWhitespace();
		return m_position >= m_expression.length();
	}

	private char peekChar()
	{
		skipWhitespace();
		return m_expression.charAt(m_position);
	}

	private char consumeChar()
	{
		char result = peekChar();
		m_position += 1;
		return result;
	}

	private int operatorPrecedence(char operator)
	{
		switch (operator) {
			case '^':
				return 0;
			case '*':
			case '/':
				return 1;
			case '+':
			case '-':
				return 2;
			default:
				throw new ParserException("Neznámý operátor");
		}
	}

	private double applyOperator(double lhs, double rhs, char operator)
	{
		switch (operator) {
			case '+':
				return Arithmetic.add(lhs, rhs);
			case '-':
				return Arithmetic.sub(lhs, rhs);
			case '*':
				return Arithmetic.mul(lhs, rhs);
			case '/':
				return Arithmetic.div(lhs, rhs);
			//TODO
			//case '^':
			//	return Arithmetic.pwr(lhs, rhs);
			default:
				throw new ParserException("Neznámý operátor");
		}
	}

	private double parseExpression()
	{
		ArrayList<Double> numbers = new ArrayList<Double>();
		ArrayList<Character> operators = new ArrayList<Character>();

		numbers.add(parsePrimaryExpression());

		while (true) {
			if (endOfExpression() || peekChar() == ')')
				break;

			operators.add(parseOperator());
			numbers.add(parsePrimaryExpression());
		}

		while (!operators.isEmpty()) {
			int nextOperator = 0;

			for (int i = 0; i < operators.size(); i++) {
				if (operatorPrecedence(operators.get(i)) < operatorPrecedence(operators.get(nextOperator))) {
					nextOperator = i;
				}
			}

			numbers.set(nextOperator, applyOperator(numbers.get(nextOperator),
						numbers.get(nextOperator + 1),
						operators.get(nextOperator)));

			numbers.remove(nextOperator + 1);
			operators.remove(nextOperator);
		}
		return numbers.get(0);
	}

	private double parsePrimaryExpression()
	{
		//negated expression
		if (peekChar() == '-') {
			consumeChar();
			return Arithmetic.neg(parsePrimaryExpression());
		}

		double result = 0;

		//expression inside braces
		if (peekChar() == '(') {
			consumeChar(); //consume opening brace
			result = parseExpression();
			consumeChar(); //consume closing brace
		}
		else {
			result = parseNumber();
		}

		//factorial suffix
		if (!endOfExpression() && peekChar() == '!') {
			consumeChar(); //consume factorial symbol
			result = Arithmetic.fac(ExpectWholeNumber(result));
		}

		return result;
	}

	private double parseNumber()
	{
		String buffer = new String();
		while (true) {
			if (endOfExpression())
				break;

			char currentChar = peekChar();

			if (!Character.isDigit(currentChar) && currentChar != '.')
				break;
	
			buffer += currentChar;
			consumeChar();
		}

		//TODO - better exception message
		return Double.parseDouble(buffer);
	}

	private char parseOperator()
	{
		return consumeChar();
	}
}
