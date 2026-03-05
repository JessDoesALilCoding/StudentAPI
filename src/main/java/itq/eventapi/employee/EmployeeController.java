package itq.eventapi.employee;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable UUID id) {
        return service.deleteEmployee(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable UUID id) {
        return service.getEmployee(id);
    }

    @PatchMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }
}
