package com.kubernetes.project.kubernetesProject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${APPLICATION_PROFILE}")
    private String applicationProfile;
    @Value("${LOGGING_LEVEL}")
    private String loggingLevel;
    @Value("${USERNAME}")
    private String userName;

    @GetMapping("/")
    public String hello() {
        return "Hello to kubernetes course!, "
                + "APPLICATION_PROFILE = applicationProfile, "
                        .replace("applicationProfile", applicationProfile)
                + "LOGGING_LEVEL = loggingLevel, "
                    .replace("loggingLevel", loggingLevel)
                + "USERNAME = userName"
                    .replace("userName", userName);
    }

}
