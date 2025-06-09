package menu;


import event.EventRegistration;
import event.service.*;

import java.util.Scanner;


public class EventMenu {

    public static void eventMenu(Scanner sc)  {
        System.out.println("\nWhat type of event do you want to register?");
        System.out.println("0 - Back the Base menu");
        System.out.println("1 - Workshop");
        System.out.println("2 - Lecture");
        System.out.println("3 - Fair");
        System.out.println("4 - Course");
        System.out.print("Number chosen: ");
        int choice = sc.nextInt();

        EventRegistration registration = null;

        switch (choice){
            case 0:
                break;
            case 1:
                registration = new WorkshopService();
                registration.registerEvent(sc, 1);
                break;
            case 2:
                registration = new LectureService();
                registration.registerEvent(sc, 2);
                break;
            case 3:
                registration = new FairService();
                registration.registerEvent(sc, 3);
                break;
            case 4:
                registration = new CourseService();
                registration.registerEvent(sc, 4);
                break;
        }
    }
}