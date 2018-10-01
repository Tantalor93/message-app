package com.github.tantalor93.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Producer {
    private final String type;
    private final String identifier;

    @JsonCreator
    public Producer(@JsonProperty("type") final String type,
                    @JsonProperty("identifier") final String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Producer producer = (Producer) o;
        return Objects.equals(type, producer.type) &&
                Objects.equals(identifier, producer.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, identifier);
    }
}
