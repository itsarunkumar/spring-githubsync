package com.arun.devtracker.controller;

import com.arun.devtracker.dto.GithubEventDTO;
import com.arun.devtracker.entity.GithubEvent;
import com.arun.devtracker.service.GithubEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class GithubEventController {

    private final GithubEventService service;

    public GithubEventController(GithubEventService service) {
        this.service = service;
    }

    @PostMapping
    public GithubEvent createEvent(@RequestBody GithubEvent event) {
        return service.saveEvent(event);
    }

    @GetMapping("/user/{userId}")
    public List<GithubEventDTO> getUserEvents(@PathVariable Long userId) {
        List<GithubEvent> events = service.getEventsByUser(userId);
        return service.convertToDtoList(events);
    }
}