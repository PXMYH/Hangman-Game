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
	
	private GLabel display_word;
	private GLabel guessed_letters;
	
	// define hangman joint points to pinpoint its skeleton
	private double pt_a_x, pt_a_y;
	private double pt_b_x, pt_b_y;
	private double pt_c_x, pt_c_y;
	private double pt_d_x, pt_d_y;
	private double pt_e_x, pt_e_y;
	private double pt_f_x, pt_f_y;
	private double pt_g_x, pt_g_y;
	private double pt_h_x, pt_h_y;
	private double pt_i_x, pt_i_y;
	private double pt_j_x, pt_j_y;
	private double pt_k_x, pt_k_y;
	private double pt_l_x, pt_l_y;
	private double pt_m_x, pt_m_y;
	private double pt_n_x, pt_n_y;
	private double pt_o_x, pt_o_y;
	private double pt_p_x, pt_p_y;
	private double pt_q_x, pt_q_y;
	
	// the following code doesn't work!
//	private final double pt_a_x = getWidth() / 2 - BEAM_LENGTH;
//	private final double pt_a_y = getHeight() * 38 / 50;
//	private final double pt_b_x = pt_a_x;
//	private final double pt_b_y = pt_a_y - SCAFFOLD_HEIGHT;
//	private final double pt_c_x = getWidth() / 2;
//	private final double pt_c_y = pt_b_y;
//	private final double pt_d_x = pt_c_x;
//	private final double pt_d_y = pt_c_y + ROPE_LENGTH;

	private String incorrect_guesses = "";
	private static int incorrect_count = 0;


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
		double display_word_label_x = getWidth() / 2 - BEAM_LENGTH;
		double display_word_label_y = getHeight() * 42 / 50;
		display_word = new GLabel (word, display_word_label_x, display_word_label_y);
		display_word.setFont("SanSerif-20");
		remove(display_word);
		add(display_word);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		
		// increment incorrect count to determine the part of the hangman body to draw
		incorrect_count ++;
		
		// print incorrect guesses to the canvas
		incorrect_guesses = incorrect_guesses + letter;
		double incorrect_guesses_label_x = getWidth() / 2 - BEAM_LENGTH;
		double incorrect_guesses_label_y = getHeight() * 45 / 50;
		guessed_letters = new GLabel (incorrect_guesses, incorrect_guesses_label_x, incorrect_guesses_label_y);
		remove(guessed_letters);
		add(guessed_letters);
		
		switch (incorrect_count) {
		// draw head
		case 1: drawHead(); break;
		// draw body
		case 2: drawBody(); break;
		// draw left arm 
		case 3: drawLeftArm(); break;
		// draw right arm
		case 4: drawRightArm(); break;
		// draw left leg
		case 5: drawLeftLeg(); break;
		// draw right leg
		case 6: drawRightLeg(); break;
		// draw left foot
		case 7: drawLeftFoot(); break;
		// draw right foot
		case 8: drawRightFoot(); break;
		default: break;
		}
		
		
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
	
	
	/* method to draw different parts of hangman */
	private void drawHead() {
		head = new GOval();
		
		add(head);
		
	}
	
	private void drawBody() {
		// body
		pt_e_x = pt_c_x;
		pt_e_y = pt_c_y + ROPE_LENGTH + 2 * HEAD_RADIUS;
		pt_k_x = pt_e_x;
		pt_k_y = pt_e_y + BODY_LENGTH;
		
		body = new GLine (pt_e_x, pt_e_y, pt_k_x, pt_k_y);
		add(body);
	}
	
	private void drawLeftArm() {
		// left upper arm
		pt_f_x = pt_e_x;
		pt_f_y = pt_c_y + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD;
		pt_g_x = pt_f_x - UPPER_ARM_LENGTH;
		pt_g_y = pt_f_y;
		
		// left lower arm
		pt_h_x = pt_g_x;
		pt_h_y = pt_g_y + LOWER_ARM_LENGTH;
		
		left_upper_arm = new GLine(pt_f_x, pt_f_y, pt_g_x, pt_g_y);
		left_lower_arm = new GLine(pt_g_x, pt_g_y, pt_h_x, pt_h_y);
		
		add(left_upper_arm);
		add(left_lower_arm);
	}
	
	private void drawRightArm() {
		// right upper arm
		pt_i_x = pt_f_x + UPPER_ARM_LENGTH;
		pt_i_y = pt_f_y;
		
		// right lower arm
		pt_j_x = pt_i_x;
		pt_j_y = pt_i_y + LOWER_ARM_LENGTH;
		
		right_upper_arm = new GLine(pt_f_x, pt_f_y, pt_i_x, pt_i_y);
		right_lower_arm = new GLine(pt_i_x, pt_i_y, pt_j_x, pt_j_y);
		
		add(right_upper_arm);
		add(right_lower_arm);
	}
	
	private void drawLeftLeg() {
		// left leg + half hip
		pt_l_x = pt_k_x - HIP_WIDTH / 2;
		pt_l_y = pt_k_y;
		pt_m_x = pt_l_x;
		pt_m_y = pt_l_y + LEG_LENGTH;
		
		hip = new GLine(pt_k_x, pt_k_y, pt_l_x, pt_l_y);
		left_leg = new GLine(pt_l_x, pt_l_y, pt_m_x, pt_m_y);
		
		add(hip);
		add(left_leg);
	}
	
	private void drawRightLeg() {
		// right leg + half hip
		pt_o_x = pt_k_x + HIP_WIDTH / 2;
		pt_o_y = pt_k_y;
		pt_p_x = pt_o_x;
		pt_p_y = pt_o_y + LEG_LENGTH;
		
		hip = new GLine(pt_k_x, pt_k_y, pt_o_x, pt_o_y);
		right_leg = new GLine(pt_o_x, pt_o_y, pt_p_x, pt_p_y);
		
		add(hip);
		add(right_leg);
	}
	
	private void drawLeftFoot() {
		// left foot
		pt_n_x = pt_m_x - FOOT_LENGTH;
		pt_n_y = pt_m_y;
		
		left_foot = new GLine(pt_m_x, pt_m_y, pt_n_x, pt_n_y);
		add(left_foot);
	}
	
	private void drawRightFoot() {
		// right foot
		pt_q_x = pt_p_x + FOOT_LENGTH;
		pt_q_y = pt_p_y;
		
		right_foot = new GLine(pt_p_x, pt_p_y, pt_q_x, pt_q_y);
		add(right_foot);
	}

}
