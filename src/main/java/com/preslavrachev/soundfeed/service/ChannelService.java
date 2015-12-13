package com.preslavrachev.soundfeed.service;

import com.preslavrachev.soundfeed.model.presentation.Channel;

/**
 * Created by preslavrachev on 13/12/15.
 */
public interface ChannelService {
    Channel fetchChannelByIdentifier(String identifier);
}
