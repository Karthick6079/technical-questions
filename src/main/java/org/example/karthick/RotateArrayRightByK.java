package org.example.karthick;

public class RotateArrayRightByK {

    // Rotate right
    public void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n; //handle k > n
        if ( k == 0) return;

        reverse(nums, 0, n-1); // Step1: reverse entire array
        reverse(nums,0, k-1); // Step2: reverse first k elements
        reverse(nums, k, n-1); // step3: reverse remaining elements
    }


    private void reverse(int[] arr, int left, int right){

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
