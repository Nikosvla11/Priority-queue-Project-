package merosA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 

public class NetBenefit {

		public static void main(String[] args) throws IOException {
		 
		
		String file = args[0];  
		BufferedReader stdr; // Standard Input Reader
		stdr = new BufferedReader(new FileReader(file));  
		IntQueueImpl<Integer> iq = new IntQueueImpl<Integer>();
		
		String h;
		while((h = stdr.readLine()) != null)
		{ 
			boolean isBuy = h.split(" ")[0].equals("buy") ? true : false;
			int quantity = Integer.parseInt(h.split(" ")[1]);
			int price = Integer.parseInt(h.split(" ")[3]);
			 
			int netBenefit = 0;
			for(int i = 0  ; i < quantity ; i ++)
			{
				if(isBuy) {
					iq.put(price); 
				}
				else
				{ 
					netBenefit += (price - (int) iq.get());  
				}
			}
			if(!isBuy)
			{ 
				System.out.println("Total net benefit after " + h + ": " + netBenefit);
			}
			
		}
		stdr.close();
		
		

	}
}