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
	
	private String user_word, guess_word;
	
    public void run() {
    	
    	// variable definition
    	int number_of_chances = NTURNS;
		
    	// Display initial welcome message
    	println("Welcome to Hangman!");
    	
    	// initialize lexicon class
    	hangmanlecxicon = new HangmanLexicon();
    	
    	// get a guessing word from the dictionary
    	int word_index = (int) rgen.nextDouble(0, 9);
    	guess_word = hangmanlecxicon.getWord(word_index);
    	println("the guess word is " + guess_word);
    	
    	user_word = initWord(guess_word);
    	
    	// constant check user guessing results and chances left 
    	while (number_of_chances > 0 && isResMatch() != true) {
    		// display supporting information
    		println("The word now looks like this: " + user_word);
    		println("You have " + number_of_chances + " guesses left.");
    		
    		// receive user guess
    		String user_letter = readLine ("Your guess: ");
    		user_letter = convertCase(user_letter);
    		println("letter is converted to : " + user_letter);
    		
    		// compare with lexicon word
    		if (isLetterExist(user_letter)) // letter exists
    			// flip the letter that user guesses right
    			//user_word = flipLetter();
    			println("letter exists!");
    		else 
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
    
    // initalize word 
    private String initWord (String word) {
    	for (int index = 0; index < word.length(); index ++){
    		word.replaceAll(".", "-");
    	}
    	return word;
    }
    
    
    // check if user guessed word matches the original word
	private boolean isResMatch () {
		//if (user_word.equals(guess_word) )
			//return true;
		//else 
			return false;
	}
	
	// convert letter to upper case
	private String convertCase (String letter) {
		return letter.toUpperCase(); 
	}

	// check if user guessed letter exist in the original guessing word
	private boolean isLetterExist (String letter) {
		return guess_word.contains(letter);
	}

}
