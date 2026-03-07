package com.arun.devtracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "github_events")
@Getter
@Setter
@AllArgsConstructor
public class GithubEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;

    @Column(unique = true)
    private String githubEventId;

    private String repoName;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public GithubEvent() {}

    public GithubEvent(String eventType, String repoName, LocalDateTime createdAt, User user , String githubEventId) {
        this.eventType = eventType;
        this.repoName = repoName;
        this.createdAt = createdAt;
        this.user = user;
        this.githubEventId = githubEventId;
    }

    public Long getId() {
        return id;
    }

    public String setGithubEventId(String githubEventId){
       return this.githubEventId = githubEventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}