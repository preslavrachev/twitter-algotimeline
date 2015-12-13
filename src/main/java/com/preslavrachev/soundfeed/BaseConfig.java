package com.preslavrachev.soundfeed;

import com.preslavrachev.soundfeed.service.ChannelService;
import com.preslavrachev.soundfeed.service.SoundCloudAPIService;
import com.preslavrachev.soundfeed.service.SoundCloudChannelService;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by preslavrachev on 06/12/15.
 */

@Configuration
@PropertySource("classpath:config/application.properties")
public class BaseConfig {

    @Bean
    public VelocityEngine velocityEngine() {
        return new VelocityEngine();
    }

    @Bean
    public ChannelService channelService() {
        return new SoundCloudChannelService();
    }

    @Bean
    public SoundCloudAPIService soundCloudAPIService(Environment environment) {
        final String clientId = environment.getRequiredProperty("sc.client_id");
        final String clientSecret = environment.getRequiredProperty("sc.client_secret");

        return new SoundCloudAPIService(clientId, clientSecret);
    }

}
