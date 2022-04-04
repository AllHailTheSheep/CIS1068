package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class lab5tests extends lab5 {
  @Test
  void testIsPunct() {
    assertTrue(lab5.isPunct('.'));
    assertTrue(lab5.isPunct(';'));
    assertTrue(lab5.isPunct('?'));
    assertTrue(lab5.isPunct('\''));
    assertTrue(lab5.isPunct(','));
    assertTrue(lab5.isPunct(':'));
    assertTrue(lab5.isPunct('!'));
    assertFalse(lab5.isPunct(' '));
    assertFalse(lab5.isPunct('_'));
    assertFalse(lab5.isPunct('a'));
    assertFalse(lab5.isPunct('\t'));
    assertFalse(lab5.isPunct('\n'));
  }

  @Test
  void testNumPunct() {
    assertEquals(lab5.numPunct("cheesy poofs"), 0);
    assertEquals(lab5.numPunct(""), 0);
    assertEquals(lab5.numPunct("!"), 1);
    assertEquals(lab5.numPunct("! "), 1);
    assertEquals(lab5.numPunct("! "), 1);
    assertEquals(lab5.numPunct(" !"), 1);
    assertEquals(lab5.numPunct(".!"), 2);
    assertEquals(lab5.numPunct(". !"), 2);
    assertEquals(lab5.numPunct("There's always money in the banana stand."), 2);
  }

  @Test
  void testNumPunctStringInt() {
    assertEquals(lab5.numPunct("cheesy poofs", 4), 0);
    assertEquals(lab5.numPunct("", 1), 0);
    assertEquals(lab5.numPunct("!", 0), 1);
    assertEquals(lab5.numPunct("!", 1), 0);
    assertEquals(lab5.numPunct("! ", 1), 0);
    assertEquals(lab5.numPunct("! ", 0), 1);
    assertEquals(lab5.numPunct(" !", 0), 1);
    assertEquals(lab5.numPunct(".!", 0), 2);
    assertEquals(lab5.numPunct(".!", 1), 1);
    assertEquals(lab5.numPunct(".!", 2), 0);
    assertEquals(lab5.numPunct(". !", 0), 2);
    assertEquals(lab5.numPunct(". !", 1), 1);
    assertEquals(lab5.numPunct(". !", 2), 1);
    assertEquals(lab5.numPunct(". !", 3), 0);
    assertEquals(lab5.numPunct("There's always money in the banana stand.", 5), 2);
    assertEquals(lab5.numPunct("There's always money in the banana stand.", 6), 1);
  }

  @Test
  void testIndexOfFirstPunctString() {
    assertEquals(lab5.indexOfFirstPunct("cheesy poofs"), -1);
    assertEquals(lab5.indexOfFirstPunct(""), -1);
    assertEquals(lab5.indexOfFirstPunct("!"), 0);
    assertEquals(lab5.indexOfFirstPunct(" !"), 1);
    assertEquals(lab5.indexOfFirstPunct(". !"), 0);
    assertEquals(lab5.indexOfFirstPunct("There's always money in the banana stand."), 5);
  }


  @Test
  void testIndexOfFirstPunctStringInt() {
    assertEquals(lab5.indexOfFirstPunct("cheesy poofs", 4), -1);
    assertEquals(lab5.indexOfFirstPunct("cheesy poofs", 0), -1);
    assertEquals(lab5.indexOfFirstPunct("", 1), -1);
    assertEquals(lab5.indexOfFirstPunct("!", 0), 0);
    assertEquals(lab5.indexOfFirstPunct("!", 1), -1);
    assertEquals(lab5.indexOfFirstPunct("! ", 1), -1);
    assertEquals(lab5.indexOfFirstPunct("! ", 0), 0);
    assertEquals(lab5.indexOfFirstPunct("! ", 1), -1);
    assertEquals(lab5.indexOfFirstPunct("! ", 2), -1);
    assertEquals(lab5.indexOfFirstPunct(" !", 0), 1);
    assertEquals(lab5.indexOfFirstPunct(".!", 0), 0);
    assertEquals(lab5.indexOfFirstPunct(".!", 1), 1);
    assertEquals(lab5.indexOfFirstPunct(".!", 2), -1);
    assertEquals(lab5.indexOfFirstPunct(". !", 0), 0);
    assertEquals(lab5.indexOfFirstPunct(". !", 1), 2);
    assertEquals(lab5.indexOfFirstPunct(". !", 2), 2);
    assertEquals(lab5.indexOfFirstPunct(". !", 3), -1);
    assertEquals(lab5.indexOfFirstPunct("There's always money in the banana stand.", 0), 5);
    assertEquals(lab5.indexOfFirstPunct("There's always money in the banana stand.", 5), 5);
    assertEquals(lab5.indexOfFirstPunct("There's always money in the banana stand.", 6), 40);
  }

  @Test
  void testIndexOfLastPunct() {
    assertEquals(lab5.indexOfLastPunct("cheesy poofs"), -1);
    assertEquals(lab5.indexOfLastPunct(""), -1);
    assertEquals(lab5.indexOfLastPunct("!"), 0);
    assertEquals(lab5.indexOfLastPunct(" !"), 1);
    assertEquals(lab5.indexOfLastPunct(". !"), 2);
    assertEquals(lab5.indexOfLastPunct("There's always money in the banana stand."), 40);
  }

  @Test
  void testSubstitute() {
    assertEquals(lab5.substitute("apple", 'a', 'A'), "Apple");
    assertEquals(lab5.substitute("apple", 'a', 'a'), "apple");
    assertEquals(lab5.substitute("apple", ' ', 'a'), "apple");
    assertEquals(lab5.substitute("apple", 'a', ' '), " pple");
    assertEquals(lab5.substitute("apple", 'e', 'E'), "applE");
    assertEquals(lab5.substitute("apple", ' ', 'e'), "apple");
    assertEquals(lab5.substitute("apple", 'e', ' '), "appl ");
    assertEquals(lab5.substitute("apple", 'p', ' '), "a  le");
  }

  @Test
  void testSubstitutePunct() {
    assertEquals(lab5.substitutePunct("cheesy poofs"), "cheesy poofs");
    assertEquals(lab5.substitutePunct(""), "");
    assertEquals(lab5.substitutePunct("!"), " ");
    assertEquals(lab5.substitutePunct("! "), "  ");
    assertEquals(lab5.substitutePunct(" !"), "  ");
    assertEquals(lab5.substitutePunct(".!"), "  ");
    assertEquals(lab5.substitutePunct(". !"), "   ");
    assertEquals(lab5.substitutePunct("There's always money in the banana stand."),
                 "There s always money in the banana stand ");
  }

  @Test
  void testWithoutPunct() {
    assertEquals(lab5.withoutPunct("cheesy poofs"), "cheesy poofs");
    assertEquals(lab5.withoutPunct(""), "");
    assertEquals(lab5.withoutPunct("!"), "");
    assertEquals(lab5.withoutPunct("! "), " ");
    assertEquals(lab5.withoutPunct(" !"), " ");
    assertEquals(lab5.withoutPunct(".!"), "");
    assertEquals(lab5.withoutPunct(". !"), " ");
    assertEquals(lab5.withoutPunct("There's always money in the banana stand."),
                 "Theres always money in the banana stand");
  }

  @Test
  void testFoundIn() {
    assertFalse(lab5.foundIn("cheesy poofs", '.'));
    assertFalse(lab5.foundIn("cheesy poofs", 'q'));
    assertFalse(lab5.foundIn("", '.'));
    assertFalse(lab5.foundIn(" ", '.'));
    assertTrue(lab5.foundIn("cheesy poofs", 's'));
    assertTrue(lab5.foundIn("cheesy poofs", ' '));
    assertTrue(lab5.foundIn(" ", ' '));
  }

  @Test
  void testContainsNone() {
    assertTrue(lab5.containsNone("cheesy poofs", "aiuAEIOU"));
    assertFalse(lab5.containsNone("cheesy poofs", "abcde"));
    assertFalse(lab5.containsNone("cheesy poofs", "ABCDE "));
    assertTrue(lab5.containsNone("", "abcde "));
  }

  @Test
  void testOnlyPunct() {
    assertFalse(lab5.onlyPunct("!cheesy poofs"));
    assertFalse(lab5.onlyPunct("cheesy poofs"));
    assertFalse(lab5.onlyPunct("!,!?:,abc"));
    assertTrue(lab5.onlyPunct("!"));
    assertTrue(lab5.onlyPunct("!,!?:,"));
  }

  @Test
  void testNoPunct() {
    assertFalse(lab5.noPunct("!cheesy poofs"));
    assertFalse(lab5.noPunct("cheesy! poofs!"));
    assertFalse(lab5.noPunct("!,!?:,abc"));
    assertTrue(lab5.noPunct("Four score"));
    assertTrue(lab5.noPunct(" "));
    assertTrue(lab5.noPunct(""));
  }
	  
  @Test
  void testconsecutivePuncts() {
    assertFalse(lab5.consecutivePuncts(""));
    assertFalse(lab5.consecutivePuncts("a"));
    assertFalse(lab5.consecutivePuncts("!"));
    assertFalse(lab5.consecutivePuncts("!a,"));
    assertTrue(lab5.consecutivePuncts("!,"));
    assertTrue(lab5.consecutivePuncts("a!,"));
    assertTrue(lab5.consecutivePuncts("a,!"));
  }
}
