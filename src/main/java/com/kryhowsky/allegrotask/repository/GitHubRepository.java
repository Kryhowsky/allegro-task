package com.kryhowsky.allegrotask.repository;

import org.kohsuke.github.GHRepository;

import java.util.List;

public interface GitHubRepository {
    List<GHRepository> getRepositoriesByUser(String username);
}
