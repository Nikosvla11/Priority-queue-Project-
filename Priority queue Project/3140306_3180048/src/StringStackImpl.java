package merosA;

import java.io.PrintStream;
import java.util.NoSuchElementException; 

public class StringStackImpl<T> implements StringStack<T> {

	private class Node<T> {
		 
	    // Data members
	    // 1. Storing value of node
	    T data;
        Node<T> link; // reference variable Node type
	 
	    // Parameterized constructor to assign value
	    Node(T data)
	    {
	 
	        // This keyword refers to current object itself
	        this.data = data;
	        this.link = null;
	    }
	}
	
	private Node<T> top;
	private int size;
	
	public StringStackImpl() {
		top = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void push(T item) {
		Node<T> temp = new Node<T>(item); 
        // put top reference into temp link
        temp.link = top; 
        // update top reference
        size ++;
        top = temp;

	}

	@Override
	@SuppressWarnings("unchecked")
	public T pop() throws NoSuchElementException {
		// update the top pointer to point to the next node
		if(isEmpty())
		{
			new NoSuchElementException();
		}
		T data = (T) top.data;
        top = (top).link;
        size --;
        return data;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T peek() throws NoSuchElementException {
		
		if(isEmpty())
		{
			 new NoSuchElementException();
		}
		
		return (T) top.data;
		 
	}

	@Override
	public void printStack(PrintStream stream) {
		
        Node<T> temp = top;
        while (temp != null) {
 
            // print node data
            System.out.print("->" + temp.data); 
            // assign temp link to temp
            temp = temp.link;
        }
        System.out.println();
    
	}

	@Override
	public int size() { 
		return size; //Return O(1) 
	}

}
