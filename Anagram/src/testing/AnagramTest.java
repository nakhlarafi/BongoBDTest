package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnagramTest {

	@Test
	void test1() {
		AnagramCheck ac = new AnagramCheck();
		String s = ac.isAnagram("Bleat","table");
		assertEquals("Anagram!", s.trim());
	}
	
	@Test
	void test2() {
		AnagramCheck ac = new AnagramCheck();
		String s = ac.isAnagram("eat","tar");
		assertEquals("Anagram!", s.trim());
	}

}
