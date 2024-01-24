package com.flerken.springbase.internal.sample.internal;

import com.flerken.springbase.internal.models.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
