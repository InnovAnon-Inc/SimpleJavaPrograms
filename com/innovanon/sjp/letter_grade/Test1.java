package com.innovanon.sjp.letter_grade;

/**
 * Application to print your letter grade given your numerical grade
 * (100-point scale)
 */
public class Test1 extends Test {
	/**
	 * processes a single command line argument.
	 * prints a helpful messsage about your letter grade
	 * @see com.innovanon.sjp.letter_grade.Test#getMessage (java.lang.String, java.lang.String)
	 */
	public void main_1 (final String noun, final String... args) {
		// validate input
		if (args.length != 1) throw new IllegalArgumentException (); // exit status 1 means invalid usage
		// get single argument
		final String arg = args[0];         // this is the one and only arg, a string representing the numeric grade
		String out = this.getMessage (noun, arg);
		System.out.println (out);
	}
	
	/**
	 * @param a single numerical grade
	 * @see com.innovanon.sjp.letter_grade.Test#main_1 (java.lang.String, java.lang.String...)
	 */
	public static void main (final String... args) {
		Test1 t = new Test1 ();
		try { t.main_1 ("you", args); }
		catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
