package com.preslavrachev.soundfeed.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.preslavrachev.soundfeed.model.twitter.ExtendedStatus;
import com.preslavrachev.soundfeed.model.twitter.Timeline;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by preslavrachev on 13/02/16.
 */

@Service
public class TimelineService {

    @Inject
    private Client elasticClient;

    @Inject
    private ObjectMapper objectMapper;

    public Timeline getTimeline(long start, long size) {

        final SearchRequestBuilder requestBuilder = elasticClient.prepareSearch("twitter");

        //@formatter:off
        final List<ExtendedStatus> statuses = Arrays.stream(requestBuilder
                    .addSort("score", SortOrder.DESC)
                    .get()
                    .getHits()
                    .getHits())
                .map(hit -> {
                    try {
                        return objectMapper.readValue(hit.getSourceAsString(), ExtendedStatus.class);}
                    catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
        //@formatter:on

        final Timeline timeline = new Timeline();
        timeline.setStatuses(statuses);
        timeline.setStart(start);
        timeline.setSize(size);

        return timeline;
    }

}
