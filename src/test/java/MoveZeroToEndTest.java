import org.example.karthick.twopointer.MoveZerosToEnd;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroToEndTest {

    MoveZerosToEnd moveZerosToEnd = new MoveZerosToEnd();

    @Test
    void testMixedZeroInArray(){

        int[] input = {1,0,2,0,3,0};
        int[] expected = {1,2,3,0,0,0};

        moveZerosToEnd.moveZerosToEnd(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testNonZeroArray(){

        int[] input = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};

        moveZerosToEnd.moveZerosToEnd(input);

        assertArrayEquals(expected, input);
    }
}
