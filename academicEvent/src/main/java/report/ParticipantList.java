package report;

import participant.BaseParticipant;

public class ParticipantList {
    public static void reportParticipantList() {
        if (!BaseParticipant.getListParticipant().isEmpty()) {
            System.out.println("\n");
            for (BaseParticipant participant : BaseParticipant.getListParticipant()) {
                System.out.println( "\n" +
                                "Name: " + participant.getName() + "\n" +
                                "Age: " + participant.getAge() + "\n" +
                                "Email: " + participant.getEmail() + "\n" +
                                "ID: " + participant.getIdParticipant()
                );
            }
        } else {
            System.out.println("\nParticipant list is still empty!");
        }
    }
}