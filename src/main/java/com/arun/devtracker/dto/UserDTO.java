package com.arun.devtracker.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String email;
    private String githubUsername;
    private List<GithubEventDTO> events;

    public UserDTO(Long id, String email, String githubUsername, List<GithubEventDTO> events) {
        this.id = id;
        this.email = email;
        this.githubUsername = githubUsername;
        this.events = events;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public  String getGithubUsername() { return githubUsername; }
    public List<GithubEventDTO> getEvents() { return events; }
}
