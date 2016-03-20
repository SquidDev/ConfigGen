package org.squiddev.configgen;

import org.junit.Assert;
import org.junit.Test;

public class OptionTest {
	@Test
	public void testStringArray() {
		String[] defaults = new String[]{"1", "2", "3"};

		System.clearProperty("foo");
		Assert.assertArrayEquals(defaults, OptionParser.getStringList("foo", defaults));

		System.setProperty("foo", "");
		Assert.assertArrayEquals(new String[0], OptionParser.getStringList("foo", defaults));

		System.setProperty("foo", "a,b");
		Assert.assertArrayEquals(new String[]{"a", "b"}, OptionParser.getStringList("foo", defaults));
	}

	@Test
	public void testIntArray() {
		int[] defaults = new int[]{1, 2, 3};

		System.clearProperty("foo");
		Assert.assertArrayEquals(defaults, OptionParser.getIntList("foo", defaults));

		System.setProperty("foo", "");
		Assert.assertArrayEquals(new int[0], OptionParser.getIntList("foo", defaults));

		System.setProperty("foo", "1,2");
		Assert.assertArrayEquals(new int[]{1, 2}, OptionParser.getIntList("foo", defaults));
	}
}