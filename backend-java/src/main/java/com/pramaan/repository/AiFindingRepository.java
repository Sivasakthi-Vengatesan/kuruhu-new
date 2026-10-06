package com.pramaan.repository;

import com.pramaan.entity.AiFinding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AiFindingRepository extends JpaRepository<AiFinding, Long> {
    Optional<AiFinding> findByFindingCode(String findingCode);
    List<AiFinding> findByStatusIgnoreCase(String status);
    List<AiFinding> findAllByOrderByGeneratedAtDesc();
    long countByStatus(String status);
}