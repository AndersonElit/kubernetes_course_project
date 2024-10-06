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
    @Value("${MYSQL_USER}")
    private String mysqlUser;
    @Value("${MYSQL_PASSWORD}")
    private String mysqlPassword;

    @GetMapping("/")
    public String hello() {
        return "Hello to kubernetes course!, "
                + "APPLICATION_PROFILE = applicationProfile, "
                        .replace("applicationProfile", applicationProfile)
                + "LOGGING_LEVEL = loggingLevel, "
                    .replace("loggingLevel", loggingLevel)
                + "USERNAME = userName, "
                    .replace("userName", userName)
                + "MYSQL_USER = mysqlUser, "
                    .replace("mysqlUser", mysqlUser)
                + "MYSQL_PASSWORD = mysqlPassword"
                    .replace("mysqlPassword", mysqlPassword);
    }

}
