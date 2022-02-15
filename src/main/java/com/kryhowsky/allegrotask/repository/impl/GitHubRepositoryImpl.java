package com.kryhowsky.allegrotask.repository.impl;

import com.kryhowsky.allegrotask.repository.GitHubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class GitHubRepositoryImpl implements GitHubRepository {

    private final GitHub gitHub;

    @Override
    public List<GHRepository> getRepositoriesByUser(String username) {

        try {
            return new ArrayList<>(gitHub.getUser(username).getRepositories().values());
        } catch (IOException e) {
            log.warn("Exception in connection to api.");
        }

        return new ArrayList<>();

    }

}
