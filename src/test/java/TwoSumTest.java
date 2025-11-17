import org.example.karthick.TwoSum;

import java.util.Arrays;

public class TwoSumTest {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = {2,7,11,15};
        int target = 13;
        System.out.println(Arrays.toString(twoSum.twoSumSortedArray(arr, target)));
    }
}
