package itq.eventapi.employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService service;

    @GetMapping
    public ArrayList<Employee> getAll() {
        return service.getAll();
    }

    @DeleteMapping
    public void delete(@RequestBody Employee employee) {
        service.deleteEmployee(employee.getId());
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable UUID id) {
        return service.getEmployee(id);
    }

    @PatchMapping
    public Employee update(@RequestBody Employee employee) {
        service.updateEmployee(employee);
        return employee;
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        service.addEmployee(employee);
        return employee;
    }
}
