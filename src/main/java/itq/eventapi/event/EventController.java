package itq.eventapi.event;

import itq.eventapi.employee.Employee;
import itq.eventapi.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {
    private EventService service;
    private EmployeeService employeeService;

    @GetMapping
    public ArrayList<Event> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Event add(@RequestBody Event event) {
        service.addEvent(event);
        return event;
    }

    @PatchMapping
    public Event update(@RequestBody Event event) {
        service.updateEvent(event);
        return event;
    }

    @PostMapping("/{id}")
    public Event get(@PathVariable UUID id) {
        return service.getEvent(id);
    }


    @PostMapping("/{eventId}/employee/{employeeId}")
    public Event addEmployee(@PathVariable UUID eventId, @PathVariable UUID employeeId) {
        Event event = service.getEvent(eventId);
        Employee employee = employeeService.getEmployee(employeeId);
        event.addEmployee(employee);
        return event;
    }

    @DeleteMapping("/{eventId}/employee/{employeeId}")
    public Event removeEmployee(@PathVariable UUID eventId, @PathVariable UUID employeeId) {
        Event event = service.getEvent(eventId);
        Employee employee = employeeService.getEmployee(employeeId);
        event.removeEmployee(employee);
        return event;
    }
}
