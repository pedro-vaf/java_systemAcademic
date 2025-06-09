package logic;

import event.BaseEvent;
import participant.BaseParticipant;

import java.util.Scanner;
import java.util.Set;

public class CertificateLogic {
    public static void certificateLogic() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("==========================================");
        System.out.println("            PARTICIPANT LIST              ");
        System.out.println("==========================================");

        for (BaseParticipant participant : BaseParticipant.getListParticipant()) {
            System.out.printf("ID: %-5d | Name: %s%n", participant.getIdParticipant(), participant.getName());
        }

        System.out.println("------------------------------------------");
        System.out.print("Enter participant ID: ");
        int idSelected = sc.nextInt();

        // Check if participant exists
        BaseParticipant selectedParticipant = null;
        for (BaseParticipant p : BaseParticipant.getListParticipant()) {
            if (p.getIdParticipant() == idSelected) {
                selectedParticipant = p;
                break;
            }
        }

        if (selectedParticipant == null) {
            System.out.println("\n[ERROR] Participant not found.");
            return;
        }

        // Check registered events
        Set<Integer> eventIds = ParticipantEventLinkLogic.getAllLinks().get(idSelected);
        if (eventIds == null || eventIds.isEmpty()) {
            System.out.println("\n[INFO] This participant is not registered in any events.");
            return;
        }

        // Display participant data
        System.out.println();
        System.out.println("==========================================");
        System.out.println("           PARTICIPANT DETAILS            ");
        System.out.println("==========================================");
        System.out.printf("Name : %s%n", selectedParticipant.getName());
        System.out.printf("Age  : %d%n", selectedParticipant.getAge());
        System.out.printf("Email: %s%n", selectedParticipant.getEmail());

        // Display registered events
        System.out.println();
        System.out.println("==========================================");
        System.out.println("           REGISTERED EVENTS              ");
        System.out.println("==========================================");

        for (BaseEvent event : BaseEvent.getListEvent()) {
            if (eventIds.contains(event.getIdEvent())) {
                System.out.println("---------- Event ----------");
                System.out.printf("Title      : %s%n", event.getTitle());
                System.out.printf("Date       : %s%n", event.date);
                System.out.printf("Address    : %s%n", event.getAddress());
                System.out.printf("Description: %s%n", event.getDescription());
                System.out.println("---------------------------");
            }
        }
    }
}