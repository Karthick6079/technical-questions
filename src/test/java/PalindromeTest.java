import org.example.karthick.twopointer.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    Palindrome palindrome = new Palindrome();

    @Test
    void testValidPalindrome(){
        String input = "madam";
        boolean expected = palindrome.isValidPalindrome(input);

        assertTrue(expected);
    }
}
