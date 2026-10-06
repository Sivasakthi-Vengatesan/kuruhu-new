package com.pramaan.repository;

import com.pramaan.entity.Evidence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    List<Evidence> findByFirId(Long firId);
    Optional<Evidence> findByEvidenceCode(String evidenceCode);
    List<Evidence> findByEvidenceTypeIgnoreCase(String evidenceType);
    List<Evidence> findByStatusIgnoreCase(String status);

    @Query("SELECT e FROM Evidence e WHERE " +
           "LOWER(e.label) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(e.evidenceType) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(e.collectedBy) LIKE LOWER(CONCAT('%', :query, '%'))")
    Page<Evidence> searchEvidence(@Param("query") String query, Pageable pageable);
}