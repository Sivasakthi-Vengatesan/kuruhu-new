package com.kuruhu.repository;

import com.kuruhu.entity.PersonRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRelationshipRepository extends JpaRepository<PersonRelationship, Long>, JpaSpecificationExecutor<PersonRelationship> {
}
