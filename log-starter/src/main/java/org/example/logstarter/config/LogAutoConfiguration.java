package org.example.logstarter.config;

import org.example.logstarter.service.HttpLoggingAspectService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LogProperties.class)
@ConditionalOnProperty(prefix = "app.http.log", name = "enable", havingValue = "true", matchIfMissing = true)
public class LogAutoConfiguration {

    @Bean
    public HttpLoggingAspectService httpLoggingAspectService(LogProperties logProperties) {
        return new HttpLoggingAspectService(logProperties);
    }
}
