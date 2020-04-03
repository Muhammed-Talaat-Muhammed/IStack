package eg.edu.alexu.csd.datastructure.stack;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Mohamed
 *
 */
public class StackUI {
public static void main(String[] args) {Scanner sc =new Scanner(System.in);boolean flag = true;
    Stack st = new Stack();
    while(flag) {
	System.out.println("Choose an action (to exit press 6):\r\n" +
	            		"===========================\r\n" +
			            "1: Push\r\n" +
	            		"2: Pop\r\n"   +
	            		"3: Peek\r\n" +
	            		"4: Get size\r\n" +
	            		"5: Check if empty\r\n" +
	            		"===========================\r\n");
	String ch=null;
	try
	{ch=sc.nextLine();}catch (InputMismatchException e) {
	    System.out.println("Invalid input");
	}
	switch(ch) {
	case "1":System.out.println("enter an element to be push it : \r\n");
	String b=sc.nextLine();b=b.trim();/*b=b.replaceAll("\\s+","");*/st.push(b);break;
	case "2":String gg = null;
	try {gg=(String)st.pop();}catch(Exception e) {System.out.println(e.getMessage());}
	System.out.println("The element was in top is : "+gg+"\r\n");break;
	case "3":String gg1=null;
	try {gg1=(String)st.peek();}catch(Exception e) {System.out.println(e.getMessage());}
	System.out.println("The element in top is : "+gg1+"\r\n");break;
	case "4":System.out.println("The size of the Stack is : "+st.size()+"\r\n");break;
	case "5":System.out.println("Stack is empty : "+st.isEmpty()+"\r\n");break;
	case "6":flag=false;break;
	default:System.out.println("Enter a valid choice : \r\n");
	}
	
}System.out.println("-------------------EXIT-------------------");}}
