/*
 * File: Hangman.java
 * ------------------
 * Hangman game code
 * User has 8 chances to guess the hidden word correctly
 * Everytime user made a incorrect guess, one body part of hangman will appear in scaffold
 * Once all 8 chances have been used up, hangman appears and game over
 * 
 * Hangman: "PLEASE, I DON't WANT TO DIE! SAVE ME! :("
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	// lexicon declaration
	private HangmanLexicon hangmanlecxicon;
	
	// random generator declaration
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	// class declaration
	private HangmanCanvas canvas;
	
	// variables declaration
	private static final int NTURNS = 8;
	private String user_word, guess_word;
	
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
    public void run() {
    	
    	// reset canvas window
    	canvas.reset();
    	
    	// variable definition
    	int number_of_chances = NTURNS;
		
    	// Display initial welcome message
    	println("Welcome to Hangman!");
    	
    	// initialize lexicon class
    	hangmanlecxicon = new HangmanLexicon();
    	
    	// variable declaration
    	String user_letter;
    	char user_letter_ch;
    	
    	// get a guessing word from the dictionary
    	double high_boundary = hangmanlecxicon.getWordCount();
    	int word_index = (int) rgen.nextDouble(0, high_boundary);
    	guess_word = hangmanlecxicon.getWord(word_index);
    	
    	user_word = initWord(guess_word.length());
    	
    	// constant check user guessing results and chances left 
    	while (number_of_chances > 0 && isResMatch() != true) {
    		// display supporting information
    		println("The word now looks like this: " + user_word);
    		println("You have " + number_of_chances + " guesses left.");
    		
    		canvas.displayWord(user_word);
    		
    		// receive user guess
    		while (true) {
	    		user_letter = readLine ("Your guess: ");
	    		
	    		// ensure letter user typed in satisfies requirements
	    		// 1. string length must be 1
	    		// 2. user typed character must be a-z or A-Z, no digits or other strange characters allowed
	    		if (user_letter.length() != 1) 
	    			println("Please type in a single character!");
	    		else {
	    			user_letter_ch = user_letter.charAt(0);
	    			if (user_letter_ch < 'A' || (user_letter_ch > 'Z' && user_letter_ch < 'a') || user_letter_ch > 'z' ) 
	    				println("Please type in valid character! Valid characters are [a~zA~Z]");
	    			else 
	    				break;
	    		}
    		}
    		
    		user_letter = convertCase(user_letter);
    		
    		// compare with lexicon word
    		if (isLetterExist(user_letter)) { // letter exists
    			// flip the letter that user guesses right
    			flipLetter(user_letter);
    		}
    		else {
    			number_of_chances --;
    			canvas.noteIncorrectGuess(user_letter_ch);
    		}
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
		int word_length = user_word.length();
		
		for (int index = 0; index < user_word.length(); index ++) {
			// find match in specific position
			if (guess_word.charAt(index) == ch) {
				if (index != 0 && index != user_word.length()) { // the letter is not the first one nor the last one
					sub_before = user_word.substring(0, index);
					sub_after = user_word.substring(index+1, word_length);
				} else if (index == 0) { // the letter is the first letter in the word
					sub_before = "";
					sub_after = user_word.substring(index + 1, word_length);
				} else { // the letter is the last letter in the word
					sub_before = user_word.substring(0, index);
					sub_after = "";
				}
			user_word = sub_before + ch + sub_after;
			}
		}
	}

}
