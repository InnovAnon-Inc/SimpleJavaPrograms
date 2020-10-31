package com.innovanon.sjp.numerical_comparison;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StatsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StatsTest
{
    /**
     * Default constructor for test class StatsTest
     */
    public StatsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testQuotient_nonzero () {
        int[] args = {1, 2, 3, 4, 5};
        Double expected = 5.0 / 1.0;
        Stats s = new Stats (args);
        Double actual = s.quotient ();
        assertEquals ((Object) expected, (Object) actual);
    }
    
    @Test
    public void testQuotient0 () {
        int[] args = {0, 2, 3, 4, 5};
        Double expected = null;
        Stats s = new Stats (args);
        Double actual = s.quotient ();
        assertEquals ((Object) expected, (Object) actual);
    }
}
