package menu;

import logic.CertificateLogic;
import logic.ParticipantEventLinkLogic;


public class ReportCertificateMenu {
    public static void reportCertificate(){
        if (!ParticipantEventLinkLogic.isEmpty()){
            System.out.println("\n*** Certificate Text ****");
            CertificateLogic.certificateLogic();
        }  else {
            System.out.println("\nNo participant-event links registered yet!");
        }

    }
}
