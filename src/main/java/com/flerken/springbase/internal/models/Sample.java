package com.flerken.springbase.internal.models;

import com.flerken.springbase.internal.enums.SampleUnit;
import com.flerken.springbase.internal.models.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "SAMPLE")
@AttributeOverride(name = "id", column = @Column(name = "sample_id"))
public class Sample extends BaseEntity {
    String name;
    Float amount;
    @Enumerated(EnumType.STRING)
    SampleUnit unit;
}
