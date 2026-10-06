package com.pramaan.repository;

import com.pramaan.entity.PredictiveEarlyWarning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictiveEarlyWarningRepository extends JpaRepository<PredictiveEarlyWarning, Long> {
    List<PredictiveEarlyWarning> findAllByOrderByCreatedAtDesc();
}