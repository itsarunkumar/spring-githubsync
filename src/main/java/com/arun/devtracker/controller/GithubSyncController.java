package com.arun.devtracker.controller;

import com.arun.devtracker.service.GithubApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/github")
public class GithubSyncController {

    private final GithubApiService githubApiService;

    public GithubSyncController(GithubApiService githubApiService) {
        this.githubApiService = githubApiService;
    }

    @PostMapping("/sync/{username}")
    public String syncGithub(@PathVariable String username) {

        githubApiService.fetchAndStoreEvents(username);

        return "Events synced successfully";
    }
}