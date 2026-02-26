package itq.eventapi.event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private EventRepository repository;

    public void addEvent(Event event) {
        try {
            repository.add(event);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Student already exists");
        }
    }

    public void updateEvent(Event event) {
        try {
            repository.update(event);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Student ID not found");
        }
    }

    public void deleteEvent(UUID id) {
        try {
            repository.delete(id);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Student ID not found");
        }
    }

    public Event getEvent(UUID id) {
        Event s = null;
        try {
            s = repository.get(id);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Student ID not found");
        }
        return s;
    }

    public ArrayList<Event> getAll() {
        return repository.getAll();
    }

}
