import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;

/**
 * Application to print your letter grade given your numerical grade
 * (100-point scale)
 */
public class Test {
	
	private final List<Integer>   cutoffs;
	private final List<Character> letters;
    
    private static void validate_cutoffs (Integer[] cutoffs) {
		int i;
		for (i = 1; i < cutoffs.length; i++) {
			Integer prev = cutoffs[i - 1];
			Integer next = cutoffs[i - 0];
			if (prev <= next) throw new IllegalArgumentException ();
		}
		assert (i == cutoffs.length);
		if (cutoffs[i - 1] != 0) throw new IllegalArgumentException ();
	}
	private static void validate_letters (Character[] letters) {
		List<Character> a = Arrays.asList (letters);
		assert (a.size () == letters.length);
		Set <Character> b = new HashSet<> (a);
		if (a.size () != b.size ()) throw new IllegalArgumentException ();
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
	
	public Test () {
		this (
			new Integer  [] { 90,  80,  70,  60,   0},
			new Character[] {'A', 'B', 'C', 'D', 'F'}
		);
	}
	
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
		throw new AssertionError ();
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
	 * doesn't account for the complexity of the English language,
	 * such as when 'y' and 'w' are vowels.
	 * @param letter to test
	 * @return whether the parameter is a vowel
	 */
	 /*
	public static boolean isVowel (char letter) {
		letter = Character.toUpperCase (letter);
		assert (letter >= 'A');
		assert (letter <= 'Z');
		final String sletter = String.valueOf (letter);
		return "AEIOU".contains (sletter);
	}
	*/
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
		return (Test.isVowelSounding (letter) ? "an" : "a");
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
	 * prints a helpful message about your letter grade
	 * @param arg test or class grades as ints
	 */
	public void processArgument (String noun, final String s_grade) {
		final int    i_grade = Integer.parseInt (s_grade);
		if (i_grade <   0) throw new IllegalArgumentException ();
		//if (grade > 100) throw new Exception ();
		final char   l_grade = this.getLetterGrade (i_grade);
		final String article = Test.getArticle (l_grade);
		noun = Test.capitalize (noun);
		//System.out.printf ("%s got %s %c.%n", noun, article, l_grade);
		System.out.printf ("Your grade is a %d. That's %s %c.%n",
		i_grade, article, l_grade);
	}
	
	/* example:
	    // convert argument to int
		      int    igrade = Integer.parseInt (grade) // numeric grade as an int
		// use int argument to determine letter grade
		      char   lgrade;                           // letter grade
		     if (igrade >= 90) lgrade = 'A';
		else if (igrade >= 80) lgrade = 'B';
		else if (igrade >= 70) lgrade = 'C';
		else if (igrade >= 60) lgrade = 'D';
		else                   lgrade = 'F';
		// use letter grade to get article for proper grammar
		      String article;                          // either "a" or "an"
		     if (lgrade == 'A') article = "an";
		else if (lgrade == 'B') article = "a";
		else if (lgrade == 'C') article = "a";
		else if (lgrade == 'D') article = "a";
		else if (lgrade == 'F') article = "a";
		else throw Exception ();
		// output results of computations
		System.out.println ("You got " + article + " " + lgrade);
	 */
	
	/**
	 * processes a single command line argument
	 */
	public void main_1 (final String noun, final String... args) {
		// validate input
		if (args.length != 1) throw new IllegalArgumentException (); // exit status 1 means invalid usage
		// get single argument
		final String arg = args[0];         // this is the one and only arg, a string representing the numeric grade
		this.processArgument (noun, arg);
	}
	
	/**
	 * @param a single numerical grade
	 */
	public static void main (final String... args) {
		Test t = new Test ();
		try { t.main_1 ("you", args); }
		catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
