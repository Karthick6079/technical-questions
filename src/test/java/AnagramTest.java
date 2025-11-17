import org.example.karthick.Anagram;

public class AnagramTest {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();

        System.out.println(anagram.isAnagram("anagram","nagaram"));
        System.out.println(anagram.isAnagram("car","cat"));

    }
}
