package menu;

import java.util.Scanner;

public class BaseMenu {
    public static int baseMenu(Scanner sc){
        System.out.println("\n*** Academic Event Menu ****");
        System.out.println("1 - Register participant");
        System.out.println("2 - Register Event");
        System.out.println("3 - Report section");
        System.out.println("4 - Print lists");
        System.out.println("5 - Generate certificate");
        System.out.println("6 - Exit");
        System.out.print("Number chosen: ");
        return sc.nextInt();
    }
}
