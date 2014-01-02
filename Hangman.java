/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	private HangmanLexicon hangmanlecxicon;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	private static final int NTURNS = 8;
	
    public void run() {
    	
    	// variable definition
    	int number_of_chances = NTURNS;
		
    	// Display initial welcome message
    	println("Welcome to Hangman!");
    	
    	// get a guessing word from the dictionary
    	int word_index = (int)rgen.nextDouble(0, 9);
    	String guessing_word = hangmanlecxicon.getWord(word_index);
    	
    	// constant check user guessing results and chances left 
    	while (number_of_chances > 0 && isResMatch() != true) {
    		
    	}
    	
    	
	}
    
	private boolean isResMatch () {
		
		return false;
	}

}
