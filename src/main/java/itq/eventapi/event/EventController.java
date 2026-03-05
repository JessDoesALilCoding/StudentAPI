package itq.eventapi.event;

import itq.eventapi.employee.Employee;
import itq.eventapi.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {
    private EventService service;
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Event> add(@RequestBody Event event) {
        return service.addEvent(event);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> get(@PathVariable UUID id) {
        return service.getEvent(id);
    }

    @GetMapping
    public ArrayList<Event> getAll() {
        return service.getAll();
    }

    @PatchMapping
    public ResponseEntity<Event> update(@RequestBody Event event) {
        return service.updateEvent(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> delete(@PathVariable UUID id) {
        return service.deleteEvent(id);
    }

    @PostMapping("/{eventId}/employee/{employeeId}")
    public ResponseEntity<Event> addEmployee(@PathVariable UUID eventId, @PathVariable UUID employeeId) {
        ResponseEntity<Employee> employeeResponseEntity = employeeService.getEmployee(employeeId);

        return service.addEmployee(eventId,employeeResponseEntity.getBody());
    }

    @DeleteMapping("/{eventId}/employee/{employeeId}")
    public ResponseEntity<Event> removeEmployee(@PathVariable UUID eventId, @PathVariable UUID employeeId) {
        ResponseEntity<Employee> employeeResponseEntity = employeeService.getEmployee(employeeId);

        return service.removeEmployee(eventId,employeeResponseEntity.getBody());
    }

}
