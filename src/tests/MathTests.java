package tests;

import math.*;
import static org.junit.Assert.*;

import javax.accessibility.AccessibleAttributeSequence;

import org.junit.Test;

public class MathTests
{
	@Test
	public void addition()
	{
		assertEquals(4d, Arithmetic.add(2, 2), 0);
		assertEquals(50d, Arithmetic.add(100, -50), 0);
		assertEquals(-100d, Arithmetic.add(-50, -50), 0);
		assertEquals(2.3567d, Arithmetic.add(2, 0.3567), 0);
	}
	@Test
	public void subtraction()
	{
		assertEquals(0d, Arithmetic.sub(0, 0), 0);
		assertEquals(15d, Arithmetic.sub(30, 15), 0);
		assertEquals(-40d, Arithmetic.sub(60, 100), 0);
		assertEquals(-69d, Arithmetic.sub(-60, 9), 0);
		assertEquals(0.431d, Arithmetic.sub(1, 0.569), 0);
	}
	@Test
	public void multiplication()
	{
		assertEquals(25d, Arithmetic.mul(5,5), 0);
		assertEquals(0d, Arithmetic.mul(5,0), 0);
		assertEquals(-6d, Arithmetic.mul(2, -3), 0);
		assertEquals(-12d, Arithmetic.mul(-12, 1), 0);
		assertEquals(100d, Arithmetic.mul(-10, -10), 0);
	}
	@Test
	public void division()
	{
		assertThrows(Exception.class, () -> { Arithmetic.div(4, 0); });
		assertEquals(10d, Arithmetic.div(100, 10), 0);
		assertEquals(0d, Arithmetic.div(0, 4), 0);
		assertEquals(2.5d, Arithmetic.div(5, 2), 0);
		assertEquals(4d, Arithmetic.div(2, 0.5), 0);
		assertEquals(-5d, Arithmetic.div(-20, 4), 0);
		assertEquals(5d, Arithmetic.div(-20, -4), 0);
	}
	@Test
	public void power2()
	{
		assertEquals(4d, Arithmetic.pwr(2), 0);
		assertEquals(4d, Arithmetic.pwr(-2), 0);
		assertEquals(0.25d, Arithmetic.pwr(0.5), 0);
		assertEquals(0.25d, Arithmetic.pwr(-0.5), 0);
	}
	@Test
	public void powerN()
	{
		assertEquals(8d, Arithmetic.pwr(2,3), 0);
		assertEquals(-8d, Arithmetic.pwr(-2, 3), 0);
		assertEquals(0d, Arithmetic.pwr(5, 0), 0);
		assertEquals(0.125d, Arithmetic.pwr(0.5, 3), 0);
		assertThrows(Exception.class, () -> { Arithmetic.pwr(4, -6); });
	}
	@Test
	public void factorial()
	{
		assertEquals(720d, Arithmetic.fac(6), 0);
		assertEquals(6d, Arithmetic.fac(3), 0);
		assertEquals(0d, Arithmetic.fac(0), 0);
		assertThrows(Exception.class, () -> { Arithmetic.fac(-5); });
	}
	@Test
	public void squareroot2()
	{
		//assertThrows(Exception.class, () -> { Arithmetic.sqrt(-8); });
		//assertEquals(0d, Arithmetic.sqrt(0), 0);
		//assertEquals(2d, Arithmetic.sqrt(4), 0);
		//assertEquals(8.306623862918075d, Arithmetic.sqrt(69), 0);
	}
	@Test
	public void squarerootN()
	{
		//assertThrows(Exception.class, () -> {Arithmetic.sqrt(-8, 4); });
		//assertThrows(Exception.class, () -> {Arithmetic.sqrt(8, -4); });		
		//assertEquals(10d, Arithmetic.sqrt(1000, 3), 0);
		//assertEquals(0d, Arithmetic.sqrt(0, 100), 0);		
	}
	@Test
	public void negation()
	{
		assertEquals(0d, Arithmetic.neg(0), 0);
		assertEquals(100d, Arithmetic.neg(-100), 0);
		assertEquals(-100d, Arithmetic.neg(100), 0);
	}
}
