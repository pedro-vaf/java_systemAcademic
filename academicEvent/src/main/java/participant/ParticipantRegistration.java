package participant;

import event.BaseEvent;
import report.ParticipantEventLink;
import menu.*;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public abstract class ParticipantRegistration {

    EventMenu eventMenu = new EventMenu();

    public void registerParticipant(Scanner sc, int participantTypeNumber) {
        String participantTypeString = "";
        switch (participantTypeNumber) {
            case 1:
                participantTypeString = "student";
                break;
            case 2:
                participantTypeString = "teacher";
                break;
            case 3:
                participantTypeString = "visitor";
                break;
        }

        sc.nextLine(); // limpa buffer pendente

        // Verifica se há eventos compatíveis
        if (!hasCompatibleEventForParticipant(participantTypeNumber)) {
            System.out.println("⚠ No valid events available for a " + participantTypeString + ".");
            System.out.println("You must first register a suitable event.");
            eventMenu.eventMenu(sc);
            return;
        }

        boolean continueRegistering = true;
        boolean success;

        System.out.println("\n*** " + participantTypeString + " registration section started ***");

        while (continueRegistering) {
            try {
                // Nome
                String name;
                while (true) {
                    System.out.print("Enter " + participantTypeString + " name: ");
                    name = sc.nextLine();
                    if (!name.isBlank()) break;
                    System.out.println("⚠ Name cannot be empty.");
                }

                // Idade
                int age = 0;
                while (true) {
                    System.out.print("Enter " + participantTypeString + " age: ");
                    try {
                        age = sc.nextInt();
                        sc.nextLine(); // limpa buffer
                        if (age > 0) break;
                        System.out.println("⚠ Age must be greater than 0.");
                    } catch (InputMismatchException e) {
                        System.out.println("⚠ Invalid input. A number was expected.");
                        sc.nextLine();
                    }
                }

                // E-mail
                String email;
                while (true) {
                    System.out.print("Enter " + participantTypeString + " e-mail: ");
                    email = sc.nextLine();
                    if (email.contains("@") && email.contains(".")) break;
                    System.out.println("⚠ Invalid e-mail. Please try again.");
                }

                // ID
                int id = 0;
                boolean validId = false;
                while (!validId) {
                    System.out.print("Enter " + participantTypeString + " registration (ID number): ");
                    try {
                        id = sc.nextInt();
                        sc.nextLine();

                        boolean idExists = false;
                        for (BaseParticipant lP : BaseParticipant.getListParticipant()) {
                            if (id == lP.getIdParticipant()) {
                                idExists = true;
                                break;
                            }
                        }

                        if (idExists) {
                            System.out.println("⚠ ID already registered. Please enter a different one.");
                        } else {
                            validId = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("⚠ Invalid input. A number was expected.");
                        sc.nextLine();
                    }
                }

                // Vinculação ao evento
                System.out.println("*** Select the type of event the " + participantTypeString + " will participate in ***");
                ParticipantEventLink linkMenu = new ParticipantEventLink();
                success = linkMenu.eventLinkMenu(sc, participantTypeNumber, id, name);

                if (!success){
                    System.out.println("Error registering student!");
                    break;
                }

                // Criação do participante
                BaseParticipant participant = createParticipant(name, age, email, id);

                // Pergunta se deseja cadastrar outro
                sc.nextLine();
                System.out.print("\nRegister another " + participantTypeString + "? (yes/no): ");
                String response = sc.nextLine().trim().toLowerCase();
                continueRegistering = Objects.equals(response, "yes");
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("⚠ An error occurred: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    protected abstract BaseParticipant createParticipant(String name, int age, String email, int id);

    private boolean hasCompatibleEventForParticipant(int participantTypeNumber) {
        for (BaseEvent event : BaseEvent.getListEvent()) {
            int eventType = event.getEventQualification();

            if (participantTypeNumber == 1) {
                return true;
            } else {
                if (eventType != 4) return true;
            }
        }
        return false;
    }
}