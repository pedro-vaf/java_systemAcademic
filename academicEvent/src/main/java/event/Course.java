package event;

import java.time.LocalDate;

public class Course extends BaseEvent {

    public Course(String title, LocalDate date, String address, String description, Integer typeOfEvent, Integer idEvent, Integer totalEventCapacity, Integer eventQualification) {
        super(title, date, address, description, typeOfEvent, idEvent, totalEventCapacity, eventQualification);
    }
}
