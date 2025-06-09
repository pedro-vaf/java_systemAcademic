package menu;

import java.text.ParseException;
import java.util.Scanner;

import event.BaseEvent;

import participant.ParticipantRegistration;
import participant.service.StudentService;
import participant.service.TeacherService;
import participant.service.VisitorService;

public class ParticipantMenu {

    public static void menuParticipant(Scanner sc) throws ParseException {

        if (!BaseEvent.getListEvent().isEmpty()){
            System.out.println("\nWhat type of participant do you want to register?");
            System.out.println("0 - Back the Base menu");
            System.out.println("1 - Student");
            System.out.println("2 - Teacher");
            System.out.println("3 - Visitor");
            System.out.print("Number chosen: ");
            int choice = sc.nextInt();

            ParticipantRegistration registration = null;

            switch (choice){
                case 0:
                    break;
                case 1:
                    registration = new StudentService();
                    registration.registerParticipant(sc, choice);
                    break;
                case 2:
                    registration = new TeacherService();
                    registration.registerParticipant(sc, choice);
                    break;
                case 3:
                    registration = new VisitorService();
                    registration.registerParticipant(sc, choice);
                    break;
            }
        } else {
            System.out.println("\nTo register, at least one event is required. The event registration menu will be accessed automatically\n");
            EventMenu.eventMenu(sc);
        }
    }
}
