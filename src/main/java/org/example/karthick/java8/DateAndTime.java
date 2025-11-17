package org.example.karthick.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class DateAndTime {

    public static void main(String[] args) {
        callLocalDate();
        callLocalTime();
        callLocalDateTime();
        callZonedDateTime();
        callInstant();
        callPeriod();
        callDuration();
        callDateFormatter();
    }

    private static void callLocalTime() {
        // Only Time, No Date and No TimeZone
        System.out.println("-------------------LOCAL TIME------------");
        LocalTime timenow = LocalTime.now();
        LocalTime lunchTime = LocalTime.of(13,0);
        LocalTime inTwoHours =  timenow.plusHours(2);

        System.out.println(timenow);
        System.out.println(lunchTime);
        System.out.println(inTwoHours);
    }



    private static void callLocalDate() {
        // Only Date, No Time and No Timezone
        System.out.println("-------------------LOCAL DATE------------");

        LocalDate date = LocalDate.now();
        date.format(DateTimeFormatter.ISO_WEEK_DATE);
        LocalDate specificDate = LocalDate.of(1997, 5, 7);
        LocalDate nextWeek = date.plusWeeks(1);
        LocalDate nextTwoWeek = date.plusWeeks(2);

        System.out.println(date);
        System.out.println(specificDate);
        System.out.println(nextWeek);
        System.out.println(nextTwoWeek);
    }

    private static void callLocalDateTime() {
        // Only Time and Date and No TimeZone
        System.out.println("-------------------LOCAL DATE TIME------------");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrowDateTime = LocalDateTime.of(2025,9,21, 13, 30);

        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("+00:00"));

        System.out.println(now);
        System.out.println(tomorrowDateTime);
        System.out.println(zonedDateTime);

    }


    private static void callZonedDateTime() {
        //  Time and Datewith TimeZone
        System.out.println("-------------------ZONED DATE TIME------------");

//        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia"));
//        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//        zoneIds.forEach(System.out::println);

        LocalDateTime localDateTime = LocalDateTime.of(2025,9,22, 20,30);

        ZonedDateTime indiaTime = ZonedDateTime.of(localDateTime, (ZoneId.of("Asia/Kolkata")));
        ZonedDateTime madridTIme = indiaTime.withZoneSameInstant(ZoneId.of("Europe/Madrid"));
        ZonedDateTime londonTime = indiaTime.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime dublin = indiaTime.withZoneSameInstant(ZoneId.of("Europe/Dublin"));



        System.out.println(indiaTime);
        System.out.println(madridTIme);
        System.out.println(londonTime);
        System.out.println(dublin);

    }

    private static void callInstant(){
        Instant now = Instant.now();
        System.out.println("Epoch Time: " + now.getEpochSecond());
    }

    private static void callPeriod(){
        LocalDate empJoinDate = LocalDate.of(2017, 06, 17);
        LocalDate today = LocalDate.now();
        Period diff = Period.between(empJoinDate, today);
        System.out.printf("Difference: %d years, %d months, %d days%n",
                diff.getYears(), diff.getMonths(), diff.getDays());
    }

    private static void callDuration(){
        LocalTime shiftStart = LocalTime.of(9,0);
        LocalTime shiftEnd = LocalTime.of(17,30);
        Duration duration = Duration.between(shiftStart, shiftEnd);
        System.out.println(duration);
        System.out.printf("Difference in hours - %d hours\n", duration.toHours());
        System.out.printf("Difference in minutes -  %d minutes\n",  duration.toMinutes());
        System.out.printf("Difference in seconds -  %d seconds\n", duration.toSeconds());
    }

    private static void callDateFormatter(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

        String formatted = now.format(formatter);
        System.out.println("Formatted: " + formatted);

        LocalDate parsedDate = LocalDate.parse("20-09-2025", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Parsed: " + parsedDate);
    }


}
