package com.dedun.repository;

import com.dedun.model.Requirements;
import com.dedun.model.Summary;
import com.dedun.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    Optional<Vacancy> findById(Long id);

    List<Vacancy> findAllByEmployerId(Long id);

    Optional<Vacancy> findByEmployerIdAndId(Long workerId, Long id);

    List<Vacancy> findByDateBetween(ZonedDateTime start, ZonedDateTime end);

    List<Vacancy> findByRequirements(List<Requirements> requirements);
}
