package com.preslavrachev.algotimeline.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.preslavrachev.algotimeline.model.twitter.ExtendedStatus;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.json.DataObjectFactory;

import java.io.IOException;

/**
 * Created by preslavrachev on 29/11/16.
 */
public class ExtendedStatusDeserializer extends StdDeserializer<ExtendedStatus> {

    public ExtendedStatusDeserializer() {
        super(ExtendedStatus.class);
    }

    @Override
    public ExtendedStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode jsonNode = p.getCodec().readTree(p);
        final float score = jsonNode.get("score").floatValue();
        Status status = null;

        try {
            status = DataObjectFactory.createStatus(jsonNode.get("status").toString());
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }

        final ExtendedStatus extendedStatus = new ExtendedStatus();
        extendedStatus.setScore(score);
        extendedStatus.setStatus(status);
        return extendedStatus;
    }
}
