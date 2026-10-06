package com.kuruhu.repository;

import com.kuruhu.entity.CaseParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CasePartyRepository extends JpaRepository<CaseParty, Long>, JpaSpecificationExecutor<CaseParty> {
}
