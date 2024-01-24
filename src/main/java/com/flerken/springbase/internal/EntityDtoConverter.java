package com.flerken.springbase.internal;

import com.flerken.springbase.api.dto.base.BaseDto;
import com.flerken.springbase.internal.models.base.BaseEntity;

/**
 * Should be implemented as a class which only implements the here defined methods.
 * Annotate the implementing class with @Service
 *
 * @param <E>
 * @param <D>
 */
public interface EntityDtoConverter<E extends BaseEntity, D extends BaseDto> {
    /**
     * Maps a dto to an entity. Decide which properties should be set from the input dto
     * or which should be set automatically e.g. an identifier or the user from the current
     * authentication context.
     *
     * @param dto as dto
     * @return entity
     */
    E toEntity(D dto);

    /**
     * Maps an entity to a dto. Generally all fields from the input dto should be set.
     *
     * @param entity as entity
     * @return dto
     */
    D toDto(E entity);
}