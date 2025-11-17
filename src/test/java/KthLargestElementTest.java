import org.example.karthick.KthLargestElement;

import java.util.Arrays;

public class KthLargestElementTest {
    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {1,2,7,8,9};
        System.out.println(kthLargestElement.findKthLargestElement(nums, 3));
    }
}
