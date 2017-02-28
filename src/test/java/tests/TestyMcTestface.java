package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import piggymcpigface.*;

public class TestyMcTestface {
  @Test
  public void translatedWordShouldBeAshtray() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("ashtray", piggyMcPigface.translateWord("hej"));
  }
  @Test
  public void findingFirstVowel() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals(-1, piggyMcPigface.indexOfFirstVowel("nvwl"));
    assertEquals(0, piggyMcPigface.indexOfFirstVowel("avowelfirst"));
    assertEquals(4, piggyMcPigface.indexOfFirstVowel("vwlmiddle"));
    assertEquals(6, piggyMcPigface.indexOfFirstVowel("vwllsta"));
  }

// Example of failing test
// @Test
// public void failingTest() {
//	 assertEquals(0,1);
// }

}
