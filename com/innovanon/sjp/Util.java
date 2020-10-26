package com.innovanon.sjp;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** miscellaneous utility methods */
public class Util {
	/** letters whose pronunciations start with a vowel
	 *  (these letters are not necessarily vowels) */
	public static final String     VOWEL_LETTERS = "AEFHILMNORSX";
	/** letters whose pronunciations start with a consonant
	 *  (these letters are not necessarily consonants) */
	public static final String CONSONANT_LETTERS = "BCDGJKPQTUVWYZ";
	
	/** validates static fields */
	static {
		assert (disjoint (VOWEL_LETTERS, CONSONANT_LETTERS));
	}
	
	/**
	 * @return whether the parameters contain any common chars
	 * @see java.util.Collections#disjoint (java.util.Collection, java.util.Collection)
	 */
	public static boolean disjoint (final String a, final String b) {
		final Set<Integer> A = a.chars ().boxed ().collect (Collectors.toSet ());
		final Set<Integer> B = b.chars ().boxed ().collect (Collectors.toSet ());
		return Collections.disjoint (A, B);
	}
	
	/**
	 * @return whether the letters are all unique
	 */
	public static <T> boolean unique (final T... letters) {
		final List<T> a = Arrays.asList (letters);
		assert (a.size () == letters.length);
		final Set <T> b = new HashSet<> (a);
		assert (a.size () >= b.size ());
		return (a.size () == b.size ());
	}
	
	/**
	 * @return whether the parameters are strictly increasing
	 * @see java.lang.Comparable#compareTo (java.lang.Comparable)
	 */
	public static <T extends Comparable<T>> boolean strictlyIncreasing (final T... cutoffs) {
		for (int i = 1; i < cutoffs.length; i++) {
			final T prev = cutoffs[i - 1];
			final T next = cutoffs[i - 0];
			if (prev.compareTo (next) <= 0) return false;
		}
		return true;
	}
	
	/**
	 * @return whether the parameter starts with a vowel-sound
	 * @see com.innovanon.sjp.Util#VOWEL_LETTERS
	 * @see com.innovanon.sjp.Util#CONSONANT_LETTERS
	 */
	public static boolean isVowelSounding (char letter) {
		letter = Character.toUpperCase (letter);
		if (letter < 'A') throw new IllegalArgumentException ();
		if (letter > 'Z') throw new IllegalArgumentException ();
		final String sletter = String.valueOf (letter);
		final boolean  ret =     VOWEL_LETTERS.contains (sletter);
		final boolean nret = CONSONANT_LETTERS.contains (sletter);
		assert (ret != nret);
		return ret;
	}
	
	/**
	 *  @param letter first letter of next word
	 *  @return either 'a' or 'an'
	 *  @see com.innovanon.sjp.Util#isVowelSounding (char)
	 */
	public static String getArticle (final char letter) {
		//return (Test.isVowel (letter) ? "an" : "a");
		return (Util.isVowelSounding (letter) ? "an" : "a");
		//if (Test.isVowelSounding (letter)) return "an";
		//return "a";
	}
	
	/**
	 * @return the parameter with the first character capitalized
	 * @see java.lang.Character#toUpperCase (char)
	 */
	public static String capitalize (String word) {
		final char[] c    = word.toCharArray ();
		             c[0] = Character.toUpperCase (c[0]);
		             word = String.valueOf (c);
		return word;
	}
	
	/**
	 * converts multiple strings to ints
	 * @see java.lang.Integer#parseInt (java.lang.String)
	 */
	public static int[] parseInts (final String... args) {
		return Arrays.stream (args).mapToInt (s -> Integer.parseInt (s)).toArray ();
		//int[] ret = new int[args.length];
		//for (int i = 0; i < args.length; i++) ret[i] = Integer.parseInt (args[i]);
		//return ret;
	}
	
	public static void main (final String... args) {
		if (args.length != 0) System.exit (1);
		System.out.println (    VOWEL_LETTERS);
		System.out.println (CONSONANT_LETTERS);
	}
}
