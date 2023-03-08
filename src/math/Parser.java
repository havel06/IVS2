package math;

public class Parser
{
	private String m_expression;
	private int m_position;

	public double parse(String expression) throws Exception
	{
		m_expression = expression;
		m_position = 0;
		return parseSubExpression();
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

	private char peekChar() throws Exception
	{
		skipWhitespace();
		return m_expression.charAt(m_position);
	}

	private char consumeChar() throws Exception
	{
		char result = peekChar();
		m_position += 1;
		return result;
	}

	private double parseSubExpression() throws Exception
	{
		//TODO	
		return parseNumber();
	}

	private double parseNumber() throws Exception
	{
		String buffer = new String();
		buffer += consumeChar();
		while (true)
		{
			if (endOfExpression())
				break;

			char currentChar = peekChar();

			if (!Character.isDigit(currentChar) && currentChar != '.')
				break;
	
			buffer += currentChar;
			consumeChar();
		}

		return Double.parseDouble(buffer);
	}

	private char parseOperator() throws Exception
	{
		//TODO
		return ' ';
	}
}
