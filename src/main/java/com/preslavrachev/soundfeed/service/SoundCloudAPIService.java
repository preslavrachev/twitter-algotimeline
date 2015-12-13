package com.preslavrachev.soundfeed.service;

import com.preslavrachev.soundfeed.model.Track;
import com.preslavrachev.soundfeed.model.User;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by preslavrachev on 05/12/15.
 */

@Service
public class SoundCloudAPIService {

    private static final String USER_URL = "http://api.soundcloud.com/users/[USERNAME]?client_id=[CLIENT_ID]";
    private static final String TRACKS_URL = "http://api.soundcloud.com/users/[USERNAME]/tracks.json?client_id=[CLIENT_ID]";

    private String clientId;
    private String clientSecret;

    private RestTemplate restTemplate;

    public SoundCloudAPIService(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;

        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public User getUser(String username) {

        final String url = USER_URL.replace("[USERNAME]", username).replace("[CLIENT_ID]", clientId);

        return restTemplate.getForObject(url, User.class);
    }

    public Collection<Track> getTracksForUser(String username) {
        final String url = TRACKS_URL.replace("[USERNAME]", username).replace("[CLIENT_ID]", clientId);

        return Arrays.asList(restTemplate.getForObject(url, Track[].class));
    }

}
