package io.pivotal.workshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@RestController
public class GreetingController {

    @Value("${custom.message}")
    private String message;

    @Value("${secondMessage}")
    private String customMessage;

    @GetMapping("/")
    public String greeting() {

        return message + "<br>" + customMessage;
    }
}

