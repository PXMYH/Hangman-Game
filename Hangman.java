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
    	
    	user_word = initWord(guess_word.length());
    	
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
    		if (isLetterExist(user_letter)) { // letter exists
    			println("letter exists!");
    			// flip the letter that user guesses right
    			user_word = flipLetter(user_letter);
    			println("After flipping, the user word is " + user_word);
    		}
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
    
    // initialize word 
    private String initWord (int length) {
    	String tmp_word = "";
    	for (int index = 0; index < length; index ++)
    		tmp_word = tmp_word + "-";
    	
    	return tmp_word;
    }
    
    
    // check if user guessed word matches the original word
	private boolean isResMatch () {
		if (user_word.equals(guess_word) )
			return true;
		else 
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
	
	// flip the all letters user guessed correctly
//	private String flipLetter(String letter) {
//		String tmp_word = guess_word, return_word;
//		String regexp = "[^" + letter + "]";
//		return_word = tmp_word.replaceAll(regexp, "-");
//		return return_word;
//	}
	
	private void flipLetter (String letter) {
		char ch = letter.charAt(0);
		String sub_before, sub_after;
		
		for (int index = 0; index < guess_word.length(); index ++) {
			if (guess_word.charAt(index) == ch) // find match
				if (index != 0) {
					sub_before = guess_word.substring(0, index-1);
					user_word.
				}
		}
	}

}
