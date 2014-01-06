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
    	int word_index = (int) rgen.nextDouble(0, 9);
    	println("word index is " + word_index);
    	String guess_word;
    	hangmanlecxicon = new HangmanLexicon();
    	
    	guess_word = hangmanlecxicon.getWord(word_index);
    	println("the guess word is " + guess_word);
    	
    	// constant check user guessing results and chances left 
    	while (number_of_chances > 0 && isResMatch() != true) {
    		println("The word now looks like this: ");
    		println("You have " + number_of_chances + " guesses left.");
    		//print("Your guess: ");
    		String user_letter = readLine ("Your guess: ");
    		number_of_chances --;
    	}
    	
    	
    	// display final message
    	if (number_of_chances > 0) {
    		println("You guessed the word: " + guess_word);
    		println("You win.");
    	}
    	else {
    		println("You're completely hung.");
    		println("The word was: " + guess_word);
    		println("You lose.");
    	}
    	
	}
    
	private boolean isResMatch () {
		
		return false;
	}

}
