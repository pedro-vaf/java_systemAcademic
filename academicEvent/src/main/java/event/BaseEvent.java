package event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseEvent {

    protected String title;
    public LocalDate date;
    protected String address;
    protected String description;
    protected Integer typeOfEvent;
    protected Integer idEvent;
    protected Integer totalEventCapacity;
    protected Integer eventQualification;
    public int registeredParticipants = 0;
    protected static List<BaseEvent> listEvent = new ArrayList<>();

    public BaseEvent(String title, LocalDate date, String address, String description, Integer typeOfEvent, Integer idEvent, Integer totalEventCapacity, Integer eventQualification) {
        this.title = title;
        this.date = date;
        this.address = address;
        this.description = description;
        this.typeOfEvent = typeOfEvent;
        this.idEvent = idEvent;
        this.totalEventCapacity = totalEventCapacity;
        this.eventQualification = eventQualification;
        listEvent.add(this);
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public static List<BaseEvent> getListEvent() {
        return listEvent;
    }

    public Integer getTypeOfEvent() {
        return typeOfEvent;
    }

    public Integer getTotalEventCapacity() {
        return totalEventCapacity;
    }

    public Integer getEventQualification() {
        return eventQualification;
    }

    public LocalDate getDate() {return date;}
}
