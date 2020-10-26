package com.innovanon.sjp.stats;

import java.util.Arrays;
import java.util.Collections;

import com.innovanon.sjp.Util;

/**
 * Computes and prints statistics about integer command line arguments
 */
public class Stats {
	private static void validateArgs (int... args) {
		if (args.length != 5) throw new IllegalArgumentException ();
	}
	
    private int[] args;
    //private int min, max;

	/*
    public Stats (String... args) {
        this (Stats.parseInts (args));
    }
    */
    
    public Stats (int... args) {
		Stats.validateArgs (args);
		this.args = args.clone ();
		//this.min  = Stats.min (args);
		//this.max  = Stats.max (args);
	}
    
    public int sum () {
		return Arrays.stream (args).reduce (0, (a, b) -> (a + b));
	}
	
	public int product () {
		// TODO int overflow ?
		return Arrays.stream (args).reduce (1, (a, b) -> (a * b));
	}
	
	public int min () {
		return Arrays.stream (args).min ().getAsInt ();
	}
	
	public int max () {
		return Arrays.stream (args).max ().getAsInt ();
	}
	
	public Double quotient () {
		int min = this.min ();
		int max = this.max ();
		if (min == 0) return null; // throw new IllegalArgumentException ();
		double ret = (double) max / min;
		return Double.valueOf (ret);
	}
	
	public Double arithmetic_mean () {
		int n = this.args.length;
		if (n == 0) return null;
		double ret = (double) this.sum () / n;
		return Double.valueOf (ret);
	}
	public Double average () { return this.arithmetic_mean (); }

    public static void main (String... args) {
		int[] ints = Util.parseInts (args);
		try {
			Stats s = new Stats (ints);
			System.out.printf ("max : %d%n", s.max ());
			System.out.printf ("min : %d%n", s.min ());
			System.out.printf ("sum : %d%n", s.sum ());
			System.out.printf ("prod: %d%n", s.product ());
			System.out.printf ("quot: %g%n", s.quotient ());
			//System.out.printf ("mean: %g%n", s.average ());
		} catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
