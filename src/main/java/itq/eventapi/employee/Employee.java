package itq.eventapi.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Employee {
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setRandomID() {
        id = UUID.randomUUID();
    }
}
