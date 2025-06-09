package logic;

import event.BaseEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

public class ReportEventDataLogic {
    public static void reportEventLogic(Scanner sc){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        sc.nextLine();
        LocalDate eventDate = null;

        System.out.print("\nDate of event: | format [dd/MM/yyyy]: ");
        String dateString = sc.nextLine();
        try {
            eventDate = LocalDate.parse(dateString, formatter);

            for (BaseEvent event : BaseEvent.getListEvent()){
                if (Objects.equals(eventDate, event.getDate())){
                    System.out.println(
                            "\n" + "Title: " + event.getTitle() + "\n" +
                                    "Address: " + event.getAddress() + "\n" +
                                    "Description: " + event.getDescription() + "\n" +
                                    "Type: " + event.getTypeOfEvent() + "\n" +
                                    "ID: " + event.getIdEvent() + "\n" +
                                    "Total Capacity: " + event.getTotalEventCapacity() + "\n" +
                                    "Registered Participants: " + event.registeredParticipants + "\n" +
                                    "Qualification: " + event.getEventQualification()
                    );
                } else {
                    System.out.println("⚠ There is no event with this date");
                }
            }

        } catch (DateTimeParseException e) {
            System.out.println("⚠ Invalid date format. Please use [dd/MM/yyyy].");
        }
    }
}
