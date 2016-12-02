package com.preslavrachev.algotimeline.model.presentation;

import com.preslavrachev.algotimeline.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by preslavrachev on 13/12/15.
 */
@Component
public class ChannelFactory {

    public Channel fromSoundCloudUser(User user) {

        final Channel.Builder channelBuilder = new Channel.Builder();
        channelBuilder.setName(StringUtils.isEmpty(user.getFullName()) ? user.getUsername() : user.getFullName());
        channelBuilder.setCoverImageUrl(user.getAvatarUrl());

        return channelBuilder.build();
    }

}
