package menu;

import event.BaseEvent;
import logic.ReportEventDataLogic;
import logic.ReportEventTypeLogic;

import java.util.Scanner;

public class ReportEventMenu {
    public static void reportEventMenu(Scanner sc){

        if(!BaseEvent.getListEvent().isEmpty()){
            int choice;
            do {
                System.out.println("\n*** Event report ***");
                System.out.println("0 - Back the Base menu");
                System.out.println("1 - Report by event type");
                System.out.println("2 - Report by date");
                System.out.print("Number chosen: ");
                choice = sc.nextInt();

                switch (choice){
                    case 0:
                        break;
                    case 1:
                        ReportEventTypeLogic.reportEventTypeLogic(sc);
                        break;
                    case 2:
                        ReportEventDataLogic.reportEventLogic(sc);
                        break;
                }
            } while (choice != 0);

        } else {
            System.out.println("\nEvent list is still empty!");
        }
    }
}
