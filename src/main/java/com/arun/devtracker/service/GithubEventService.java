package com.arun.devtracker.service;


import com.arun.devtracker.entity.GithubEvent;
import com.arun.devtracker.repository.GithubEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubEventService {
    private final GithubEventRepository repository;

    public  GithubEventService(GithubEventRepository repository) {
        this.repository = repository;
    }

    public GithubEvent saveEvent(GithubEvent event){
        return  repository.save(event);
    }

    public List<GithubEvent> getEventsByUser(Long userId) {
        return  repository.findByUserId(userId);
    }
}
