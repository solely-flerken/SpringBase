package com.flerken.springbase.api.dto;

import com.flerken.springbase.api.dto.base.BaseDto;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SampleDto extends BaseDto {
    String name;
    Float amount;
    String unit;
}
