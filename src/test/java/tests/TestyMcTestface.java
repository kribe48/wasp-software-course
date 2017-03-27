package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import piggymcpigface.*;

public class TestyMcTestface {
  @Test
  public void translateSentence() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("uckday ilesmay eggway", piggyMcPigface.translateSentence("duck smile egg"));
  };
  
  @Test
  public void SentenceWithPunctuation() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("pig att.", piggyMcPigface.SentenceWithPunctuation("igpay attway."));
  };

  @Test
  public void handleCapitalLetter() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("Ananabay", piggyMcPigface.translateWord("Banana"));
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
    assertEquals("ananabay", piggyMcPigface.translateWord("banana"));
  };
  @Test
  public void translateWordBeginningWithMultipleConsonants() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("eerschay", piggyMcPigface.translateWord("cheers"));
  }
  @Test
  public void translateWordBeginningWithVowel() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("omeletway", piggyMcPigface.translateWord("omelet"));
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
  @Test
  public void ReverseTranslator() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("igpay", piggyMcPigface.ReverseTranslator("pig"));
  };

// Example of failing test
// @Test
// public void failingTest() {
//	 assertEquals(0,1);
// }

}
