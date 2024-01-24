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
public interface EntityDtoEditor<E extends BaseEntity, D extends BaseDto> {
    /**
     * Should be implemented when an entity is updated with a given dto.
     * Define what properties from the entity are editable and decide
     * whether entity properties should be replaced by null or empty
     * values from the dto.
     *
     * @param entity as entity
     * @param dto    as dto
     */
    void edit(E entity, D dto);
}
