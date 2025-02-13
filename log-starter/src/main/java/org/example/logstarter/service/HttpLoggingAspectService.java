package org.example.logstarter.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.logstarter.config.LogProperties;
import org.example.logstarter.utils.LevelType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class HttpLoggingAspectService {

    private final LogProperties logProperties;

    public HttpLoggingAspectService(LogProperties logProperties) {
        this.logProperties = logProperties;
    }

    private static final Logger log = LoggerFactory.getLogger(HttpLoggingAspectService.class);


    @Before("@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)")
    public void logBeforeRequest(JoinPoint joinPoint) {
        if (LevelType.INFO.name().equals(logProperties.getLevel())) {
            log.info("HTTP LOG INFO ---> REQUEST: {}", joinPoint.getSignature().getName());
        } else if (LevelType.DEBUG.name().equals(logProperties.getLevel())) {
            log.info("HTTP LOG DEBUG ---> REQUEST: {}", joinPoint.getSignature());

        } else {
            log.info("НЕКОРРЕКТНО УКАЗАН УРОВЕНЬ ЛОГИРОВАНИЯ");
        }

    }

    @AfterReturning(pointcut = "@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)", returning = "response")
    public void logAfterResponse(JoinPoint joinPoint, Object response) {
        if (LevelType.INFO.name().equals(logProperties.getLevel())) {
            log.info("HTTP LOG INFO ---> RESPONSE: {}", joinPoint.getSignature().getName());
        } else if (LevelType.DEBUG.name().equals(logProperties.getLevel())) {
            log.info("HTTP LOG DEBUG ---> RESPONSE: {} and BODY: {}", joinPoint.getSignature(), response);
        } else {
            log.info("НЕКОРРЕКТНО УКАЗАН УРОВЕНЬ ЛОГИРОВАНИЯ");
        }
    }
}
