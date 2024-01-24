package com.flerken.springbase.internal.models.base;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date created;
    Date modified;

    @PrePersist
    public void persist() {
        created = new Date();
        modified = new Date();
    }

    @PreUpdate
    public void update() {
        modified = new Date();
    }
}
