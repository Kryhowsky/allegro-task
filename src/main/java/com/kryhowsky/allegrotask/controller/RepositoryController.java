package com.kryhowsky.allegrotask.controller;

import com.kryhowsky.allegrotask.model.dto.RepositoryDto;
import com.kryhowsky.allegrotask.service.GitHubRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/repositories")
public class RepositoryController {

    private final GitHubRepositoryService gitHubRepositoryService;

    // /api/repositories/user/repositories
    // /api/repositories/user/stars
    // /api/repositories/user/languages
    @GetMapping("/{username}/repositories")
    public List<RepositoryDto> getAllRepositoriesByUser(@PathVariable String username) {
        return gitHubRepositoryService.getRepositoriesByUser(username);
    }

    @GetMapping("/{username}/stars")
    public Integer getSumOfStarsByUser(@PathVariable String username) {
        return gitHubRepositoryService.getSumOfStarsByUser(username);
    }

    @GetMapping("/{username}/languages")
    public Map<String, Long> getMostPopularProgrammingLanguagesByUser(@PathVariable String username) {
        return gitHubRepositoryService.getMostPopularProgrammingLanguagesByUser(username);
    }

}
