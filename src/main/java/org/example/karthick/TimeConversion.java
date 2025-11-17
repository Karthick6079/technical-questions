package org.example.karthick;

public class TimeConversion {

    public String timeConversion(String s) {
        // Write your code here
        String timeFormat = s.substring(s.length()-2, s.length());
        Integer twentyFourFormatHour = Integer.valueOf(s.substring(0, 2));

        if(timeFormat.equalsIgnoreCase("PM")){
            String hours = s.substring(0, 2);
            Integer hoursInInteger = Integer.valueOf(hours);
            if(hoursInInteger != 12){
                twentyFourFormatHour = 12 + hoursInInteger;
            }

        } else if(timeFormat.equalsIgnoreCase("AM")) {
            String hours = s.substring(0, 2);
            Integer hoursInInteger = Integer.valueOf(hours);
            if(hoursInInteger == 12){
                twentyFourFormatHour = 00;
            }
        }

        return twentyFourFormatHour + s.substring(2);

    }
}
