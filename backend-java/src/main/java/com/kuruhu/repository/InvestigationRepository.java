package com.kuruhu.repository;

import com.kuruhu.entity.Investigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigationRepository extends JpaRepository<Investigation, Long>, JpaSpecificationExecutor<Investigation> {
}
