package org.movie.data.map;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Short> {
    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        return (attribute == null) ? null : (short) attribute.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Short dbData) {
        return (dbData == null) ? null : Year.of(dbData);
    }
}
