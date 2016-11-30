package com.preslavrachev.soundfeed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by preslavrachev on 13/02/16.
 */
@Configuration
public class TwitterAPIConfig {
    @Value("${twitter.oauth_consumer_key}")
    public String OAUTH_CONSUMER_KEY = "";

    @Value("${twitter.oauth_consumer_secret}")
    public String OAUTH_CONSUMER_SECRET = "";

    @Value("${twitter.oauth_access_token}")
    public String OAUTH_ACCESS_TOKEN = "";

    @Value("${twitter.oauth_access_token_secret}")
    public String OAUTH_ACCESS_TOKEN_SECRET = "";

    @Bean
    Twitter twitter() {

        final ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(OAUTH_CONSUMER_KEY);
        configurationBuilder.setOAuthConsumerSecret(OAUTH_CONSUMER_SECRET);
        configurationBuilder.setOAuthAccessToken(OAUTH_ACCESS_TOKEN);
        configurationBuilder.setOAuthAccessTokenSecret(OAUTH_ACCESS_TOKEN_SECRET);

        final TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());

        return twitterFactory.getInstance();
    }
}
