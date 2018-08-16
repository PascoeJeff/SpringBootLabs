package io.pivotal.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private final CounterService defaultCounterService;

    public GreetingController(CounterService defaultCounterService) {
        this.defaultCounterService = defaultCounterService;
    }

    @GetMapping("/")
    public String hello() {
        defaultCounterService.increment("counter.services.greeting.invoked");
        return "Hello World!!!";
    }
}
