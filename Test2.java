public class Test2 {
		
	public static void main (final String... args) {
		Test t = new Test ();
		try { t.main_n (args); }
		catch (IllegalArgumentException e) {
			System.err.println (e);
			System.exit (1);
		}
	}
}
