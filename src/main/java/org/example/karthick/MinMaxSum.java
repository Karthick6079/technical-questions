package org.example.karthick;

public class MinMaxSum {

    public void minMaxSum(int[] arr){
        int total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > max) {
                max = arr[i];
            }
            total += arr[i];
        }

        System.out.print((total - max)  + " " + (total - min));
    }
}
