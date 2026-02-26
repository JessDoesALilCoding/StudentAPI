package itq.eventapi.event;

import itq.eventapi.employee.Employee;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Data
public class Event {
    private final UUID id = UUID.randomUUID();
    private String name;
    private Date date;
    private ArrayList<Employee> participants = new ArrayList<>();


    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}
