package com.arun.devtracker.service;


import com.arun.devtracker.dto.GithubEventDTO;
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

    public GithubEventDTO convertToDto(GithubEvent event) {
        return new GithubEventDTO(
                event.getId(),
                event.getEventType(),
                event.getRepoName(),
                event.getCreatedAt()
        );
    }

    public List<GithubEventDTO> convertToDtoList(List<GithubEvent> events) {
        return events.stream()
                .map(this::convertToDto)
                .toList();
    }
}
