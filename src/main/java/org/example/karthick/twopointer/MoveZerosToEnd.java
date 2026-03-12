package org.example.karthick.twopointer;

import java.util.Arrays;

public class MoveZerosToEnd {


    public void moveZerosToEnd(int[] nums){
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }

        System.out.println(Arrays.toString(nums));

    }
}
