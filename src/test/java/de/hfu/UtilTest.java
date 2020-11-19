package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

	@Test
	public void test() {
		
	}
	
	@Test
	public void testIstErstesHalbjahr() {
		assertEquals(true, Util.istErstesHalbjahr(1));
		assertEquals(true, Util.istErstesHalbjahr(7));
		assertEquals(false, Util.istErstesHalbjahr(8));
	}
	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testIstErstesHalbjahrException() {
		Util.istErstesHalbjahr(0);
	}

}
