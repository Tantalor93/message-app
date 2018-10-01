package com.github.tantalor93.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("message")
public class Message {
    private final Producer producer;
    private final String message;

    @JsonCreator
    public Message(@JsonProperty("producer") final Producer producer,
                   @JsonProperty("message") final String message) {
        this.producer = producer;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Producer getProducer() {
        return producer;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Message message1 = (Message) o;
        return Objects.equals(producer, message1.producer) &&
                Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, message);
    }
}
