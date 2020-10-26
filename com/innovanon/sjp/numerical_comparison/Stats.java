package com.innovanon.sjp.numerical_comparison;

import java.util.Arrays;

import com.innovanon.sjp.Util;

/**
 * Computes and prints statistics about integer command line arguments
 */
public class Stats {
	private static void validateArgs (int... args) {
		if (args.length != 5) throw new IllegalArgumentException (Arrays.toString (args)); // artificial limitation, as per the assignment
	}
	
    protected final int[] args;
    // we could pre-compute everything... but let's save that for another class
    //private int min, max;

	/**
	 * convenience constructor
	 * @see com.innovanon.sjp.Util#parseInts (java.lang.String...)
	 */
    public Stats (String... args) { this (Util.parseInts (args)); }
    
    public Stats (int... args) {
		Stats.validateArgs (args);
		this.args = args.clone (); // defensive copy
		//this.min  = Stats.min (args);
		//this.max  = Stats.max (args);
	}
    
    /**
     * @return sum of elements of array
     */
    public int sum () { return Arrays.stream (args).parallel ().reduce (0, (a, b) -> (a + b)); }
	
	/**
	 * @return product of elements of array
	 */
	public int product () {
		// TODO int overflow ?
		return Arrays.stream (args).parallel ().reduce (1, (a, b) -> (a * b));
	}
	
	/**
	 * @return min element of array
	 * @see java.util.stream.Stream#min ()
	 */
	public int min () { return Arrays.stream (args).parallel ().min ().getAsInt (); }
	
	/**
	 * @return max element of array
	 * @see java.util.stream.Stream#max ()
	 */
	public int max () { return Arrays.stream (args).parallel ().max ().getAsInt (); }
	
	/**
	 * @return quotient of max() and min() if it's defined; null otherwise
	 */
	public Double quotient () { // welcome to your first run-in with boxing primitive types
		int min = this.min ();
		int max = this.max ();
		if (min == 0) return null; // throw new IllegalArgumentException ();
		double ret = (double) max / min;
		return Double.valueOf (ret);
	}
	
	/**
	 * @return average if it's defined; null otherwise
	 */
	public Double arithmetic_mean () {
		int n = this.args.length;
		if (n == 0) return null;
		double ret = (double) this.sum () / n;
		return Double.valueOf (ret);
	}
	/**
	 * @see com.innovanon.sjp.numerical_comparison.Stats#arithmetic_mean ()
	 */
	public Double average () { return this.arithmetic_mean (); }
	
	public String getMessage () { return String.format (
		"max : %d%n" +
		"min : %d%n" +
		"sum : %d%n" +
		"prod: %d%n" +
		"quot: %g%n", this.max (), this.min (), this.sum (), this.product (), this.quotient ()); }

	/**
	 * @see com.innovanon.sjp.Util#parseInts (java.lang.String...)
	 * @see com.innovanon.sjp.numerical_comparison.Stats#Stats (int...)
	 */
    public static void main (String... args) {
		try {
			Stats s = new Stats (args);
			System.out.println (s.getMessage ());
		} catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
