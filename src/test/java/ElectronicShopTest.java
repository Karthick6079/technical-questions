import org.example.karthick.ElectronicShop;

public class ElectronicShopTest {

    public static void main(String[] args) {
        ElectronicShop electronicShop =  new ElectronicShop();

        int[] keyboards = {40,50,60};
        int[] drives = {5,8,12};
        int target = 60;

        System.out.println(electronicShop.getMaxSpentMoneyOnKeyBoardAndDrives(keyboards, drives, target));

        int[] keyboards2 = {40,50,60};
        int[] drives2 = {5,8,12};
        int target2 = 1;

        System.out.println(electronicShop.getMaxSpentMoneyOnKeyBoardAndDrives(keyboards2, drives2, target2));

    }
}
