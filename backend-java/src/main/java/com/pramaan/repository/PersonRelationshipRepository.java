package com.pramaan.repository;

import com.pramaan.entity.PersonRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRelationshipRepository extends JpaRepository<PersonRelationship, Long> {
    List<PersonRelationship> findByPersonId(Long personId);
    List<PersonRelationship> findByRelatedPersonId(Long relatedPersonId);
}