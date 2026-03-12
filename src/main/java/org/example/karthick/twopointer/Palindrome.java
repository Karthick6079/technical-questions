package org.example.karthick.twopointer;

public class Palindrome {

    public boolean isValidPalindrome(String s){
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
