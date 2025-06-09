package report;

import event.BaseEvent;
import event.Course;
import logic.ParticipantEventLinkLogic;

import java.util.Objects;
import java.util.Scanner;

public class ParticipantEventLink {
    public boolean eventLinkMenu(Scanner sc, int typeOfParticipant, int idParticipant, String participantName) {

        boolean success = true;
        // Mostra todos os eventos com ID
        System.out.println("\n*** List Event ***");
        for (BaseEvent event : BaseEvent.getListEvent()) {
            int capacity = event.getTotalEventCapacity() - event.registeredParticipants;
            System.out.println("ID: " + event.getIdEvent() + " | Title: " + event.getTitle() + " | Type: " + getEventTypeName(event.getTypeOfEvent()) + " | Available capacity: " + capacity);
        }

        System.out.print("\nEnter the ID of the event to register [" + participantName + "]: ");
        int chosenId = sc.nextInt();

        // Localiza o evento
        BaseEvent selectedEvent = null;
        for (BaseEvent event : BaseEvent.getListEvent()) {
            if (Objects.equals(chosenId, event.getIdEvent())) {
                selectedEvent = event;
                break;
            }
        }

        if (selectedEvent == null) {
            System.out.println("Event not found. Registration cancelled.");
            success = false;
            return false;
        }

        // Regras de associação: só estudante pode se inscrever em curso
        if (selectedEvent instanceof Course && typeOfParticipant != 1) {
            System.out.println("Only students are allowed to register for courses.");
            success = false;
            return false;
        }

        // Verifica se já está inscrito
        if (ParticipantEventLinkLogic.isParticipantRegistered(idParticipant, selectedEvent.getIdEvent())) {
            System.out.println(participantName + " is already registered for this event.");
            success = false;
            return false;
        }

        // Registra a inscrição
        for (BaseEvent le : BaseEvent.getListEvent()){
            if (Objects.equals(le.getIdEvent(), chosenId)) {
                if (le.registeredParticipants == le.getTotalEventCapacity()){
                    System.out.println("Event is full");
                    success = false;
                    return false;
                }
            }
        }

        String nomeEvent = "";
        for (BaseEvent le : BaseEvent.getListEvent()){
            if (Objects.equals(le.getIdEvent(), selectedEvent.getIdEvent())){
                nomeEvent = le.getTitle();
                le.registeredParticipants++;
            }
        }

        // Inscrição realizada
        System.out.println("\nRegistration successful! " + participantName + " has been registered for " + nomeEvent + ".");

        if (!success){
            return false;
        }

        ParticipantEventLinkLogic.register(idParticipant, selectedEvent.getIdEvent());
        return true;
    }

    private String getEventTypeName(int type) {
        return switch (type) {
            case 1 -> "Online";
            case 2 -> "In-Person";
            default -> "Unknown";
        };
    }
}
