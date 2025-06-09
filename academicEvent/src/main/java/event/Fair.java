package event;

import java.time.LocalDate;

public class Fair extends BaseEvent {
    public Fair(String title, LocalDate date, String address, String description, Integer typeOfEvent, Integer idEvent, Integer totalEventCapacity, Integer eventQualification) {
        super(title, date, address, description, typeOfEvent, idEvent, totalEventCapacity, eventQualification);
    }
}
