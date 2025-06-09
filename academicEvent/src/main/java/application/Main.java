package application;

import menu.*;

import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        int validator;

        do {
            validator = BaseMenu.baseMenu(sc);
            if (Objects.equals(validator, 1)){
                ParticipantMenu.menuParticipant(sc);
            } else if (Objects.equals(validator, 2)){
                EventMenu.eventMenu(sc);
            } else if (Objects.equals(validator, 3)) {
                ReportEventMenu.reportEventMenu(sc);
            } else if (Objects.equals(validator, 4)){
                ReportListMenu.menuListReport(sc);
            } else if (Objects.equals(validator, 5)){
                ReportCertificateMenu.reportCertificate();
            } else if (Objects.equals(validator, 6)){
                System.out.println("\nClosing academic system.");
            }
        } while (validator != 6);

        sc.close();
    }
}
