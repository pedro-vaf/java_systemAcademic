package event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public abstract class EventRegistration {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void registerEvent(Scanner sc, int eventTypeNumber) {
        String eventTypeString = "";
        switch (eventTypeNumber) {
            case 1:
                eventTypeString = "Workshop";
                break;
            case 2:
                eventTypeString = "Lecture";
                break;
            case 3:
                eventTypeString = "Fair";
                break;
            case 4:
                eventTypeString = "Course";
                break;
        }

        boolean continueRegistering = true;

        sc.nextLine(); // Consome quebra de linha pendente

        System.out.println("\n*** " + eventTypeString + " registration section started ***");

        while (continueRegistering) {
            try {
                // Título
                String title;
                while (true) {
                    System.out.print("Enter " + eventTypeString + " title: ");
                    title = sc.nextLine();
                    if (!title.isBlank()) break;
                    System.out.println("⚠ Title cannot be empty.");
                }

                // Data
                LocalDate eventDate = null;
                while (true) {
                    System.out.print("Enter " + eventTypeString + " date | format [dd/MM/yyyy]: ");
                    String dateString = sc.nextLine();
                    try {
                        eventDate = LocalDate.parse(dateString, formatter);
                        LocalDate today = LocalDate.now();

                        if (eventDate.isAfter(today)) {
                            break; // Data válida e futura → sai do laço
                        } else {
                            System.out.println("⚠ Date must be in the future.");
                        }

                    } catch (DateTimeParseException e) {
                        System.out.println("⚠ Invalid date format. Please use [dd/MM/yyyy].");
                    }
                }

                // Endereço
                String address;
                while (true) {
                    System.out.print("Enter " + eventTypeString + " address: ");
                    address = sc.nextLine();
                    if (!address.isBlank()) break;
                    System.out.println("⚠ Address cannot be empty.");
                }

                // Descrição
                String description;
                while (true) {
                    System.out.print("Enter " + eventTypeString + " description: ");
                    description = sc.nextLine();
                    if (!description.isBlank()) break;
                    System.out.println("⚠ Description cannot be empty.");
                }

                // Capacidade
                int fullCapacity = 0;
                while (true) {
                    System.out.print("Enter the full capacity of participants: ");
                    try {
                        fullCapacity = sc.nextInt();
                        sc.nextLine(); // limpa buffer
                        if (fullCapacity > 0) break;
                        System.out.println("⚠ Capacity must be greater than 0.");
                    } catch (InputMismatchException e) {
                        System.out.println("⚠ Invalid input: a number was expected.");
                        sc.nextLine();
                    }
                }

                // Tipo de evento
                int typeOfEvent = 1;
                while (true) {
                    System.out.print("Enter the event type [online | in-person]: ");
                    String typeCourse = sc.nextLine().trim().toLowerCase();
                    if (typeCourse.equals("online")) {
                        typeOfEvent = 1;
                        break;
                    } else if (typeCourse.equals("in-person")) {
                        typeOfEvent = 2;
                        break;
                    } else {
                        System.out.println("⚠ Invalid input. Please type 'online' or 'in-person'.");
                    }
                }

                // ID
                int id = 0;
                boolean validId = false;
                while (!validId) {
                    System.out.print("Enter " + eventTypeString + " registration (ID number): ");
                    try {
                        id = sc.nextInt();
                        sc.nextLine();

                        boolean idExists = false;
                        for (BaseEvent le : BaseEvent.getListEvent()) {
                            if (id == le.getIdEvent()) {
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
                        System.out.println("⚠ Invalid input: a number was expected.");
                        sc.nextLine();
                    }
                }

                // Criação do evento
                BaseEvent event = createEvent(title, eventDate, address, description, typeOfEvent, id, fullCapacity, eventTypeNumber);

                // Pergunta se quer continuar
                System.out.print("Do you want to register another " + eventTypeString + "? - [yes | no]: ");
                String choose = sc.nextLine().trim().toLowerCase();
                if (Objects.equals(choose, "no")) {
                    continueRegistering = false;
                }

                System.out.println("\n*** Registration completed ***\n");

            } catch (Exception e) {
                System.out.println("⚠ An unexpected error occurred: " + e.getMessage());
                sc.nextLine(); // evita travamento
            }
        }
    }

    protected abstract BaseEvent createEvent(String title, LocalDate date, String address, String description, Integer typeOfEvent, Integer idEvent, Integer totalEventCapacity, Integer eventQualification);
}
