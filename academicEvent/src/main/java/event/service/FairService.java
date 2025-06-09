package event.service;

import event.BaseEvent;
import event.EventRegistration;
import event.Fair;

import java.time.LocalDate;
import java.util.Scanner;

public class FairService extends EventRegistration {

    @Override
    protected BaseEvent createEvent(String title, LocalDate date, String address, String description, Integer typeOfEvent, Integer idEvent, Integer totalEventCapacity, Integer eventQualification) {
        return new Fair(title, date, address, description, typeOfEvent, idEvent, totalEventCapacity, eventQualification);
    }

    public void registerEvent(Scanner sc){
        registerEvent(sc, 3);
    }
}
