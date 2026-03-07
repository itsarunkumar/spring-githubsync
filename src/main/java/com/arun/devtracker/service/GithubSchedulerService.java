package com.arun.devtracker.service;

import com.arun.devtracker.entity.User;
import com.arun.devtracker.repository.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubSchedulerService {

    private final GithubApiService githubApiService;
    private final UserRepository userRepository;

    public GithubSchedulerService(GithubApiService githubApiService,
                                  UserRepository userRepository) {
        this.githubApiService = githubApiService;
        this.userRepository = userRepository;
    }

    @Scheduled(fixedRate = 3600000) // every 1 hour
//    @Scheduled(fixedRate = 10000)
    public void syncGithubEvents() {

        List<User> users = userRepository.findAll();

        for (User user : users) {
            try {
                githubApiService.fetchAndStoreEvents(user.getGithubUsername());
                System.out.println("Synced GitHub events for: " + user.getGithubUsername());
            } catch (Exception e) {
                System.out.println("GitHub fetch failed for user: " + user.getGithubUsername());
            }
        }
    }
}