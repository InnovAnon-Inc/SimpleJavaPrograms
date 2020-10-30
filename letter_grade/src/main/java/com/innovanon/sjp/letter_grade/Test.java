package com.innovanon.sjp.letter_grade;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.innovanon.sjp.Util;

/**
 * get a message about your letter grade given your numerical grade
 * (100-point scale)
 */
public class Test {
	/** cutoffs for the letter grades.
	 *  different classes may have different cutoffs,
	 *  so now we're college-ready */
	private final List<Integer>   cutoffs;
	/** letter grades (i.e., A, B, C, D, F) */
	private final List<Character> letters;
    
    /**
     * @see com.innovanon.sjp.Util#strictlyIncreasing (Comparable)
     */
    private static void validate_cutoffs (Integer[] cutoffs) {
		if (! Util.strictlyDecreasing (cutoffs)) throw new IllegalArgumentException ();
		int i = cutoffs.length;
		if (cutoffs[i - 1] != 0) throw new IllegalArgumentException ();
	}
	/**
	 * @see com.innovanon.sjp.Util#unique (Object[])
	 */
	private static void validate_letters (Character[] letters) {
		if (! Util.unique (letters)) throw new IllegalArgumentException ();
	}
    
	public Test (Integer[] cutoffs, Character[] letters) {
		if (cutoffs.length != letters.length) throw new IllegalArgumentException ();
		validate_cutoffs (cutoffs);
		validate_letters (letters);
		List<Integer>   cutoffs2 = Arrays.asList (cutoffs);
		List<Character> letters2 = Arrays.asList (letters);
		this.cutoffs = Collections.unmodifiableList (cutoffs2);
		this.letters = Collections.unmodifiableList (letters2);
	}
	
	/** reasonable defaults */
	public Test () { this (
		new Integer  [] { 90,  80,  70,  60,   0},
		new Character[] {'A', 'B', 'C', 'D', 'F'}
	); }
	
	/**
	 * @param grade test or class grade on a 100-point scale
	 * @return letter grade, assuming normal letter ranges
	 */
	public char getLetterGrade (final int grade) {
		int i = this.cutoffs.size ();
		int j = this.letters.size ();
		assert (i == j);
		for (int I = 0; I < i; I++) {
			int  cutoff = this.cutoffs.get (I);
			char letter = this.letters.get (I);
			if (grade >= cutoff) return letter;
		}
		//throw new AssertionError ();
		throw new IllegalArgumentException ();
		/*
		assert (grade >   0);
		//assert (grade < 100);
		if (grade >= 90) return 'A';
		assert (grade < 90);
		if (grade >= 80) return 'B';
		assert (grade < 80);
		if (grade >= 70) return 'C';
		assert (grade < 70);
		if (grade >= 60) return 'D';
		assert (grade < 60);
		return 'F';
		*/
	}
	
	/**
	 * @param noun student's name or pronoun (i.e., "you")
	 * @param s_grade test or class grades as ints
	 * @return a helpful message about your letter grade
	 * @see com.innovanon.sjp.Util#possessive (java.lang.String)
	 * @see com.innovanon.sjp.Util#capitalize (java.lang.String)
	 */
	public String getMessage (String noun, final String s_grade) {
		final int    i_grade = Integer.parseInt (s_grade);
		if (i_grade <   0) throw new IllegalArgumentException ();
		//if (grade > 100) throw new Exception ();
		final char   l_grade = this.getLetterGrade (i_grade);
		final String article = Util.getArticle (l_grade);
		noun = Util.possessive (noun);
		noun = Util.capitalize (noun);
		//System.out.printf ("%s got %s %c.%n", noun, article, l_grade);
		String ret = String.format ("%s grade is %d. That's %s %c.", noun, i_grade, article, l_grade);
		return ret;
	}
}
