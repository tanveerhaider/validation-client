package com.simplejava.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplejava.dto.CreditCardApplication;
import com.simplejava.startup.ApplicationInitializer;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description :
 * User: Tanveer Haider
 * Date: 7/13/2025
 * Time: 11:02 PM
 */
@Component
public class CustomJsonResourceLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationInitializer.class); // Logger for logging errors

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    public CustomJsonResourceLoader(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    void initialize() {
        LOG.info("CustomJsonResourceLoader initialized in postConstruct");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    public JsonNode loadJsonFromClasspath(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filePath);
        try (InputStream inputStream = resource.getInputStream()) {
            return objectMapper.readTree(inputStream);
        }
    }

    public CreditCardApplication convertJsonToApplication(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filePath);
        try (InputStream inputStream = resource.getInputStream()) {
            return objectMapper.readValue(inputStream, CreditCardApplication.class);
        }
    }
}
