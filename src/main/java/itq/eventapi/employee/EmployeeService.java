package itq.eventapi.employee;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository repository;

    public ResponseEntity<Employee> addEmployee(Employee employee) {
        employee.setRandomID();
        if (employee.getFirstName().isEmpty() || employee.getLastName().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        repository.add(employee);
        return ResponseEntity.status(HttpStatus.OK).body(employee);

    }

    public ResponseEntity<Employee> getEmployee(UUID id) {
        try {
            Employee e = repository.get(id);
            return ResponseEntity.status(HttpStatus.OK).body(e);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee id " + id + " not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ArrayList<Employee> getAll() {
        return repository.getAll();
    }

    public ResponseEntity<Employee> updateEmployee(Employee employee) {
        try {
            Employee e = repository.get(employee.getId());
            if (e.getFirstName().isEmpty() || e.getLastName().isEmpty())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            repository.update(employee);
            return ResponseEntity.status(HttpStatus.OK).body(e);

        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee " + employee + " not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<Employee> deleteEmployee(UUID id) {
        try {
            Employee e = repository.get(id);
            repository.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(e);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee id " + id + " not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
