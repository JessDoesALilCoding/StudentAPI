package itq.eventapi.employee;

import itq.eventapi.event.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository repository;

    public void addEmployee(Employee employee) {
        employee.setRandomID(); //Ensure random UUID
        try {
            repository.add(employee);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee already exists");
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            repository.update(employee);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee " + employee + " not found!");
        }
    }

    public void deleteEmployee(UUID id) {
        try {
            repository.delete(id);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee id " + id + " not found!");
        }
    }

    public Employee getEmployee(UUID id) {
        Employee s = null;
        try {
            s = repository.get(id);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee id " + id + " not found!");
        }
        return s;
    }

    public ArrayList<Employee> getAll() {
        return repository.getAll();
    }
}
