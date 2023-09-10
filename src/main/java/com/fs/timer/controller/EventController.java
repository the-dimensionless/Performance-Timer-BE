package com.fs.timer.controller;

import com.fs.timer.dto.EventDTO;
import com.fs.timer.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@CrossOrigin("*")
public class EventController {

    EventService eventService;

    EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/save")
    public ResponseEntity saveEvent(@RequestBody EventDTO request) {
        this.eventService.saveEvent(request);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/allEvents")
    public ResponseEntity getAllEvents() {
        return ResponseEntity.ok(this.eventService.getEvent());
    }
}
