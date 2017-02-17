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

// Example of failing test
// @Test
// public void failingTest() {
//	 assertEquals(0,1);
// }

}
