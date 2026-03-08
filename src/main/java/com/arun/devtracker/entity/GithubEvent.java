package com.arun.devtracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "github_events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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


}