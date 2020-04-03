package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Mohamed
 *
 */
class StackJUnit {

	@Test
	void test() {
		Stack s=new Stack();
		assertEquals(true,s.isEmpty());
		assertEquals(0,s.size());
		try {assertEquals("Stack is empty", s.peek());}
		catch(Exception e) {System.out.println(e.getMessage());}
		try {assertEquals("Stack is empty", s.pop());}
		catch(Exception e) {System.out.println(e.getMessage());}
		s.push(63);
		s.push("aa");
		assertEquals("aa",s.pop());
		assertEquals(1,s.size());
		assertEquals(63,s.peek());
		assertEquals(1,s.size());
		assertEquals(63,s.pop());
		s.push('+');
		assertEquals(1,s.size());
		assertEquals('+',s.peek());
	}

}
