package itq.eventapi.event;

import itq.eventapi.employee.Employee;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Data
public class Event {
    private UUID id = UUID.randomUUID();
    private String name;
    private Date date;
    private final HashMap<UUID, Employee> employees = new HashMap<>();

    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee.getId());
    }

    public void setRandomID() {
        id = UUID.randomUUID();
    }
}
