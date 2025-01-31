package org.movie.data.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating != null ? rating.getValue() : null;
    }

    @Override
    public Rating convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        for (Rating rating : Rating.values()) {
            if (rating.getValue().equals(value)) {
                return rating;
            }
        }
        throw new IllegalArgumentException("Unknown Rating value: " + value);
    }
}
