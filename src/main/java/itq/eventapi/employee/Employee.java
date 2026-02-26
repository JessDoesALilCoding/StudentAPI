package itq.eventapi.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Employee {
    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;

}
