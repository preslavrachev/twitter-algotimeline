package com.preslavrachev.algotimeline.model.twitter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.preslavrachev.algotimeline.json.ExtendedStatusDeserializer;
import twitter4j.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by preslavrachev on 13/02/16.
 */
@JsonDeserialize(using = ExtendedStatusDeserializer.class)
public class ExtendedStatus {

    private static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();

    private Status status;
    private float score;

    public ExtendedStatus() {
        //default constructor
    }

    public ExtendedStatus(Status status) {
        this.status = status;

        determineScore();
    }

    //TODO: Move this method to a separate bean
    private void determineScore() {
        final Date now = Date.from(LocalDateTime.now().atZone(DEFAULT_ZONE).toInstant());
        final Date yesterday = Date.from(LocalDate.now().minusDays(1L).atStartOfDay(DEFAULT_ZONE).toInstant());

        final float deltaTimeSinceYesterday = now.getTime() - yesterday.getTime();
        final float deltaTimeSinceStatusCreation = now.getTime() - status.getCreatedAt().getTime();

        final float recencyScore = 1f / ((deltaTimeSinceStatusCreation / deltaTimeSinceYesterday) + 1f);

        final float userScore = Math.min(status.getUser().getFollowersCount() / status.getUser().getFriendsCount(), 1f);

        score = recencyScore * Math.min(((float) status.getRetweetCount() + (float) status.getFavoriteCount() / 2), 10f);
        score = status.isRetweet() ? score / 2 : score;
        score = score * userScore;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExtendedStatus{");
        sb.append("status=").append(status);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
