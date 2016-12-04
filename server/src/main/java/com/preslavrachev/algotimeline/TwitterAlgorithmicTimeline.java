package com.preslavrachev.algotimeline;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.preslavrachev.algotimeline.model.twitter.ExtendedStatus;
import org.apache.log4j.Logger;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.inject.Inject;
import java.util.Random;

/**
 * Created by preslavrachev on 05/12/15.
 */

@EnableAutoConfiguration
@EnableScheduling
@ComponentScan
public class TwitterAlgorithmicTimeline {

    private static int MAX_PAGES = 30;
    private static int STATUS_COUNT = 20;

    private static Logger LOGGER = Logger.getLogger(TwitterAlgorithmicTimeline.class);

    private Random randomGenerator = new Random();

    @Inject
    private Twitter twitter;

    @Inject
    private Client elasticClient;

    @Inject
    private ObjectMapper objectMapper;

    @Scheduled(fixedDelay = 15000)
    private void testScheduling() throws InterruptedException {

        int page = randomGenerator.nextInt(MAX_PAGES);
        Paging paging = new Paging(page, STATUS_COUNT);

        try {
            fetchAndStoreTimeline(paging);
        } catch (TwitterException e) {
            if (e.getRateLimitStatus().getRemaining() == 0) {
                System.out.println("Rate limi exhausted! Sleeping for: " + e.getRateLimitStatus().getSecondsUntilReset());
                Thread.currentThread().sleep(e.getRateLimitStatus().getSecondsUntilReset() * 1000);
            }
        }
    }

    private void fetchAndStoreTimeline(Paging paging) throws TwitterException {
        System.out.println(String.format("Fetching page %s", paging.getPage()));

        IndexRequestBuilder indexRequestBuilder = elasticClient.prepareIndex("twitter", "status");

        twitter.getHomeTimeline(paging).stream()
                .map(ExtendedStatus::new)
                .peek(LOGGER::info)
                .forEach(s -> {
                    final String json;
                    try {
                        json = objectMapper.writeValueAsString(s);
                        indexRequestBuilder.setSource(json).setId(String.valueOf(s.getStatus().getId())).execute().actionGet();
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public static void main(String[] args) {
        final ApplicationContext applicationContext = SpringApplication.run(TwitterAlgorithmicTimeline.class, args);
    }
}
