package com.arun.devtracker.service;

import com.arun.devtracker.entity.GithubEvent;
import com.arun.devtracker.entity.User;
import com.arun.devtracker.repository.GithubEventRepository;
import com.arun.devtracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class GithubApiService {

    private final WebClient webClient;
    private final GithubEventRepository eventRepository;
    private final UserRepository userRepository;

    public GithubApiService(WebClient webClient,
                            GithubEventRepository eventRepository,
                            UserRepository userRepository) {
        this.webClient = webClient;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public void fetchAndStoreEvents(String username) {

        List<Map> events = webClient
                .get()
                .uri("https://api.github.com/users/" + username + "/events")
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();

        User user = userRepository.findByGithubUsername(username)
                .orElseThrow();

        for (Map event : events) {

            Map repo = (Map) event.get("repo");

            GithubEvent githubEvent = new GithubEvent();
            githubEvent.setEventType((String) event.get("type"));
            githubEvent.setRepoName((String) repo.get("name"));
            githubEvent.setCreatedAt(LocalDateTime.now());
            githubEvent.setUser(user);

            eventRepository.save(githubEvent);
        }
    }
}