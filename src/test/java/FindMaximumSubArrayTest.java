import org.example.karthick.slidingwindow.FindMaximumSubArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMaximumSubArrayTest {

    FindMaximumSubArray findMaximumSubArray = new FindMaximumSubArray();

    @Test
    void testValidMaximumSubArray(){
        int[] input = {2,1,5,1,3,2};
        int k = 3;
        int output = 9;
        Assertions.assertEquals(output, findMaximumSubArray.findMaxAverage(input, k));
    }

    @Test
    void testInValidMaximumSubArray(){
        int[] input = {2,3,4,1,5};
        int k = 2;
        int output = 7;
        Assertions.assertEquals(output, findMaximumSubArray.findMaxAverage(input, k));
    }
}
