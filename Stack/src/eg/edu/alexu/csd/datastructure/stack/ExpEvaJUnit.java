package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Mohamed
 *
 */
class ExpEvaJUnit {

	@Test
	void test() {
		//all the result is rounded to integer to keep the interface's implementation
		ExpressionEvaluator s = new ExpressionEvaluator();
		assertEquals("0 a - 3.1 0 c - / +",s.infixToPostfix(" -a+ 3.1/-c"));
		assertEquals("0 5 - 3 0 9 - / +",s.infixToPostfix(" -5+ 3/-9"));
		assertEquals("5.2 0 / 2.3 0 5 - * +",s.infixToPostfix(" 5.2   /0 + 2.3 * -5"));
		try {assertEquals("Can't divide by zero",s.infixToPostfix("5 0 / 2 0 5 - * +"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		assertEquals(-5,s.evaluate("0 5 - 3 0 9 - / +"));
		assertEquals("x 5.2 4 / + x y * - 2.2 0 5 - / 5 y * + -",s.infixToPostfix("x+5.2/4-x*y-(2.2/-5+5*y)"));
		assertEquals("88 5 4 / + 88 9 * - 2 0 5 - / 5 9 * + -",s.infixToPostfix("88+5/4-88*9-(2/-5+5*9)"));
		assertEquals(-747,s.evaluate("88 5 4 / + 88 9 * - 2 0 5 - / 5 9 * + -"));
		assertEquals("0 0 0 2.3 - 0 5.3 - * - - 0 2.6 0 3.6 - + - / 0 0 1 - - - 2 31 2 5 / - * 0 12 - * - 5 5 / +",s.infixToPostfix("--(-2.3*-5.3)/-(2.6++-3.6)---1-2(31-2/5)(-12)+5/5"));
		assertEquals(40,s.evaluate("0 0 3 - 5 * 0 2 3 * 0 2 - / 5 + 0 0 2 - - + - + 3 0 1 - * - - 0 2 - / 0 5 - *"));
		assertEquals("2 0 2 - / 0 0 0 3 - - - / 0 5 - * 0 1 - *",s.infixToPostfix("(2)/(-2)/-(-(-3))*-5(-1)"));
		assertEquals(2,s.evaluate("2 0 2 - / 0 0 0 3 - - - / 0 5 - * 0 1 - *"));
		assertEquals("a b c * -",s.infixToPostfix("(a)-(b)(c)"));
		assertEquals("0 a - b c * -",s.infixToPostfix("-(a)-b(c)"));
		assertEquals(-2,s.evaluate("  0  0 0 0  0  2   - - -    - -"));
		assertEquals("0 0 0 2 0 0 332 - - / - - - 0 0 332 - - * 0 5 - 0 2 0 332 - * 3 1 - * 2 5 / - 0 0 5 - - 0 332 - * + - + 4 0 2 - / + *",s.infixToPostfix("---(2/--332)*--332(-5+-(2*-332(3-1)-2/5++--+5*-332)+4/-2)"));
		assertEquals(-5963,s.evaluate("0 0 0 2 0 0 332 - - / - - - 0 0 332 - - * 0 5 - 0 2 0 332 - * 3 1 - * 2 5 / - 0 0 5 - - 0 332 - * + - + 4 0 2 - / + *"));
		assertEquals("a b / c - d e * + a c * -",s.infixToPostfix("a /b -c + d * e - a  *c"));
		assertEquals("a b c - d + / e a - * c *",s.infixToPostfix(" ( a/(b - c +   d))*(e  - a)*  c"));
		assertEquals("0 1 - 0 5 0 5 - / 0 5 - / 2 5 - * 6 3 1 - * - 0 3 5 * 3 2 / + - - - * 3 0 0 3 - 5 * 0 2 3 * 0 2 - / 5 + 0 0 2 - - + - + 3 0 1 - * - - / 0 2 - / 0 5 - * -",s.infixToPostfix("-+1*-(5 /-5/-5*(2-5)-6(3-1)--(3*5+3/2))-3/-(-3*5+(-(2*3/-2+5+-(-2)))-(3*-1))/-2*-5"));
		assertEquals(3,s.evaluate("0 1 - 0 5 0 5 - / 0 5 - / 2 5 - * 6 3 1 - * - 0 3 5 * 3 2 / + - - - * 3 0 0 3 - 5 * 0 2 3 * 0 2 - / 5 + 0 0 2 - - + - + 3 0 1 - * - - / 0 2 - / 0 5 - * -"));
		try {assertEquals("Empty expression",s.infixToPostfix("  "));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("*2-5"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("-2-5//5+3*-2"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("ab3a-d+3"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("-(2-3)+(5)/2."));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("-(2-1)+5*"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("-(2-1)+5*"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("-(2-1)+5*"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("-(a.3-1)+5*"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Wrong expression",s.infixToPostfix("-(3-1)31+5"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("wrong Parentheses",s.infixToPostfix("-(3-1)+5)"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("wrong Parentheses",s.infixToPostfix("-(3-1+5"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Empty expression",s.evaluate(""));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Only integer numbers are permitted",s.evaluate("2.3 3 /"));}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Only integer numbers are permitted",s.evaluate("a 3 /"));}
		catch(Exception e) {System.out.println(e.getMessage());}
	}
	}
