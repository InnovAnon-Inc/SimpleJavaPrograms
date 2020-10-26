package com.innovanon.sjp;

import java.util.Arrays;

public class Util {
	public static boolean isVowelSounding (char letter) {
		letter = Character.toUpperCase (letter);
		if (letter < 'A') throw new IllegalArgumentException ();
		if (letter > 'Z') throw new IllegalArgumentException ();
		final String sletter = String.valueOf (letter);
		boolean  ret = "AEFHILMNORSX"  .contains (sletter);
		boolean nret = "BCDGJKPQTUVWYZ".contains (sletter);
		assert (ret != nret);
		return ret;
	}
	
	/**
	 *  @param letter first letter of next word
	 *  @return either 'a' or 'an'
	 */
	public static String getArticle (final char letter) {
		//return (Test.isVowel (letter) ? "an" : "a");
		return (Util.isVowelSounding (letter) ? "an" : "a");
		//if (Test.isVowelSounding (letter)) return "an";
		//return "a";
	}
	
	public static String capitalize (String word) {
		char[] c    = word.toCharArray ();
		       c[0] = Character.toUpperCase (c[0]);
		       word = String.valueOf (c);
		return word;
	}
	
	/**
	 * converts multiple strings to ints
	 * @see Integer#parseInt (String)
	 */
	public static int[] parseInts (String... args) {
		return Arrays.stream (args).mapToInt (s -> Integer.parseInt (s)).toArray ();
		//int[] ret = new int[args.length];
		//for (int i = 0; i < args.length; i++) ret[i] = Integer.parseInt (args[i]);
		//return ret;
	}
}
