package com.flerken.springbase.internal.sample.internal;

import com.flerken.springbase.api.dto.SampleDto;
import com.flerken.springbase.internal.EntityDtoEditor;
import com.flerken.springbase.internal.enums.SampleUnit;
import com.flerken.springbase.internal.exceptions.InvalidUnitException;
import com.flerken.springbase.internal.models.Sample;
import org.springframework.stereotype.Service;

@Service
public class SampleEditor implements EntityDtoEditor<Sample, SampleDto> {
    @Override
    public void edit(Sample entity, SampleDto dto) {
        if (dto.getName() != null && !dto.getName().isEmpty()) {
            entity.setName(dto.getName());
        }

        if (dto.getAmount() != null) {
            entity.setAmount(dto.getAmount());
        }

        if (dto.getUnit() != null && !dto.getUnit().isEmpty()) {
            try {
                entity.setUnit(SampleUnit.valueOf(dto.getUnit()));
            } catch (Exception e) {
                throw new InvalidUnitException();
            }
        }
    }
}
