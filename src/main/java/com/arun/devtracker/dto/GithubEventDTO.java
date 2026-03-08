package com.arun.devtracker.dto;

import java.time.LocalDateTime;

public class GithubEventDTO {
    private Long id;
    private String eventType;
    private String repoName;
    private LocalDateTime createdAt;

    public GithubEventDTO(Long id,String eventType, String repoName,LocalDateTime createdAt) {

        this.id = id;
        this.eventType=eventType;
        this.repoName=repoName;
        this.createdAt = createdAt;

    }

    public Long getId() { return id; }
    public String getEventType() { return eventType; }
    public String getRepoName() { return repoName; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
