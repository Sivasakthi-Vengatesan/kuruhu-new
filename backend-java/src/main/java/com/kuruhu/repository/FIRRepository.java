package com.kuruhu.repository;

import com.kuruhu.entity.FIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FIRRepository extends JpaRepository<FIR, Long>, JpaSpecificationExecutor<FIR> {
}
