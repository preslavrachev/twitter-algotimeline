package com.preslavrachev.algotimeline.model.presentation;

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

    private String coverImageUrl;

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

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private Channel(Builder builder) {
        this.name = builder.getName();
        this.coverImageUrl = builder.getCoverImageUrl();
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", pubDate=" + pubDate +
                ", description='" + description + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", items=" + items +
                '}';
    }

    public static class Builder {

        private String name;

        private String coverImageUrl;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public String getCoverImageUrl() {
            return coverImageUrl;
        }

        public void setCoverImageUrl(String coverImageUrl) {
            this.coverImageUrl = coverImageUrl;
        }

        public Channel build() {
            return new Channel(this);
        }
    }

}
