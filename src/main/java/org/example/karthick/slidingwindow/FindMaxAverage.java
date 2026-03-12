package org.example.karthick.slidingwindow;

public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k){

        int windowSum = 0, maxSum = 0;
        for(int i = 0 ; i < k; i++){
            windowSum += nums[i];
        }

        maxSum = windowSum;

        for(int right = k; right < nums.length; right++){
            windowSum += nums[right] - nums[right - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum/k;
    }
}
