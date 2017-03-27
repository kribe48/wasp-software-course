package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import piggymcpigface.*;

public class TestyMcTestface {
  @Test
  public void translateSentencePigLatin() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("uckday ilesmay eggway", piggyMcPigface.translateSentence("duck smile egg", "pigLatin"));
  };

  @Test
  public void translateWordRovarSpraket() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("hohäror kokomommomeror popipoppopi lolånongogsostotrorumompop", piggyMcPigface.translateSentence("här kommer pippi långstrump", "rovarSpraket"));
  };

  @Test
  public void handleCapitalLetterPigLatin() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("Ananabay", piggyMcPigface.translateWordPigLatin("Banana"));
  };

  @Test
  public void handleCapitalLetterRovarSpraket() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("Bobanonanon", piggyMcPigface.translateWordRovarSpraket("Banan"));
  };

  @Test
  public void handlePunctuation() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("banana!", piggyMcPigface.handlePunctuation("ban!ana"));
    assertEquals("banana.", piggyMcPigface.handlePunctuation(".banana"));
    assertEquals("banana?", piggyMcPigface.handlePunctuation("banana?"));
  };
  @Test
  public void translateWordBeginningWithConsonant() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("ananabay", piggyMcPigface.translateWordPigLatin("banana"));
  };
  @Test
  public void translateWordBeginningWithMultipleConsonants() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("eerschay", piggyMcPigface.translateWordPigLatin("cheers"));
  }
  @Test
  public void translateWordBeginningWithVowel() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("omeletway", piggyMcPigface.translateWordPigLatin("omelet"));
  }
  @Test
  public void findingFirstVowelNo() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals(-1, piggyMcPigface.indexOfFirstVowel("nvwl"));
  }
  @Test
  public void findingFirstVowelFirst() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals(0, piggyMcPigface.indexOfFirstVowel("avowelfirst"));
  }
  @Test
  public void findingFirstVowelMiddle() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals(4, piggyMcPigface.indexOfFirstVowel("vwlmiddle"));
  }
  @Test
  public void findingFirstVowelLast() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals(6, piggyMcPigface.indexOfFirstVowel("vwllsta"));
  }

// Example of failing test
// @Test
// public void failingTest() {
//	 assertEquals(0,1);
// }

}
