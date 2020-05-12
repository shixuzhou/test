import static org.junit.Assert.*;

import org.apache.commons.text.StringTokenizer;
import org.apache.commons.text.matcher.StringMatcher;
import org.apache.commons.text.matcher.StringMatcherFactory;
import org.junit.*;

public class Demo {

	@Test
	public void testDelimString() {
		final String input = "a##b##c";
		final StringTokenizer tok = new StringTokenizer(input, "##");

		assertEquals("a", tok.next());
		assertEquals("b", tok.next());
		assertEquals("c", tok.next());
		assertFalse(tok.hasNext());
	}

	@Test
	public void testDelimMatcher() {
		final String input = "a/b\\c";
		final StringMatcher delimMatcher = StringMatcherFactory.INSTANCE
				.charSetMatcher(new char[] { '/', '\\' });

		final StringTokenizer tok = new StringTokenizer(input, delimMatcher);
		assertEquals("a", tok.next());
		assertEquals("b", tok.next());
		assertEquals("c", tok.next());
		assertFalse(tok.hasNext());
	}

	@Test
	public void testDelimMatcherQuoteMatcher() {
		final String input = "`a`;`b`;`c`";
		final StringMatcher delimMatcher = StringMatcherFactory.INSTANCE
				.charSetMatcher(new char[] { ';' });
		final StringMatcher quoteMatcher = StringMatcherFactory.INSTANCE
				.charSetMatcher(new char[] { '`' });

		final StringTokenizer tok = new StringTokenizer(input, delimMatcher,
				quoteMatcher);
		assertEquals("a", tok.next());
		assertEquals("b", tok.next());
		assertEquals("c", tok.next());
		assertFalse(tok.hasNext());
	}       
}
