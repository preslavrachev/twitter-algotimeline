package com.preslavrachev.algotimeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by preslavrachev on 05/12/15.
 */
public class Track {

    @JsonProperty("id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                '}';
    }
}
