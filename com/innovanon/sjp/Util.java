package com.innovanon.sjp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	static { assert (disjoint (VOWEL_LETTERS, CONSONANT_LETTERS)); }
	
	/**
	 * @return whether the parameters contain any common chars
	 * @see java.util.Collections#disjoint (java.util.Collection, java.util.Collection)
	 */
	public static boolean disjoint (final String a, final String b) {
		final Set<Integer> A = a.chars ().parallel ().boxed ().collect (Collectors.toSet ());
		final Set<Integer> B = b.chars ().parallel ().boxed ().collect (Collectors.toSet ());
		return Collections.disjoint (A, B);
	}
	
	/**
	 * @return whether the letters are all unique
	 */
	public static <T> boolean unique (final T[] letters) {
		final List<T> a = Arrays.asList (letters);
		assert (a.size () == letters.length);
		final Set <T> b = new HashSet<> (a);
		assert (a.size () >= b.size ());
		return (a.size () == b.size ());
	}
	
	/**
	 * convenience method
	 * @see com.innovanon.sjp.Util#unique (Object[])
	 */
	public static boolean unique (final char[] letters) {
		final Character[] boxed = String.valueOf (letters).chars ().mapToObj (k -> Character.valueOf ((char) k)).toArray (Character[]::new);
		return unique (boxed);
	}
	
	/**
	 * convenience method
	 * @see com.innovanon.sjp.Util#unique (char[])
	 */
	public static boolean unique (final String letters) {
		final char[] c = letters.toCharArray ();
		return unique (c);
	}
	
	/**
	 * @return whether the parameters are strictly increasing
	 * @see java.lang.Comparable#compareTo (java.lang.Comparable)
	 */
	public static <T extends Comparable<T>> boolean strictlyIncreasing (final T[] cutoffs) {
		for (int i = 1; i < cutoffs.length; i++) {
			final T prev = cutoffs[i - 1];
			final T next = cutoffs[i - 0];
			if (prev.compareTo (next) >= 0) return false; // prev >= next
		}
		return true;
	}
	
	/**
	 * convenience method
	 * @see com.innovanon.sjp.Util#strictlyIncreasing (Comparable[])
	 */
	public static boolean strictlyIncreasing (final int[] cutoffs) {
		final Integer[] boxed = Arrays.stream (cutoffs).boxed ().toArray (Integer[]::new);
		return strictlyIncreasing (boxed);
	}
	
	public static boolean strictlyIncreasing (final String cutoffs) {
		final int[] c = cutoffs.chars ().toArray ();
		return strictlyIncreasing (c);
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
		if (word.isEmpty ()) throw new IllegalArgumentException (); // nothing to capitalize
		final char[] c    = word.toCharArray ();
		             c[0] = Character.toUpperCase (c[0]);
		             word = String.valueOf (c);
		return word;
	}
	
	private static final Map<String, String> POSSESSIVE_PRONOUN_CONVERSIONS;
	static {
		Map<String, String> map = new HashMap <String, String> ();
		map.put ( "me",   "my");
		map.put ( "Me",   "My");
		map.put ("you", "your");
		map.put ("You", "Your");
		map.put ( "he",  "his");
		map.put ( "He",  "His");
		map.put ("she",  "her");
		map.put ("She",  "Her");
		POSSESSIVE_PRONOUN_CONVERSIONS = Collections.unmodifiableMap (map);
	}
	private static final Collection<String> POSSESSIVE_PRONOUNS = Collections.unmodifiableCollection (POSSESSIVE_PRONOUN_CONVERSIONS.values ());
	
	public static String possessive (final String word) {
		if (word.isEmpty ()) throw new IllegalArgumentException ();
		final String word2 = word.toLowerCase (); // normalize
		if (POSSESSIVE_PRONOUNS.contains (word2)) return word; // skip words that are already possessive
		if (POSSESSIVE_PRONOUN_CONVERSIONS.containsKey (word)) return POSSESSIVE_PRONOUN_CONVERSIONS.get (word);
		// TODO handle nuances
		return String.format ("%s's", word);
	}
	
	/**
	 * converts multiple strings to ints
	 * @see java.lang.Integer#parseInt (java.lang.String)
	 */
	public static int[] parseInts (final String... args) {
		return Arrays.stream (args).parallel ().mapToInt (s -> Integer.parseInt (s)).toArray ();
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
