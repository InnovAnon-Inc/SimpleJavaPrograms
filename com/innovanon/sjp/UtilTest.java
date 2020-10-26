package com.innovanon.sjp;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UtilTest.
 * @see com.innovanon.sjp.Util
 */
public class UtilTest {
    /**
     * Default constructor for test class UtilTest
     */
    //public UtilTest () { /* empty */ }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    //@Before
    //public void setUp () { /* empty */ }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    //@After
    //public void tearDown () { /* empty */ }
    
    /** @see com.innovanon.sjp.Util#disjoint (java.lang.String, java.lang.String) */
    @Test
    public void testDisjoint_empty_empty () {
		String  a = "";
		String  b = "";
		boolean c = Util.disjoint (a, b);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#disjoint (java.lang.String, java.lang.String) */
	@Test
    public void testDisjoint_empty_nonempty () {
		String  a = "";
		String  b = "non-empty";
		boolean c = Util.disjoint (a, b);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#disjoint (java.lang.String, java.lang.String) */
	@Test
    public void testDisjoint_nonempty_empty () {
		String  a = "non-empty";
		String  b = "";
		boolean c = Util.disjoint (a, b);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#disjoint (java.lang.String, java.lang.String) */
	@Test
    public void testDisjoint_same () {
		String  a = "same";
		String  b = "same";
		boolean c = Util.disjoint (a, b);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#disjoint (java.lang.String, java.lang.String) */
	@Test
    public void testDisjoint_different () {
		String  a = "abc";
		String  b = "def";
		boolean c = Util.disjoint (a, b);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#unique (java.lang.String) */
	@Test
	public void testUnique_empty () {
		String s = "";
		boolean c = Util.unique (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#unique (java.lang.String) */
	@Test
	public void testUnique_unique () {
		String s = "thequickbrownf";
		boolean c = Util.unique (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#unique (java.lang.String) */
	@Test
	public void testUnique_nonunique () {
		String s = "racecar";
		boolean c = Util.unique (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyIncreasing (java.lang.String) */
	@Test
	public void testStrictlyIncreasing_empty () {
		String s = "";
		boolean c = Util.strictlyIncreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyIncreasing (java.lang.String) */
	@Test
	public void testStrictlyIncreasing_singleton () {
		String s = "A";
		boolean c = Util.strictlyIncreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyIncreasing (java.lang.String) */
	@Test
	public void testStrictlyIncreasing_same () {
		String s = "AA";
		boolean c = Util.strictlyIncreasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyIncreasing (java.lang.String) */
	@Test
	public void testStrictlyIncreasing_strictlyincreasing () {
		String s = "ABC";
		boolean c = Util.strictlyIncreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyIncreasing (java.lang.String) */
	@Test
	public void testStrictlyIncreasing_nonstrictlyincreasing () {
		String s = "ABB";
		boolean c = Util.strictlyIncreasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyIncreasing (java.lang.String) */
	@Test
	public void testStrictlyIncreasing_decreasing () {
		String s = "CBA";
		boolean c = Util.strictlyIncreasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyIncreasing (java.lang.String) */
	@Test
	public void testStrictlyIncreasing_nonstrictlydecreasing () {
		String s = "BAA";
		boolean c = Util.strictlyIncreasing (s);
		assertFalse (c);
	}
	
	
	
	/** @see com.innovanon.sjp.Util#increasing (java.lang.String) */
	@Test
	public void testIncreasing_empty () {
		String s = "";
		boolean c = Util.increasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#increasing (java.lang.String) */
	@Test
	public void testIncreasing_singleton () {
		String s = "A";
		boolean c = Util.increasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#increasing (java.lang.String) */
	@Test
	public void testIncreasing_same () {
		String s = "AA";
		boolean c = Util.increasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#increasing (java.lang.String) */
	@Test
	public void testIncreasing_strictlyincreasing () {
		String s = "ABC";
		boolean c = Util.increasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#increasing (java.lang.String) */
	@Test
	public void testIncreasing_nonstrictlyincreasing () {
		String s = "ABB";
		boolean c = Util.increasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#increasing (java.lang.String) */
	@Test
	public void testIncreasing_decreasing () {
		String s = "CBA";
		boolean c = Util.increasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#increasing (java.lang.String) */
	@Test
	public void testIncreasing_nonstrictlydecreasing () {
		String s = "BAA";
		boolean c = Util.increasing (s);
		assertFalse (c);
	}
	
	
	
	/** @see com.innovanon.sjp.Util#strictlyDecreasing (java.lang.String) */
	@Test
	public void testStrictlyDecreasing_empty () {
		String s = "";
		boolean c = Util.strictlyDecreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyDecreasing (java.lang.String) */
	@Test
	public void testStrictlyDecreasing_singleton () {
		String s = "A";
		boolean c = Util.strictlyDecreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyDecreasing (java.lang.String) */
	@Test
	public void testStrictlyDecreasing_same () {
		String s = "AA";
		boolean c = Util.strictlyDecreasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyDecreasing (java.lang.String) */
	@Test
	public void testStrictlyDecreasing_strictlyincreasing () {
		String s = "ABC";
		boolean c = Util.strictlyDecreasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyDecreasing (java.lang.String) */
	@Test
	public void testStrictlyDecreasing_nonstrictlyincreasing () {
		String s = "ABB";
		boolean c = Util.strictlyDecreasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyDecreasing (java.lang.String) */
	@Test
	public void testStrictlyDecreasing_decreasing () {
		String s = "CBA";
		boolean c = Util.strictlyDecreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#strictlyDecreasing (java.lang.String) */
	@Test
	public void testStrictlyDecreasing_nonstrictlydecreasing () {
		String s = "BAA";
		boolean c = Util.strictlyDecreasing (s);
		assertFalse (c);
	}
	
	
	
	/** @see com.innovanon.sjp.Util#decreasing (java.lang.String) */
	@Test
	public void testDecreasing_empty () {
		String s = "";
		boolean c = Util.decreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#decreasing (java.lang.String) */
	@Test
	public void testDecreasing_singleton () {
		String s = "A";
		boolean c = Util.decreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#decreasing (java.lang.String) */
	@Test
	public void testDecreasing_same () {
		String s = "AA";
		boolean c = Util.decreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#decreasing (java.lang.String) */
	@Test
	public void testDecreasing_strictlyincreasing () {
		String s = "ABC";
		boolean c = Util.decreasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#decreasing (java.lang.String) */
	@Test
	public void testDecreasing_nonstrictlyincreasing () {
		String s = "ABB";
		boolean c = Util.decreasing (s);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#decreasing (java.lang.String) */
	@Test
	public void testDecreasing_decreasing () {
		String s = "CBA";
		boolean c = Util.decreasing (s);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#decreasing (java.lang.String) */
	@Test
	public void testDecreasing_nonstrictlydecreasing () {
		String s = "BAA";
		boolean c = Util.decreasing (s);
		assertTrue (c);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/** @see com.innovanon.sjp.Util#isVowelSounding (char) */
	@Test
	public void testIsVowelSounding_a () {
		char l = 'a';
		boolean c = Util.isVowelSounding (l);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#isVowelSounding (char) */
	@Test
	public void testIsVowelSounding_b () {
		char l = 'b';
		boolean c = Util.isVowelSounding (l);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#isVowelSounding (char) */
	@Test
	public void testIsVowelSounding_c () {
		char l = 'c';
		boolean c = Util.isVowelSounding (l);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#isVowelSounding (char) */
	@Test
	public void testIsVowelSounding_d () {
		char l = 'd';
		boolean c = Util.isVowelSounding (l);
		assertFalse (c);
	}
	
	/** @see com.innovanon.sjp.Util#isVowelSounding (char) */
	@Test
	public void testIsVowelSounding_f () {
		char l = 'f';
		boolean c = Util.isVowelSounding (l);
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#getArticle (char) */
	@Test
	public void testGetArticle_a () {
		char l = 'a';
		String a = Util.getArticle (l);
		assertEquals (a, "an");
	}
	
	/** @see com.innovanon.sjp.Util#getArticle (char) */
	@Test
	public void testGetArticle_b () {
		char l = 'b';
		String a = Util.getArticle (l);
		assertEquals (a, "a");
	}
	
	/** @see com.innovanon.sjp.Util#getArticle (char) */
	@Test
	public void testGetArticle_c () {
		char l = 'c';
		String a = Util.getArticle (l);
		assertEquals (a, "a");
	}
	
	/** @see com.innovanon.sjp.Util#getArticle (char) */
	@Test
	public void testGetArticle_d () {
		char l = 'd';
		String a = Util.getArticle (l);
		assertEquals (a, "a");
	}
	
	/** @see com.innovanon.sjp.Util#getArticle (char) */
	@Test
	public void testGetArticle_f () {
		char l = 'f';
		String a = Util.getArticle (l);
		assertEquals (a, "an");
	}
	
	/** @see com.innovanon.sjp.Util#capitalize (java.lang.String) */
	@Test (expected=IllegalArgumentException.class)
	public void testCapitalize_empty () {
		String a = "";
		String b = Util.capitalize (a);
        fail ();
	}
	
	/** @see com.innovanon.sjp.Util#capitalize (java.lang.String) */
	@Test
	public void testCapitalize_singleton () {
		String a = "a";
		String b = Util.capitalize (a);
		assertEquals (b, "A");
	}
	
	/** @see com.innovanon.sjp.Util#capitalize (java.lang.String) */
	@Test
	public void testCapitalize_word () {
		String a = "word";
		String b = Util.capitalize (a);
		assertEquals (b, "Word");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test (expected=IllegalArgumentException.class)
	public void testPossessive_empty () {
		String a = "";
		String b = Util.possessive (a);
		fail ();
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_firstperson () {
		String a = "me";
		String b = Util.possessive (a);
		assertEquals (b, "my");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_FirstPerson () {
		String a = "Me";
		String b = Util.possessive (a);
		assertEquals (b, "My");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_secondperson () {
		String a = "you";
		String b = Util.possessive (a);
		assertEquals (b, "your");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_SecondPerson () {
		String a = "You";
		String b = Util.possessive (a);
		assertEquals (b, "Your");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_thirdpersonm () {
		String a = "he";
		String b = Util.possessive (a);
		assertEquals (b, "his");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_ThirdPersonM () {
		String a = "He";
		String b = Util.possessive (a);
		assertEquals (b, "His");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_thirdpersonf () {
		String a = "she";
		String b = Util.possessive (a);
		assertEquals (b, "her");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_ThirdPersonF () {
		String a = "She";
		String b = Util.possessive (a);
		assertEquals (b, "Her");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_thirdperson () {
		String a = "simple jack";
		String b = Util.possessive (a);
		assertEquals (b, "simple jack's");
	}
	
	/** @see com.innovanon.sjp.Util#possessive (java.lang.String) */
	@Test
	public void testPossessive_ThirdPerson () {
		String a = "Simple Jack";
		String b = Util.possessive (a);
		assertEquals (b, "Simple Jack's");
	}
	
	/** @see com.innovanon.sjp.Util#parseInts (java.lang.String...) */
	@Test
	public void testParseInts_empty () {
		String[] a = {};
		int   [] b = Util.parseInts (a);
		boolean  c = Arrays.equals (b, new int[] {});
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#parseInts (java.lang.String...) */
	@Test
	public void testParseInts_singleton () {
		String[] a = { "997" };
		int   [] b = Util.parseInts (a);
		boolean  c = Arrays.equals (b, new int[] { 997 });
		assertTrue (c);
	}
	
	/** @see com.innovanon.sjp.Util#parseInts (java.lang.String...) */
	@Test
	public void testParseInts_n () {
		String[] a = { "21", "34", "55" };
		int   [] b = Util.parseInts (a);
		boolean  c = Arrays.equals (b, new int[] { 21, 34, 55 });
		assertTrue (c);
	}
}
