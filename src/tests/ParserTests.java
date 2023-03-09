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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Test
	public void operators()
	{
		try {
			assertEquals(parser.parse("2 * 3"), 6.0, 0.0);
			assertEquals(parser.parse("1 + 3"), 4.0, 0.0);
			assertEquals(parser.parse("12 - 1"), 11.0, 0.0);
			assertEquals(parser.parse("10 / 4"), 2.5, 0.0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Test
	public void precedence()
	{
		try {
			assertEquals(parser.parse("1 + 2 * 3"), 7.0, 0.0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Test
	public void braces()
	{
		try {
			assertEquals(parser.parse("2 * (1 + 4)"), 10.0, 0.0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Test
	public void factorial()
	{
		try {
			assertEquals(parser.parse("(1 + 3)! + 1"), 25.0, 0.0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Test
	public void negation()
	{
		try {
			assertEquals(parser.parse("-(1 + 3)"), -4.0, 0.0);
			assertEquals(parser.parse("-(-2 - -1)"), 1.0, 0.0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
