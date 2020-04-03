package eg.edu.alexu.csd.datastructure.stack;

/**
 * class for stack implementation
 * @author Mohamed
 * 
 */
public class Stack implements IStack{
	private int size=0;
	private Node top=null;

	
	/**
	 * Nodes of the stack contains a values
	 * @param element 
	 * and a next node
	 * @param Next
	 */
    private class Node{
    	private Object elem=null;
    	private Node next=null;
    	private Node(Object element, Node Next) {
    		this.elem=element;this.next=Next;
    	}
    }
    

	/**
	 *pop top element from the stack
     *
	 * @return element
	 */
	public Object pop() {
		
		if(size==0) {throw new IllegalStateException("Stack is empty");}
		else {
			size--;
			Object temp=top.elem;
			top=top.next;
			return temp;
		}}

	/**
	 *		
	 * get the value of top element
	 * throw exception if stack is empty
	 * @return top element without removing it
	 */

	public Object peek() {

		if(size==0) {throw new IllegalStateException("Stack is empty");}
		else {
			return top.elem;
		}
	}


	/**
	 *insert an element to the stack
	 *@param element
	 */
	public void push(Object element) {
		if(size==0) {size++;top=new Node(element,null);}
		else {
			size++;Node u=new Node(element,top);
			top=u;
		}
	}
	
	
	/**
	 *check if the stack is empty
	 *@return boolean value which is true if stack is empty and false otherwise
	 */
	public boolean isEmpty() {
		return(size==0);
	}

	/**
	 *return the size of the stack
	 *@return size
	 */
	public int size() {
		return this.size;
	}
}
