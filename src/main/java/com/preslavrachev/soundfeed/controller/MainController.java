package com.preslavrachev.soundfeed.controller;

import com.preslavrachev.soundfeed.model.Track;
import com.preslavrachev.soundfeed.model.User;
import com.preslavrachev.soundfeed.model.presentation.Channel;
import com.preslavrachev.soundfeed.service.ChannelService;
import com.preslavrachev.soundfeed.service.SoundCloudAPIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by preslavrachev on 05/12/15.
 */

@Controller
public class MainController {

    @Inject
    ChannelService channelService;

    @RequestMapping(path = "/hello/{username}", method = RequestMethod.GET, produces = "application/*")
    public ModelAndView hello(@PathVariable final String username) {
        final HashMap<String, Object> viewData = new HashMap<>();

        final Channel channelData = channelService.fetchChannelByIdentifier(username);
        viewData.put("channelData", channelData);

        return new ModelAndView("rssFeedView", viewData);
    }

}
