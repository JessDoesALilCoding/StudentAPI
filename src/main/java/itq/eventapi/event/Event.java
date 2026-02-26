package itq.eventapi.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Event {
    private UUID id;
    private String name;

}
