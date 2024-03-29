package com.flerken.springbase.internal;

import com.flerken.springbase.api.dto.ResponseDto;
import com.flerken.springbase.api.dto.base.BaseDto;
import com.flerken.springbase.internal.enums.Status;
import com.flerken.springbase.internal.models.base.BaseEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * A base controller which provides the implementing controller with basic CURD abilities.
 * You could extend the abilities of this controller if you want any functionality which
 * should be available to every controller.
 *
 * @param <D> as existing Dto type
 * @param <E> as existing Entity type
 */
@Slf4j
public abstract class BaseCRUDController<E extends BaseEntity, D extends BaseDto> {

    private final JpaRepository<E, Long> jpaRepository;
    private final EntityDtoConverter<E, D> mapper;
    private final EntityDtoEditor<E, D> editor;
    private final Class<E> entityClass;

    protected BaseCRUDController(JpaRepository<E, Long> jpaRepository, EntityDtoConverter<E, D> mapper, EntityDtoEditor<E, D> editor, Class<E> entityClass) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
        this.editor = editor;
        this.entityClass = entityClass;
    }

    public ResponseEntity<ResponseDto<D>> retrieve(Long id) {
        try {
            E entity = jpaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No " + entityClass.getSimpleName() + " entry with identifier: " + id));

            D dto = mapper.toDto(entity);

            ResponseDto<D> responseDto = ResponseDto.<D>builder()
                    .status(Status.SUCCESS)
                    .message("")
                    .payload(dto)
                    .build();

            return ResponseEntity.ok(responseDto);
        } catch (EntityNotFoundException e) {
            ResponseDto<D> responseDto = ResponseDto.<D>builder()
                    .status(Status.ERROR)
                    .message(e.getMessage())
                    .build();

            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<ResponseDto<List<D>>> retrieveAll() {
        try {
            List<D> dtoList = jpaRepository.findAll()
                    .stream()
                    .map(mapper::toDto)
                    .toList();

            ResponseDto<List<D>> responseDto = ResponseDto.<List<D>>builder()
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

    public ResponseEntity<ResponseDto<D>> create(D dto) {
        try {
            E entity = mapper.toEntity(dto);

            E savedEntity = jpaRepository.save(entity);

            D savedDto = mapper.toDto(savedEntity);

            ResponseDto<D> responseDto = ResponseDto.<D>builder()
                    .status(Status.SUCCESS)
                    .message("")
                    .payload(savedDto)
                    .build();

            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<ResponseDto<D>> edit(Long id, D dto) {
        try {
            E entity = jpaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No " + entityClass.getSimpleName() + " entry with identifier: " + id));

            editor.edit(entity, dto);

            E savedEntity = jpaRepository.save(entity);

            D savedDto = mapper.toDto(savedEntity);

            ResponseDto<D> responseDto = ResponseDto.<D>builder()
                    .status(Status.SUCCESS)
                    .message("")
                    .payload(savedDto)
                    .build();

            return ResponseEntity.ok(responseDto);
        } catch (EntityNotFoundException e) {
            ResponseDto<D> responseDto = ResponseDto.<D>builder()
                    .status(Status.ERROR)
                    .message(e.getMessage())
                    .build();

            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<ResponseDto<D>> delete(Long id) {
        try {
            jpaRepository.deleteById(id);

            ResponseDto<D> responseDto = ResponseDto.<D>builder()
                    .status(Status.SUCCESS)
                    .message("")
                    .payload(null)
                    .build();

            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
