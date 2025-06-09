package menu;

import report.EventList;
import report.EventParticipantLink;
import report.ParticipantList;

import java.util.Scanner;

public class ReportListMenu {
    public static void menuListReport(Scanner sc){
        int choice;
        do {
            System.out.println("\n*** Which list do you want to print ***");
            System.out.println("0 - Back the Base menu");
            System.out.println("1 - Event list");
            System.out.println("2 - Participant list");
            System.out.println("3 - List with link between event and participant");
            System.out.print("Number chosen: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    EventList.reportEventList();
                    break;
                case 2:
                    ParticipantList.reportParticipantList();
                    break;
                case 3:
                    EventParticipantLink.reportEventParticipantLink();
                    break;
            }
        } while (choice != 0);
    }
}
