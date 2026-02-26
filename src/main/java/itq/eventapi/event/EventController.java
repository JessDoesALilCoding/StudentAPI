package itq.eventapi.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/events")

public class EventController {

    @GetMapping("/hello")
    public String hello() {
        Event s = new Event(UUID.randomUUID(),"test");
        return "Heywassuphello!";
    }
}
