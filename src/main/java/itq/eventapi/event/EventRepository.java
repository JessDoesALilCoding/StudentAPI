package itq.eventapi.event;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class EventRepository {

    private final HashMap<UUID, Event> events = new HashMap<>();


    public void add(Event event) {
        if(events.get(event.getId()) != null)
            throw new IllegalArgumentException();

        events.put(event.getId(), event);
    }

    public void update(Event event) {
        if(events.get(event.getId()) == null)
            throw new IllegalArgumentException();

        events.put(event.getId(), event);
    }

    public Event get(UUID id) {
        if(events.get(id) == null)
            throw new IllegalArgumentException();

        return events.get(id);
    }

    public void delete(UUID id) {
        if(events.get(id) == null)
            throw new IllegalArgumentException();

        events.remove(id);
    }



}
