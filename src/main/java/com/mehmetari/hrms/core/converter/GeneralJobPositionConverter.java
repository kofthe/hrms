package com.mehmetari.hrms.core.converter;

import com.mehmetari.hrms.entity.GeneralJobPosition;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Service;

@Converter(autoApply = true)
@Service
public class GeneralJobPositionConverter implements AttributeConverter<GeneralJobPosition, String> {

    @Override
    public String convertToDatabaseColumn(GeneralJobPosition generalJobPosition) {
        return null;
    }

    @Override
    public GeneralJobPosition convertToEntityAttribute(String s) {
        for (GeneralJobPosition generalJobPosition : GeneralJobPosition.values()) {
            if (generalJobPosition.getPositions().equals(s)){
                return generalJobPosition;
            }
        }


        throw new IllegalArgumentException("Geçersiz Database Girdisi");
    }
}
