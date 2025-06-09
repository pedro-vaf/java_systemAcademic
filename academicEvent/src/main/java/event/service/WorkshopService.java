package event.service;

import event.BaseEvent;
import event.EventRegistration;
import event.Workshop;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class WorkshopService extends EventRegistration {

    @Override
    protected BaseEvent createEvent(String title, LocalDate date, String address, String description, Integer typeOfEvent, Integer idEvent, Integer totalEventCapacity, Integer eventQualification) {
        return new Workshop(title, date, address, description, typeOfEvent, idEvent, totalEventCapacity, eventQualification);
    }

    public void registerEvent(Scanner sc) throws ParseException {
        registerEvent(sc,1);
    }
}
