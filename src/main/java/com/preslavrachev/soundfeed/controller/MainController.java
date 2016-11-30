package com.preslavrachev.soundfeed.controller;

import com.preslavrachev.soundfeed.model.twitter.Timeline;
import com.preslavrachev.soundfeed.service.TimelineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by preslavrachev on 05/12/15.
 */
@RestController
public class MainController {

    @Inject
    private TimelineService timelineService;

    @RequestMapping(path = "/timeline", method = RequestMethod.GET, produces = "application/json")
    public Timeline showTimeline() {
        return timelineService.getTimeline(10, 10);
    }

}
