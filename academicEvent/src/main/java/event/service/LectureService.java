package event.service;

import event.BaseEvent;
import event.EventRegistration;
import event.Lecture;

import java.time.LocalDate;
import java.util.Scanner;

public class LectureService extends EventRegistration {

    @Override
    protected BaseEvent createEvent(String title, LocalDate date, String address, String description, Integer typeOfEvent, Integer idEvent, Integer totalEventCapacity, Integer eventQualification) {
        return new Lecture(title, date, address, description, typeOfEvent, idEvent, totalEventCapacity, eventQualification);
    }

    public void registerEvent(Scanner sc) {
        registerEvent(sc, 2);
    }
}
