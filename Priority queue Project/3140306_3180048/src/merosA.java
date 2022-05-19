package merosA;


public class merosA { 
	
	public static void main(String args[])
	{
		System.out.println("Testing IntQueue");
		IntQueueImpl a = new IntQueueImpl();
		a.put(1);
		a.put(2);
		a.printQueue(null);
		
		int gotA = (int) a.get();
		System.out.println("Got " + gotA);
		a.printQueue(null);
		
		System.out.println("Testing StringStack");
		StringStackImpl b = new StringStackImpl();
		b.push("HEY");
		b.push("YO");
		System.out.println(b.peek()); //print YO
		
		b.printStack(null); //Print YO,HEY
		
		System.out.println(b.pop());
		b.printStack(null);
	}
}