package com.arun.devtracker.controller;

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
    public List<GithubEvent> getUserEvents(@PathVariable Long userId) {
        return service.getEventsByUser(userId);
    }
}