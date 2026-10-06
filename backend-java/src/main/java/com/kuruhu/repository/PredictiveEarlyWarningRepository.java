package com.kuruhu.repository;

import com.kuruhu.entity.PredictiveEarlyWarning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictiveEarlyWarningRepository extends JpaRepository<PredictiveEarlyWarning, Long>, JpaSpecificationExecutor<PredictiveEarlyWarning> {
}
