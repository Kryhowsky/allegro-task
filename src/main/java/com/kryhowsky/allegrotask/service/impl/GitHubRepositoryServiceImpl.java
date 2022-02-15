package com.kryhowsky.allegrotask.service.impl;

import com.kryhowsky.allegrotask.model.dto.RepositoryDto;
import com.kryhowsky.allegrotask.repository.GitHubRepository;
import com.kryhowsky.allegrotask.service.GitHubRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GitHubRepositoryServiceImpl implements GitHubRepositoryService {

    private final GitHubRepository gitHubRepository;

    @Override
    public List<RepositoryDto> getRepositoriesByUser(String username) { // TODO: zwrócić błąd połączenia?
        return gitHubRepository.getRepositoriesByUser(username).stream()
                .map(ghRepository -> new RepositoryDto(ghRepository.getName(), ghRepository.getStargazersCount()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getSumOfStarsByUser(String username) {
        return gitHubRepository.getRepositoriesByUser(username).stream()
                .mapToInt(GHRepository::getStargazersCount)
                .sum();
    }

    @Override
    public Map<String, Long> getMostPopularProgrammingLanguagesByUser(String username) { // TODO: refactor

        Map<String, Long> result = new HashMap<>();

        gitHubRepository.getRepositoriesByUser(username)
                .parallelStream()
                .forEach(ghRepository -> {
                    try {
                        ghRepository.listLanguages().forEach((language, codeBytes) -> {
                            result.putIfAbsent(language, 0L);

                            result.put(language, result.get(language) + codeBytes);
                        });
                    } catch (IOException e) {
                        log.warn("Error");
                    }
                });
        return result;
    }

}
