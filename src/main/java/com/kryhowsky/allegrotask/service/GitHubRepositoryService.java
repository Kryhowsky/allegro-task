package com.kryhowsky.allegrotask.service;

import com.kryhowsky.allegrotask.model.dto.RepositoryDto;

import java.util.List;
import java.util.Map;

public interface GitHubRepositoryService {
    List<RepositoryDto> getRepositoriesByUser(String username);
    Integer getSumOfStarsByUser(String username);
    Map<String, Long> getMostPopularProgrammingLanguagesByUser(String username);
}
