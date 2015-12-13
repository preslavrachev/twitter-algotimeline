package com.preslavrachev.soundfeed.view;

import com.preslavrachev.soundfeed.model.presentation.Channel;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by preslavrachev on 05/12/15.
 */

@Component("rssFeedView")
public class RssFeedView implements View {


    @Inject
    VelocityEngine velocityEngine;

    @Override
    public String getContentType() {
        return "application/xml";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        final Channel channelData = (Channel) model.get("channelData");

        //TODO: init the velocity engine once at startup
        velocityEngine.init();

        final VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("channelData", channelData);

        //TODO: extract the template name into a property
        Template template = velocityEngine.getTemplate("src/main/resources/templates/rssTemplate.vm");

        template.merge(velocityContext, response.getWriter());
    }
}
