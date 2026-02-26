package itq.eventapi.event;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {
    private EventService service;

    @GetMapping
    public ArrayList<Event> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Event get(@PathVariable UUID id) {
        return service.getEvent(id);
    }

}
