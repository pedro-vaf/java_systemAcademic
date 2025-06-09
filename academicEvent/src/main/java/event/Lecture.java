package event;

import java.time.LocalDate;
import java.util.Date;

public class Lecture extends BaseEvent {

    public Lecture(String title, LocalDate date, String address, String description, Integer typeOfEvent, Integer idEvent, Integer totalEventCapacity, Integer eventQualification ) {
        super(title, date, address, description, typeOfEvent, idEvent, totalEventCapacity, eventQualification);
    }
}
