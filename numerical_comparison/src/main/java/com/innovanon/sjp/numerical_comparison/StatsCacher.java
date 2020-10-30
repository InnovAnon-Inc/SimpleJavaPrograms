package com.innovanon.sjp.numerical_comparison;

/**
 * lazily initializes its fields.
 * fields cache results of method calls to prevent recomputing values
 */
public class StatsCacher extends Stats {
	
	private Integer sum;
	private Integer product;
	private Integer min;
	private Integer max;
	private Double quotient;
	private Double average;
	private String message;
	
    public StatsCacher (String... args) { super (args); }
    
    public StatsCacher (   int... args) { super (args); }
    
    @Override
    public int sum () {
		if (this.sum == null) this.sum = Integer.valueOf (super.sum ());
		return this.sum.intValue ();
	}
	
	@Override
	public int product () {
		if (this.product == null) this.product = Integer.valueOf (super.product ());
		return this.product.intValue ();
	}
	
	@Override
	public int min () {
		if (this.min == null) this.min = Integer.valueOf (super.min ());
		return this.min.intValue ();
	}
	
	@Override
	public int max () {
		if (this.max == null) this.max = Integer.valueOf (super.max ());
		return this.max.intValue ();
	}
	
	@Override
	public Double quotient () {
		if (this.quotient == null) this.quotient = super.quotient ();
		return this.quotient;
	}
	
	@Override
	public Double arithmetic_mean () {
		if (this.average == null) this.average = super.arithmetic_mean ();
		return this.average;
	}
	
	public String getMessage () {
		if (this.message == null) this.message = super.getMessage ();
		return this.message;
	}

	/**
	 * @see com.innovanon.sjp.Util#parseInts (java.lang.String...)
	 * @see com.innovanon.sjp.numerical_comparison.Stats#Stats (int...)
	 */
    public static void main (String... args) {
		try {
			Stats s = new StatsCacher (args);
			System.out.println (s.getMessage ());
		} catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
