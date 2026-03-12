package org.example.karthick;

public class RemoveDuplicates {

    public int removeDuplicate(int[] arr){

        int slow = 1;

        for(int fast = 1; fast < arr.length; fast++){
            if(arr[fast] != arr[fast-1]){
                arr[slow] = arr[fast];
                slow++;
            }
        }
        return slow;
    }
}
