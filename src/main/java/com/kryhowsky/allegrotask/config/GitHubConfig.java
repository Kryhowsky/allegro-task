package com.kryhowsky.allegrotask.config;

import com.kryhowsky.allegrotask.exceptions.ConnectionException;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GitHubConfig {

    @Value("${github-properties.personal-token}")
    private String personalToken;

    @Bean
    public GitHub github() {
        try {
            return new GitHubBuilder().withOAuthToken(personalToken).build();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConnectionException();
        }
    }
}
