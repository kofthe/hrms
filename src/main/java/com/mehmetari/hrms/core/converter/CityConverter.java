package com.mehmetari.hrms.core.converter;

import com.mehmetari.hrms.entity.City;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Service;

@Service
@Converter(autoApply = true)
public class CityConverter implements AttributeConverter<City, String> {
    @Override
    public String convertToDatabaseColumn(City city) {
        return null;
    }

    @Override
    public City convertToEntityAttribute(String s) {
        return null;
    }
}
