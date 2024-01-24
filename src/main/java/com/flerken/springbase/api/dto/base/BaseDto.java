package com.flerken.springbase.api.dto.base;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Value
@NonFinal
@Jacksonized
@SuperBuilder
public class BaseDto {
    Long id;
    Date created;
    Date modified;
}
