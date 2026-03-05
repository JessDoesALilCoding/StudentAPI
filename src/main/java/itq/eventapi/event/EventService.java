package itq.eventapi.event;

import itq.eventapi.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private EventRepository repository;

    public ResponseEntity<Event> addEvent(Event event) {
        event.setRandomID();
        if (event.getName().isEmpty())
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);

        repository.add(event);
        return ResponseEntity.status(HttpStatus.OK).body(event);

    }

    public ResponseEntity<Event> getEvent(UUID id) {
        try {
            Event e = repository.get(id);
            return ResponseEntity.status(HttpStatus.OK).body(e);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Event id " + id + " not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ArrayList<Event> getAll() {
        return repository.getAll();
    }

    public ResponseEntity<Event> updateEvent(Event event) {
        try {
            Event e = repository.get(event.getId());
            if (event.getName().isEmpty())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


            if (event.getEmployees().size() > event.getMaxParticipants())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            repository.update(event);
            return ResponseEntity.status(HttpStatus.OK).body(e);

        } catch (IllegalArgumentException ignored) {
            System.err.println("Event " + event + " not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<Event> deleteEvent(UUID id) {
        try {
            Event e = repository.get(id);
            repository.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(e);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Event id " + id + " not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<Event> addEmployee(UUID eventID, Employee employee) {
        try {
            Event e = repository.get(eventID);
            if (employee == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            if (e.getDate().before(new Date()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            if (e.getEmployees().size() + 1 > e.getMaxParticipants())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            e.addEmployee(employee);
            return ResponseEntity.status(HttpStatus.OK).body(e);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee- or Event ID not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<Event> removeEmployee(UUID eventID, Employee employee) {
        try {
            Event e = repository.get(eventID);
            if (employee == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            e.removeEmployee(employee);
            return ResponseEntity.status(HttpStatus.OK).body(e);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Employee- or Event ID not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
