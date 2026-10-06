package com.pramaan.repository;

import com.pramaan.entity.CaseParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CasePartyRepository extends JpaRepository<CaseParty, Long> {
    List<CaseParty> findByFirId(Long firId);
    List<CaseParty> findByPersonId(Long personId);
    Optional<CaseParty> findByFirIdAndPersonIdAndRole(Long firId, Long personId, String role);
}