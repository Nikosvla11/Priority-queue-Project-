package merosA;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueImpl<T> implements IntQueue<T> {
	
	private class Node<T> {
		 
	    // Data members
	    // 1. Storing value of node
	    T data;
	    // 2. Storing address of next node
	    Node<T> next;
	 
	    // Parameterized constructor to assign value
	    Node(T data)
	    {
	 
	        // This keyword refers to current object itself
	        this.data = data;
	        this.next = null;
	    }
	}
	 
	
	private Node<T> head; 
	private Node<T> tail;
	private int size;
	
	public IntQueueImpl() {
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public boolean isEmpty() {
		if(head == null) {     
            return true;
        } else {
        	return false;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(T item) {
		Node<T> newNode = new Node<T>(item);    
		 
		//Checks if the list is empty    
		if(head == null) {    
		    //If list is empty, both head and tail will point to new node    
		    head = newNode;    
		    tail = newNode;    
		}    
		else {    
		    //newNode will be added after tail such that tail's next will point to newNode    
			tail.next = newNode;    
			//newNode will become new tail of the list    
		    tail = newNode;    
		}   
		size ++;
	}
	
	@SuppressWarnings("unchecked")
	public T get() throws NoSuchElementException {
		/**
	 	 * remove and return the oldest item of the queue
	 	 * @return oldest item of the queue
		 * @throws NoSuchElementException if the queue is empty
		 */
		if(isEmpty())
		{
			new NoSuchElementException();
		}
		
		@SuppressWarnings("unused")
		Node<T> currNode = head, prev = null;  
        head = currNode.next; // Changed head  
        size --;
        return (T) currNode.data; 
	}

	@Override
	@SuppressWarnings("unchecked")
	public T peek() throws NoSuchElementException {
		if(isEmpty())
		{
			new NoSuchElementException();
		}
		 
		return (T) head.data;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void printQueue(PrintStream stream) {
		//Check if empty to print "List is empty"
        if(isEmpty()) {    
            System.out.println("List is empty");    
            return;    
        }    
        
		//Node current will point to head     
        Node<T> current = head;    
        
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    

	}

	@Override
	public int size() {
		return size; //Increases in put and decreases in get, to be implemented in O(1) time as requested.
	}

}
