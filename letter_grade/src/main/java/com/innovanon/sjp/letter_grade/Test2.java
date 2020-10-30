package com.innovanon.sjp.letter_grade;

/**
 * Application to print students' letter grades given their numerical grades
 * (100-point scale)
 */
public class Test2 extends Test1 {
	/**
	 * processes multiple command line arguments
	 * @see com.innovanon.sjp.letter_grade.Test#main_1 (java.lang.String, java.lang.String...)
	 */
	public void main_n (final String... args) {
		//for (final String arg : args) this.processArgument (noun, arg);
		int i = args.length;
		if (args.length % 2 != 0) throw new IllegalArgumentException ();
		assert (i % 2 == 0);
		for (int I = 0; I < i; I += 2) {
			String noun = args[I + 0];
			String arg  = args[I + 1];
			this.main_1 (noun, arg);
		}
	}
	
	/**
	 * @param args list of (student name, numerical grade)
	 * @see com.innovanon.sjp.letter_grade.Test2#main_n (java.lang.String...)
	 */
	public static void main (final String... args) {
		Test2 t = new Test2 ();
		try { t.main_n (args); }
		catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
