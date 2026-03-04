package itq.eventapi.employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
