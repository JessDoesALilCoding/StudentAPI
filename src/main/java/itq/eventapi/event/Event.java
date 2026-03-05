package itq.eventapi.event;

import itq.eventapi.employee.Employee;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Data
public class Event {
    private UUID id = UUID.randomUUID();
    private String name;
    private Date date;
    private int maxParticipants;
    private final ArrayList<UUID> employees = new ArrayList<>();

    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public void addEmployee(UUID employeeID) {
        employees.add(employeeID);
    }

    public void removeEmployee(UUID employeeID) {
        employees.remove(employeeID);
    }

    public void setRandomID() {
        id = UUID.randomUUID();
    }
}
