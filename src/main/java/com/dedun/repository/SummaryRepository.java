package com.dedun.repository;

import com.dedun.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {
    Optional<Summary> findById(Long id);

    List<Summary> findAllByWorkerId(Long id);

    Optional<Summary> findByWorkerIdAndId(Long workerId, Long id);

    List<Summary> findByDateBetween(ZonedDateTime start, ZonedDateTime end);
}
