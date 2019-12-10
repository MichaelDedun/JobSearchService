package com.dedun.repository;

import com.dedun.model.Skills;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    List<Skills> getAllBySummaryId(Long id);
}
