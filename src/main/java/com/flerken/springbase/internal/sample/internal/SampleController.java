package com.flerken.springbase.internal.sample.internal;

import com.flerken.springbase.api.controller.SampleControllerApi;
import com.flerken.springbase.api.dto.ResponseDto;
import com.flerken.springbase.api.dto.SampleDto;
import com.flerken.springbase.internal.BaseCRUDController;
import com.flerken.springbase.internal.EntityDtoConverter;
import com.flerken.springbase.internal.EntityDtoEditor;
import com.flerken.springbase.internal.enums.Status;
import com.flerken.springbase.internal.models.Sample;
import com.flerken.springbase.internal.sample.api.SampleServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * If the controller should have basic CRUD abilities then it needs to be extended by 'BaseController<Entity, Dto>'
 * You need to pass an existing entity and dto as types.
 * There have to be two '@Service' annotated classes which each implement either 'EntityDtoConverter<Entity, Dto>'
 * or 'EntityDtoEditor'.
 * There has to be a defined JPA Repository of type <Entity> annotated '@Repository'.
 * If the controller should extend the basic CRUD abilities or have any custom abilities you will have to define
 * an interface which defines the customs methods. A controller with only the basic CRUD abilities only needs
 * to implement the 'BaseController'.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/sample")
public class SampleController extends BaseCRUDController<Sample, SampleDto> implements SampleControllerApi {

    private final SampleServiceApi sampleService;

    protected SampleController(JpaRepository<Sample, Long> jpaRepository, EntityDtoConverter<Sample, SampleDto> mapper, EntityDtoEditor<Sample, SampleDto> editor, SampleServiceApi sampleService) {
        super(jpaRepository, mapper, editor, Sample.class);
        this.sampleService = sampleService;
    }

    @Override
    public ResponseEntity<ResponseDto<List<SampleDto>>> retrieveBySpecificConditions() {
        try {
            List<SampleDto> dtoList = sampleService.findALlWithAmountGreaterThan(1f);

            ResponseDto<List<SampleDto>> responseDto = ResponseDto.<List<SampleDto>>builder()
                    .status(Status.SUCCESS)
                    .message("")
                    .payload(dtoList)
                    .build();

            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
