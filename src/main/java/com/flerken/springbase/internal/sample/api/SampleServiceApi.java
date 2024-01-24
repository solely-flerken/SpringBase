package com.flerken.springbase.internal.sample.api;

import com.flerken.springbase.api.dto.SampleDto;

import java.util.List;

public interface SampleServiceApi {
    List<SampleDto> findALlWithAmountGreaterThan(Float amount);
}
