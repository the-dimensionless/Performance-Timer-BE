package com.fs.timer.component;

import com.fs.timer.dto.EventDTO;
import com.fs.timer.dto.EventType;
import com.fs.timer.service.EventService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Component
public class MockDataRunner implements CommandLineRunner {

    private EventService eventService;

    MockDataRunner(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void run(String... args) throws Exception {
        IntStream.rangeClosed(1, 9).forEach(i -> {
            eventService.saveEvent(new EventDTO(
                    EventType.Running, i%5 + 1, "Km", Double.valueOf(Math.random()*i).longValue(), LocalDateTime.now()
            ));
        });

        IntStream.rangeClosed(1, 9).forEach(i -> {
            eventService.saveEvent(new EventDTO(
                    EventType.Cycling, i%5 + 1, "Km", Double.valueOf(Math.random()*i).longValue(), LocalDateTime.now()
            ));
        });

        IntStream.rangeClosed(1, 5).forEach(i -> {
            eventService.saveEvent(new EventDTO(
                    EventType.Swimming, (i*100) , "m", Double.valueOf(Math.random()*i).longValue(), LocalDateTime.now()
            ));
        });

    }
}
