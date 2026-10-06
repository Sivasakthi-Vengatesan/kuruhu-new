package com.kuruhu.repository;

import com.kuruhu.entity.InvestigationNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigationNoteRepository extends JpaRepository<InvestigationNote, Long>, JpaSpecificationExecutor<InvestigationNote> {
}
