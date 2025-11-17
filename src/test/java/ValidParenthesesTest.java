import org.example.karthick.ValidParentheses;

public class ValidParenthesesTest {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String str = "[(())";
        System.out.printf("Is %s is valid? %b",str, validParentheses.isValid(str));
    }
}
