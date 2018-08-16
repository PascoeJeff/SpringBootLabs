package io.pivotal.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CodeSnippetManagerJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeSnippetManagerJdbcApplication.class, args);
    }
}
