package com.flerken.springbase.api.dto;

import com.flerken.springbase.internal.enums.Status;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ResponseDto<T> {
    Status status;
    String message;
    T payload;
}
