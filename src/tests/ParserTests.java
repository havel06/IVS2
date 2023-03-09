package tests;

import math.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ParserTests
{
	private Parser parser = new Parser();

	@Test
	public void numbers()
	{
		try {
			assertEquals(parser.parse("3"), 3.0, 0.0);
			assertEquals(parser.parse("42"), 42.0, 0.0);
			assertEquals(parser.parse("1.2"), 1.2, 0.0);
			assertEquals(parser.parse("1 + 2"), 3.0, 0.0);
			assertEquals(parser.parse("2 * 3 - 1"), 5.0, 0.0);
			assertEquals(parser.parse("1 + 3 * 3"), 10.0, 0.0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
