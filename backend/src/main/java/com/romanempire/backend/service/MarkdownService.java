package com.romanempire.backend.service;

import com.romanempire.backend.exception.ResourceNotFoundException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class MarkdownService {

    public String readMarkdownFile(String path) {
        if (path == null || path.isBlank()) {
            throw new ResourceNotFoundException("Markdown content file not found.");
        }

        try {
            ClassPathResource resource = new ClassPathResource(path);
            return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            throw new ResourceNotFoundException("Markdown content file not found: " + path);
        }
    }
}
