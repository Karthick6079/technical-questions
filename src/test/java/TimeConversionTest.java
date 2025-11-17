import org.example.karthick.TimeConversion;

public class TimeConversionTest {

    public static void main(String[] args) {
        TimeConversion timeConversion = new TimeConversion();
        System.out.println(timeConversion.timeConversion("12:01:00PM"));
        System.out.println(timeConversion.timeConversion("03:01:00PM"));
        System.out.println(timeConversion.timeConversion("12:01:00AM"));
        System.out.println(timeConversion.timeConversion("05:01:00AM"));
    }
}
