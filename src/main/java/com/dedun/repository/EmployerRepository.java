package com.dedun.repository;

import com.dedun.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    Optional<Employer> findById(Long id);
    Employer getByLogin(String login);
}
