package merosA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.text.html.HTML;

public class TagMatching { 
	
	public static class Tag { 
		String name; // The name of this tag
		boolean opening; // Is true i. this is an opening tag
		public Tag() 
		{ // Default constructor
			name = "";
			opening = false;
		}
		public Tag(String nm, boolean op) 
		{ 
			// Preferred constructor
			name = nm;
			opening = op; 
		}
		/** Is this an opening tag? */
		public boolean isOpening() 
		{ 
			return opening; 
		}
		/** Return the name of this tag */
		public String getName()
		{
			return name;
		}
	}
	/** Test if every opening tag has a matching closing tag. */
	public static boolean isHTMLMatched(Tag[ ] tag) {
		StringStackImpl<String> S = new StringStackImpl<String>(); // Stack for matching tags
		for
		(int i=0; (i
		<tag.length) && (tag[i] != null); i++) {
			if (tag[i].isOpening())
			S.push(tag[i].getName()); // opening tag; push its name on the stack
			else {
				if (S.isEmpty()) // nothing to match
					return false;
				if (!((String) S.pop()).equals(tag[i].getName())) // wrong match
					return false;
			}
		}
		if (S.isEmpty())
		return true; // we matched everything
		return false; // we have some tags that never were matched
	}
	public final static int CAPACITY = 1000; // Tag array size upper bound
	/* Parse an HTML document into an array of html tags */
	public static Tag[ ] parseHTML(BufferedReader r) throws IOException {
		String line; // a line of text
		boolean inTag = false ; // true iff we are in a tag
		Tag[ ] tag = new Tag[CAPACITY]; // our tag array (initially all null)
		int count = 0 ; // tag counter
		while ((line = r.readLine()) != null) {
			// Create a string tokenizer for HTML tags (use < and > as delimiters)
			StringTokenizer st = new StringTokenizer(line,"<> \t",true);
			while (st.hasMoreTokens()) {
				String token = (String) st.nextToken();
				if (token.equals("<")) // opening a new HTML tag
					inTag = true;
				else if (token.equals(">")) // ending an HTML tag
					inTag = false;
				else if (inTag) { // we have a opening or closing HTML tag
					if ( (token.length() == 0) || (token.charAt(0) != '/') )
						tag[count++] = new Tag(token, true); // opening tag
					else // ending tag
						tag[count++] = new Tag(token.substring(1), false); // skip the
				} // Note: we ignore anything not in an HTML tag
			}
		}
		return tag; // our array of tags
	}

	
	public static void main(String[] args) throws IOException {
		
		String file = args[0];  
		BufferedReader stdr; // Standard Input Reader
		stdr = new BufferedReader(new FileReader(file));  
		if (isHTMLMatched(parseHTML(stdr)))
		System.out.println("The input file is a matched HTML document.");
		else
		System.out.println("The input file is not a matched HTML document.");
		}

}
