package com.flerken.springbase.internal.sample.internal;

import com.flerken.springbase.api.dto.SampleDto;
import com.flerken.springbase.internal.models.Sample;
import com.flerken.springbase.internal.sample.api.SampleServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SampleService implements SampleServiceApi {

    private final SampleRepository sampleRepository;
    private final SampleMapper sampleMapper;

    @Override
    public List<SampleDto> findALlWithAmountGreaterThan(Float amount) {
        List<Sample> sampleList = sampleRepository.findAll();

        return sampleList.stream()
                .filter(sample -> sample.getAmount() > amount)
                .map(sampleMapper::toDto)
                .collect(Collectors.toList());
    }
}
