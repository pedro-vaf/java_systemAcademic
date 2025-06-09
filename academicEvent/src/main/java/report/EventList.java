package report;

import event.BaseEvent;

public class EventList {
    public static void reportEventList(){
       if (!BaseEvent.getListEvent().isEmpty()){
           System.out.println("\n");
           for (BaseEvent event : BaseEvent.getListEvent()) {
               System.out.println(
                        "\n" + "Title: " + event.getTitle() + "\n" +
                               "Date: " + event.date + "\n" +
                               "Address: " + event.getAddress() + "\n" +
                               "Description: " + event.getDescription() + "\n" +
                               "Type: " + event.getTypeOfEvent() + "\n" +
                               "ID: " + event.getIdEvent() + "\n" +
                               "Total Capacity: " + event.getTotalEventCapacity() + "\n" +
                               "Registered Participants: " + event.registeredParticipants + "\n" +
                               "Qualification: " + event.getEventQualification()
               );
           }

       } else {
            System.out.println("\nEvent list is still empty!");
       }
    }
}
