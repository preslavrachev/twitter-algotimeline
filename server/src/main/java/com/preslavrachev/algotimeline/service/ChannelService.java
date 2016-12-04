package com.preslavrachev.algotimeline.service;

import com.preslavrachev.algotimeline.model.presentation.Channel;

/**
 * Created by preslavrachev on 13/12/15.
 */
public interface ChannelService {
    Channel fetchChannelByIdentifier(String identifier);
}
