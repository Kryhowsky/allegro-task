package com.kryhowsky.allegrotask.controller;

import lombok.RequiredArgsConstructor;
import org.kohsuke.github.GitHub;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/repositories")
public class RepositoryController {

    private final GitHub gitHub;

    @GetMapping
    public String test() {
        return gitHub.getApiUrl();
    }
}
