package com.arun.devtracker.service;

import com.arun.devtracker.dto.GithubEventDTO;
import com.arun.devtracker.dto.UserDTO;
import com.arun.devtracker.entity.User;
import com.arun.devtracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserDTO convertToDTO(User user) {

        List<GithubEventDTO> events = user.getEvents()
                .stream()
                .map(event -> new GithubEventDTO(
                        event.getId(),
                        event.getEventType(),
                        event.getRepoName(),
                        event.getCreatedAt()
                ))
                .toList();

        return new UserDTO(
                user.getId(),
                user.getEmail(),
                user.getGithubUsername(),
                events
        );
    }
}