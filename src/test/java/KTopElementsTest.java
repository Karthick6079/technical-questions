import org.example.karthick.KTopElements;

import java.util.Arrays;

public class KTopElementsTest {

    public static void main(String[] args) {
        KTopElements kTopElements = new KTopElements();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(kTopElements.KTopElements(nums, 2)));

    }
}
