package com.preslavrachev.soundfeed.service;

import com.preslavrachev.soundfeed.model.Track;
import com.preslavrachev.soundfeed.model.User;
import com.preslavrachev.soundfeed.model.presentation.Channel;
import com.preslavrachev.soundfeed.model.presentation.ChannelFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by preslavrachev on 13/12/15.
 */
@Service
public class SoundCloudChannelService implements ChannelService {

    @Inject
    private ChannelFactory channelFactory;

    @Inject
    private SoundCloudAPIService soundCloudAPIService;

    @Override
    public Channel fetchChannelByIdentifier(String identifier) {

        final User user = soundCloudAPIService.getUser(identifier);
        final Collection<Track> tracks = soundCloudAPIService.getTracksForUser(identifier);
        user.setTracks(tracks);

        return channelFactory.fromSoundCloudUser(user);
    }

}
