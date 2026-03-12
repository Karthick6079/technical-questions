package org.example.karthick.slidingwindow;

public class FindMaximumSubArray {

    public double findMaxAverage(int[] nums, int k){

        int windowSum = 0, maxSum = 0;
        for(int i = 0 ; i < k; i++){
            windowSum += nums[i];
        }

        maxSum = windowSum;

        for(int right = k; right < nums.length; right++){
            windowSum += nums[right] - nums[right - k]; // Sliding the window by adding right most element and removing left most element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
