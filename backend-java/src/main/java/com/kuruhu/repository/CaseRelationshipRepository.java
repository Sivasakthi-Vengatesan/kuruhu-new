package com.kuruhu.repository;

import com.kuruhu.entity.CaseRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRelationshipRepository extends JpaRepository<CaseRelationship, Long>, JpaSpecificationExecutor<CaseRelationship> {
}
