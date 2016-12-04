package com.preslavrachev.algotimeline;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.preslavrachev.algotimeline.config.TwitterAPIConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by preslavrachev on 06/12/15.
 */

@Configuration
@Import({TwitterAPIConfig.class})
@PropertySource("classpath:config/application.properties")
public class BaseConfig {

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
