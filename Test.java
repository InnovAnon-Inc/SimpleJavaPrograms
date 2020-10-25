/**
 * Application to print your letter grade given your numerical grade
 * (100-point scale)
 */
public class Test {
	/**
	 * @param grade test or class grade on a 100-point scale
	 * @return letter grade, assuming normal letter ranges
	 */
	public static char getLetterGrade (final int grade) {
		if (grade >= 90) return 'A';
		if (grade >= 80) return 'B';
		if (grade >= 70) return 'C';
		if (grade >= 60) return 'D';
		return 'F';
	}
	
	/**
	 * doesn't account for the complexity of the English language,
	 * such as when 'y' and 'w' are vowels.
	 * @param letter to test
	 * @return whether the parameter is a vowel
	 */
	public static boolean isVowel (final char letter) {
		final String sletter = "" + letter;
		return "AEIOU".contains (sletter);
	}
	
	/**
	 *  @param letter first letter of next word
	 *  @return either 'a' or 'an'
	 */
	public static String getArticle (final char letter) {
		if (Test.isVowel (letter)) return "an";
		return "a";
	}
	
	/**
	 * prints a helpful message about your letter grade
	 * @param arg test or class grades as ints
	 */
	public static void processArgument (final String arg) {
		final int    grade   = Integer.parseInt (arg);
		final char   letter  = Test.getLetterGrade (grade);
		final String article = Test.getArticle (letter);
		System.out.printf ("You got %s %c.%n", article, letter);
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
	public static void main_1 (final String... args) {
		// validate input
		if (args.length != 1) System.exit (1); // exit status 1 means invalid usage
		// get single argument
		final String  grade = args[0];         // this is the one and only arg, a string representing the numeric grade
		Test.processArgument (arg);
	}
	
	/**
	 * processes multiple command line arguments
	 */
	public static void main_n (final String... args) {
		for (final String arg : args) Test.processArgument (arg);
	}
	
	public static void main (final String... args) {
		main_1 (args);
	}
}
