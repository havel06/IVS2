package math;
import java.util.ArrayList;

/** Vyhodnocuje matematické výrazy, s ohledem na precedenci operátorů. */
public class Parser
{
	private String m_expression;
	private int m_position;

	/** Vyhodnotí výraz vyjádřený řetězcem.
	 * @param expression Výraz k vyhodnocení.
	 */
	public double parse(String expression) throws ParserException
	{
		m_expression = expression;
		m_position = 0;
		return parseExpression();
	}

	/** Pokud je argument celé číslo, vrátí hodnotu přetypovanou na int, jinak vyhodí výjimku.
	 * @param num Vstupní hodnota.
	 */
	static private int ExpectWholeNumber(double num) throws ParserException
	{
		if (num % 1 == 0) {
			return (int)num;
		} else {
			throw new ParserException("Očekáváno celé číslo");
		}
	}

	/** Posune aktuální pozici čtení na první následující nebílý znak. */
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

	/** Vrátí true, pokud výraz neobsahuje další nebílé znaky. */
	private boolean endOfExpression()
	{
		skipWhitespace();
		return m_position >= m_expression.length();
	}

	/** Vrátí následující nebílý znak, pozice čtení zůstane na tomto znaku. */
	private char peekChar()
	{
		skipWhitespace();
		return m_expression.charAt(m_position);
	}

	/** Vrátí následující nebílý znak, pozice čtení se přesune o jeden znak dál. */
	private char consumeChar()
	{
		char result = peekChar();
		m_position += 1;
		return result;
	}

	/** Vrátí pořadí, ve kterém by měl být operátor vykonán. Menší hodnota značí dřívější vykonání.
	 * @param operator Operátor k vyhodnocení
	 */
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

	/** Aplikuje binární operátor.
	 * @param lhs Hodnota na levé straně operátoru.
	 * @param rhs Hodnota na pravé straně operátoru.
	 * @param operator Operátor k provedení.
	 */
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

	/** Vyhodnotí výraz na čtecí pozici, zakončený koncem souboru nebo uzavírací závorkou. */
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

	/** Vyhodnotí primární výraz, tj. výraz v závorkách nebo číslo. */
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

	/** Vyhodnotí hodnotu čísla na čtecí pozici. */
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

	/** Vrátí operátor na aktuální čtecí pozici. */
	private char parseOperator()
	{
		return consumeChar();
	}
}
