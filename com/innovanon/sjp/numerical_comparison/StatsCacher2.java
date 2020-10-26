package com.innovanon.sjp.numerical_comparison;

/**
 * eagerly initializes fields.
 * fields cache results of method calls to prevent recomputing values
 */
public class StatsCacher2 extends Stats {
	
	private int    sum;
	private int    product;
	private int    min;
	private int    max;
	private Double quotient;
	private Double average;
	private String message;
	
    public StatsCacher2 (String... args) { this (new Stats (args)); }
    
    public StatsCacher2 (   int... args) { this (new Stats (args)); }
    
    public StatsCacher2 (Stats s) {
		super (new int[] {-1,-1,-1,-1,-1}); // TODO this is dirty. we need to create a stats interface and do away with the base class for this implementation
		this.sum      = s.sum ();
		this.product  = s.product ();
		this.min      = s.min ();
		this.max      = s.max ();
		this.quotient = s.quotient ();
		this.average  = s.average ();
		this.message  = s.getMessage ();
	}
    
    @Override
    public int    sum             () { return this.sum; }
	
	@Override
	public int    product         () { return this.product; }
	
	@Override
	public int    min             () { return this.min; }
	
	@Override
	public int    max             () { return this.max; }
	
	@Override
	public Double quotient        () { return this.quotient; }
	
	@Override
	public Double arithmetic_mean () { return this.average; }
	
	public String getMessage      () { return this.message; }

	/**
	 * @see com.innovanon.sjp.Util#parseInts (java.lang.String...)
	 * @see com.innovanon.sjp.numerical_comparison.Stats#Stats (int...)
	 */
    public static void main (String... args) {
		try {
			Stats s = new StatsCacher2 (args);
			System.out.println (s.getMessage ());
		} catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
