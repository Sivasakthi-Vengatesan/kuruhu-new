package com.kuruhu.repository;

import com.kuruhu.entity.CrimePatternCluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimePatternClusterRepository extends JpaRepository<CrimePatternCluster, Long>, JpaSpecificationExecutor<CrimePatternCluster> {
}
