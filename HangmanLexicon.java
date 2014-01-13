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
	// open HangmanLexicon.txt file and read in content
	public HangmanLexicon() {
		
		BufferedReader rd;
		String line;
		
		// open file
		try {
			rd = new BufferedReader(new FileReader("ShorterLexicon.txt"));
		} catch (IOException ex) {
			// throw new exception
			throw new ErrorException;
		}
		
		// read in content
		while (true) {
			line = rd.readLine();
			if (line == "") break;
		}
		
		// close file
		rd.close();
		
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
