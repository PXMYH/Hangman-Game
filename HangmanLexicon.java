/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;

public class HangmanLexicon {

/** Constructor for HangmanLexicon class */ 
	// open HangmanLexicon.txt file and read in content and put the content into an array list
	public HangmanLexicon() {
		
		String line;
		// open file
		BufferedReader rd = openFile("ShorterLexicon.txt");
		
		try {
			while (true) {
			// open file
			rd = new BufferedReader(new FileReader(".txt"));
			

		} catch (IOException ex) {
			// throw new exception
			throw new ErrorException(ex);
		}
	
		// read in content
		while (true) {
			line = rd.readLine();
			if (line == "") break;
		}
		
		// close file
		rd.close();
		}
	}
	
	private BufferedReader openFile(String file_name) {
		BufferedReader rd = null;
		
		while (rd == null) {
			try {
				// open file
				rd = new BufferedReader(new FileReader(file_name));
			} catch (IOException ex) {
				// throw new exception
				throw new ErrorException(ex);
			}
		}
		return rd;
		
	}
	

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	};
}
