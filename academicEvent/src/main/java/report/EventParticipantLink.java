package report;

import logic.ParticipantEventLinkLogic;

import java.util.Map;
import java.util.Set;

public class EventParticipantLink {
    public static void reportEventParticipantLink() {
        if (!ParticipantEventLinkLogic.isEmpty()) {
            System.out.println("\n*** Participant → Events ***");
            for (Map.Entry<Integer, Set<Integer>> entry : ParticipantEventLinkLogic.getAllLinks().entrySet()) {
                System.out.println("Participant ID: " + entry.getKey() +
                        " | Event IDs: " + entry.getValue());
            }
        } else {
            System.out.println("\nNo participant-event links registered yet!");
        }
    }
}