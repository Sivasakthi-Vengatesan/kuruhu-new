package com.pramaan.repository;

import com.pramaan.entity.CrimePatternCluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrimePatternClusterRepository extends JpaRepository<CrimePatternCluster, Long> {
    List<CrimePatternCluster> findByRiskLevelIgnoreCase(String riskLevel);
}