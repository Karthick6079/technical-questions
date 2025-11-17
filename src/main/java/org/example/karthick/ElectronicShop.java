package org.example.karthick;

import java.util.Arrays;
import java.util.Comparator;

public class ElectronicShop {

    public int getMaxSpentMoneyOnKeyBoardAndDrives(int[] keyboards, int[] drives, int target){
        Arrays.sort(keyboards);
        drives = Arrays.stream(drives).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int keyboardPointer = 0;
        int drivePointer = 0;

        int total = 0;
        int best = -1;

        while(keyboardPointer < keyboards.length && drivePointer < drives.length){
            total = keyboards[keyboardPointer] + drives[drivePointer];

            if( total > target) {
                drivePointer++;
            } else {
                if(total > best) {
                    best = total;
                }
                keyboardPointer++;
            }
        }

        return best;
    }
}
