package com.preslavrachev.soundfeed.model.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by preslavrachev on 13/12/15.
 */
public class Channel {

    private String name;

    private Date pubDate;

    private String description;

    private List<Item> items = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private Channel(Builder builder) {
        this.name = builder.getName();
    }

    public static class Builder {

        private String name;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Channel build() {
            return new Channel(this);
        }
    }

}
