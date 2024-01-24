package com.flerken.springbase.api.controller;

import com.flerken.springbase.api.dto.ResponseDto;
import com.flerken.springbase.api.dto.SampleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface SampleControllerApi {
    @GetMapping("/special")
    ResponseEntity<ResponseDto<List<SampleDto>>> retrieveBySpecificConditions();
}
