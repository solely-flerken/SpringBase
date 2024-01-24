package com.flerken.springbase.internal.sample.internal;

import com.flerken.springbase.api.dto.SampleDto;
import com.flerken.springbase.internal.EntityDtoConverter;
import com.flerken.springbase.internal.enums.SampleUnit;
import com.flerken.springbase.internal.models.Sample;
import org.springframework.stereotype.Service;

@Service
public class SampleMapper implements EntityDtoConverter<Sample, SampleDto> {
    @Override
    public Sample toEntity(SampleDto dto) {
        return new Sample(
                dto.getName(),
                dto.getAmount(),
                SampleUnit.valueOf(dto.getUnit()));
    }

    @Override
    public SampleDto toDto(Sample entity) {
        return SampleDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .name(entity.getName())
                .amount(entity.getAmount())
                .unit(entity.getUnit().toString())
                .build();
    }
}
