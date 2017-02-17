import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestyMcTestface {
  @Test
  public void testTranslate() {
    PiggyMcPigface piggyMcPigface = new PiggyMcPigface();
    assertEquals("ashtray", piggyMcPigface.translateWord("hej"));
  }
}
