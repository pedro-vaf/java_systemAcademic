package logic;

import event.BaseEvent;
import event.EventRegistration;


import java.util.Objects;
import java.util.Scanner;

public class ReportEventTypeLogic {
    public static void reportEventTypeLogic(Scanner sc){
        System.out.println("\nType of event you want to report on");
        System.out.println("0 - Back the Base menu");
        System.out.println("1 - Workshop");
        System.out.println("2 - Lecture");
        System.out.println("3 - Fair");
        System.out.println("4 - Course");
        System.out.print("Number chosen: ");
        int choice = sc.nextInt();

        boolean found = false;

        for(BaseEvent event : BaseEvent.getListEvent()){
            if(Objects.equals(choice, event.getEventQualification())){
                System.out.println(
                        "\n" + "Title: " + event.getTitle() + "\n" +
                                "Date: " + event.date + "\n" +
                                "Address: " + event.getAddress() + "\n" +
                                "Description: " + event.getDescription() + "\n" +
                                "ID: " + event.getIdEvent() + "\n" +
                                "Total Capacity: " + event.getTotalEventCapacity() + "\n" +
                                "Registered Participants: " + event.registeredParticipants + "\n" +
                                "Qualification: " + event.getEventQualification()
                );
                found = true;
            }
        }

        if (!found){
            System.out.println("\nThere is no event of this type registered yet!");
        }
    }
}
