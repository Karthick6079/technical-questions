import org.example.karthick.epam.Practice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    Practice longestSubstring = new Practice();

    @Test
    void testNormalCase() {
        assertEquals(3, longestSubstring.longestSubString("abcabcbb"));
    }

    @Test
    void testRepeatedCharacters() {
        assertEquals(1, longestSubstring.longestSubString("bbbbb"));
    }

    @Test
    void testMixedCharacters() {
        assertEquals(3, longestSubstring.longestSubString("pwwkew"));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, longestSubstring.longestSubString(""));
    }

    @Test
    void testSingleCharacter() {
        assertEquals(1, longestSubstring.longestSubString("a"));
    }
}