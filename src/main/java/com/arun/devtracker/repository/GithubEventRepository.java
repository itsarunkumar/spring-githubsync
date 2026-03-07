package com.arun.devtracker.repository;

import com.arun.devtracker.entity.GithubEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GithubEventRepository extends JpaRepository<GithubEvent,Long> {
    List<GithubEvent> findByUserId(Long userId);
    boolean existsByGithubEventId(String githubEventId);
}
