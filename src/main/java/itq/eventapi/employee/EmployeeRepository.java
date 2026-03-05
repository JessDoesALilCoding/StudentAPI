package itq.eventapi.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class EmployeeRepository {
    private final HashMap<UUID, Employee> employees = new HashMap<>();

    public void add(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public void update(Employee employee) {
        if(employees.get(employee.getId()) == null)
            throw new IllegalArgumentException();
        employees.put(employee.getId(), employee);
    }

    public Employee get(UUID id) {
        if(employees.get(id) == null)
            throw new IllegalArgumentException();
        return employees.get(id);
    }

    public ArrayList<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    public void delete(UUID id) {
        if(employees.get(id) == null)
            throw new IllegalArgumentException();
        employees.remove(id);
    }
}