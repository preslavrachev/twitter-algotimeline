package com.preslavrachev.algotimeline.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by preslavrachev on 05/12/15.
 */
public class User {

    @JsonProperty("full_name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String fullName;

    @JsonProperty("username")
    private String username;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("permalink_url")
    private String permalinkUrl;

    @JsonProperty("description")
    private String description;

    private Collection<Track> tracks;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPermalinkUrl() {
        return permalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        this.permalinkUrl = permalinkUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Collection<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", permalinkUrl='" + permalinkUrl + '\'' +
                ", description='" + description + '\'' +
                ", tracks=" + tracks +
                '}';
    }

}
