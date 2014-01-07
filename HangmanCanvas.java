/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
	// instance variable declaration
	private GLine scaffold;
	private GLine beam;
	private GLine rope;
	private GOval head;
	private GLine body;
	private GLine left_upper_arm;
	private GLine right_upper_arm;
	private GLine left_lower_arm;
	private GLine right_lower_arm;
	private GLine hip;
	private GLine left_leg;
	private GLine right_leg;
	private GLine left_foot;
	private GLine right_foot;
	
	// define hangman joint points to pinpoint its skeleton
	private double pt_a_x;
	private double pt_a_y;
	private double pt_b_x;
	private double pt_b_y;
	private double pt_c_x;
	private double pt_c_y;
	private double pt_d_x;
	private double pt_d_y;
	private double pt_e_x;
	private double pt_e_y;
	private double pt_f_x;
	private double pt_f_y = ;
	private double pt_g_x = ;
	private double pt_g_y = ;
	private double pt_h_x = ;
	private double pt_h_y = ;
	private final double pt_j_x = ;
	private final double pt_j_y = ;
	private final double pt_k_x = ;
	private final double pt_k_y = ;
	private final double pt_l_x = ;
	private final double pt_l_y = ;
	private final double pt_m_x = ;
	private final double pt_m_y = ;
	private final double pt_n_x = ;
	private final double pt_n_y = ;
	private final double pt_o_x = ;
	private final double pt_o_y = ;
	
//	private final double pt_a_x = getWidth() / 2 - BEAM_LENGTH;
//	private final double pt_a_y = getHeight() * 38 / 50;
//	private final double pt_b_x = pt_a_x;
//	private final double pt_b_y = pt_a_y - SCAFFOLD_HEIGHT;
//	private final double pt_c_x = getWidth() / 2;
//	private final double pt_c_y = pt_b_y;
//	private final double pt_d_x = pt_c_x;
//	private final double pt_d_y = pt_c_y + ROPE_LENGTH;

	


/** Resets the display so that only the scaffold appears */
	public void reset() {
		
		pt_a_x = getWidth() / 2 - BEAM_LENGTH;
		pt_a_y = getHeight() * 38 / 50;
		pt_b_x = pt_a_x;
		pt_b_y = pt_a_y - SCAFFOLD_HEIGHT;
		pt_c_x = getWidth() / 2;
		pt_c_y = pt_b_y;
		pt_d_x = pt_c_x;
		pt_d_y = pt_c_y + ROPE_LENGTH;
		
		// draw scaffold
		scaffold = new GLine(pt_a_x, pt_a_y, pt_b_x, pt_b_y);
		beam = new GLine(pt_b_x, pt_b_y, pt_c_x, pt_c_y);
		rope = new GLine(pt_c_x, pt_c_y, pt_d_x, pt_d_y);
		add(scaffold);
		add(beam);
		add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
