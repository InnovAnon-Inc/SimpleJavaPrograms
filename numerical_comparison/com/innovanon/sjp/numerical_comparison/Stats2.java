package com.innovanon.sjp.numerical_comparison;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * Computes and prints statistics about integer command line arguments
 */
public class Stats2 extends Stats {
	
	public Stats2 (String... args) { super (args); }
	public Stats2 (   int... args) { super (args); }
	
	/**
	 * a fancier implementation
	 * @see java.util.stream.IntStream#average ()
	 */
	@Override
	public Double arithmetic_mean () {
		OptionalDouble tmp = Arrays.stream (args).parallel ().average ();
		if (tmp.isEmpty ()) return null;
		double ret = tmp.getAsDouble ();
		return Double.valueOf (ret);
	}
	
	/**
	 * @see com.innovanon.sjp.Util#parseInts (java.lang.String...)
	 * @see com.innovanon.sjp.numerical_comparison.Stats#Stats (int...)
	 */
    public static void main (String... args) {
		try {
			Stats s = new Stats2 (args);
			System.out.println (s.getMessage ());
		} catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
